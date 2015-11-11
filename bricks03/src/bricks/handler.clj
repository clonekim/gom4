(ns bricks.handler

  (:use
    ring.middleware.session
    ring.util.response
    bricks.mongo )

  (:require
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.json :refer [wrap-json-response wrap-json-body wrap-json-params]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [ring.middleware.anti-forgery :refer :all]
   [ring.adapter.jetty :as ring]
   [bricks.routes.router :as router]
   [bricks.models.account :as account]
   [monger.json]
   [clojure.java.io :as io])

  (:gen-class))


(defroutes app-routes

   (GET "/" []
     (router/index))


   (GET "/sign-in" []
     (router/sign-in))


   (POST "/api/signin" {params :params session :session}
     (let [email (last (first params)) password (last (last params))]
        (if-let [user (account/login email password)]
           (assoc (response {:status "ok"}) :session {:email email })
           (status {:status "fail"} 204))))



   (GET "/api/auth" {session :session}
      (println session))


   (GET "/api/users" []
     (response (account/get-users)))


   (GET "/api/users/:id" [id]
     (response (account/get-user {:id id})))


   (POST "/api/users" [email password]
     (response (account/create-user email password)))


   (DELETE "/api/users/:id" [id]
      (if-let [result (account/delete-user id)]
         (cond
           (= result 0) (status {} 204)
           (> result 0) (status {} 200))
         (status {} 400)))


  (POST "/api/upload" [files]
    (let [result {}]
        (for [file files]
          (let [[filename length content-type] [(:filename file) (:length file) (:content-type  file)]]
            (assoc result :filename 1)
            (println result)))))



   (route/not-found "Not Found"))


(def app-routes
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      wrap-json-params
      wrap-json-response))

;for test
;(connect "bricks-test")

(def app
  (-> app-routes
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))


(defn -main []
   (connect "bricks-test")
   (ring/run-jetty #'app {:port 8080 :join? false}))
