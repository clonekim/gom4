(ns bricks.routes.home
  (:use ring.util.response)
  (:require
    [bricks.models.mongo :as mongo]
    [bricks.views.layout :refer :all]))


(defn index []
  (base))

(def test1 []
  (mongo/insert-test))