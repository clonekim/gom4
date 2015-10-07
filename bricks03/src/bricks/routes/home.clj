(ns bricks.routes.home
  (:use ring.util.response)
  (:require
    [bricks.models.canvas :as canvas]
    [bricks.views.layout :refer :all]))


(defn index []
  (base))

; id를 돌려줌
(defn save-canvas [map]
  (.toString (:_id (canvas/save-map map))))
