(ns bricks.routes.router
  (:use ring.util.response)
  (:require
    [bricks.models.canvas :as canvas]
    [bricks.views.layout :refer :all]))


(defn index []
  (index-template))

(defn sign-in []
  (signin-template))

(defn sign-in-post [email password]
  (println email)
  (println password)
  (signin-template)
  ;(nil?  (canvas/login email password))
  )


; id를 돌려줌
(defn save-canvas [map]
  (.toString (:_id (canvas/save-map map))))
