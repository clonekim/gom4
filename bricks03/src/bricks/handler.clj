(ns bricks.handler

  (:use
    ring.middleware.session
    ring.util.response )

  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body wrap-json-params]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.anti-forgery :refer :all]
            [bricks.routes.home :as home]))


(defroutes app-routes
           (GET "/" [] (home/index))
           (POST "/test" [color description]
             (response
                 {:id (home/save-canvas
                        {:color color :description description})}))
           (route/not-found "Not Found"))

(def app-routes
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      wrap-json-params
      wrap-json-response))


(def app
  (-> app-routes
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))