(ns bricks.routes.home
  (:use ring.util.response)
  (:require
    [bricks.models.db :as db]
    [bricks.views.layout :refer :all]))


(defn index []
  (base))

(defn trade []
  (db/get-my-player-with-team 4))
