(ns bricks.models.canvas
  (:use bricks.mongo)
  (:require [monger.collection :as mc]))


(defn save-canvas [canvas]
    (mc/insert-and-return @db "canvas" canvas))
