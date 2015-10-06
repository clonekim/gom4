(ns bricks.models.mongo
  (:require
    [monger.core :as mg]
    [monger.collection :as mc]))



(defn insert-test []
  (let [conn (mg/connect)
        db (mg/get-db conn "bricks-test")
        doc "documents"
        ]
    (mc/insert db doc {:first_name "John" :last_name "Lennon"})))
