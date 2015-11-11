(ns bricks.mongo
  (:require [monger.core :as mg]))

(def db
  (atom {}))

(defn connect [dbname]
  (reset! db (mg/get-db (mg/connect) dbname)))
