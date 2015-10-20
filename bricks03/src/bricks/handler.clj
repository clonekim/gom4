(ns bricks.handler

  (:use
    ring.middleware.session
    ring.util.response
    bricks.models.canvas )

  (:require
   [ring.adapter.jetty :as ring]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.json :refer [wrap-json-response wrap-json-body wrap-json-params]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [ring.middleware.anti-forgery :refer :all]
   [bricks.routes.router :as router])
  (:gen-class))


(defroutes app-routes
           (GET "/" [] (router/index))
           (GET "/sign-in" [] (router/sign-in))
           (route/not-found "Not Found"))

(def app-routes
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      wrap-json-params
      wrap-json-response))


(def app
  (-> app-routes
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))


(defn -main []
   (connect "bricks-test")
   (ring/run-jetty #'app {:port 8080 :join? false}))
