(ns bricks.routes.router
  (:use ring.util.response)
  (:require
    [bricks.models.canvas :as canvas]
    [bricks.views.layout :refer :all]))


(defn index []
  (template []))

(defn sign-in []
  (signin-template))

(defn sign-up []
  )

; id를 돌려줌
(defn save-canvas [map]
  (.toString (:_id (canvas/save-map map))))
