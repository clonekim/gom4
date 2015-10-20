(ns bricks.models.canvas
  (:require [monger.core :as mg]
            [monger.collection :as mc]))


(def db
   (atom (mg/get-db (mg/connect) "bricks-test")))

;(def db
;  (atom {}))

(defn connect [dbname]
   (println (str "Connecting Mongodb [" dbname "]"))
   (reset! db (mg/get-db (mg/connect) dbname)))


(defn save-map [canvas]
    (mc/insert-and-return @db "canvas" canvas))

(defn login [email password]
   (mc/find-one @db "accounts" {:email email :password password}))
