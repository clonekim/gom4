(ns bricks.routes.router

  (:use [ring.util.response]
        [bricks.views.jade-config])

  (:require
    [bricks.models.canvas :as canvas]
    [clj-jade.core :as jade]))


(defn index []
  (jade/render "index.jade"))


(defn sign-in []
  (jade/render "signin.jade"))

; id를 돌려줌
(defn save-canvas [map]
  (.toString (:_id (canvas/save-map map))))
