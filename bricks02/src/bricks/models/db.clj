(ns bricks.models.db
  (:require
    [honeysql.core :as sql]
    [honeysql.helpers :refer :all]
    [clojure.java.jdbc :as jdbc]))


(def db
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//127.0.0.1:3306/test"
   :user "test"
   :password ""})


(defn get-my-player [user-id]
  (let [query (sql/format {:select [:* ]
                           :from [:players]
                           :where [:= :id 4]})]
        (println query)
       (jdbc/query db query)))


(defn get-my-player-with-team [palyer-id]
  (jdbc/query db [
         "select * from players a , teams b
        where a.team_id = b.id
        and a.id = ?", palyer-id]))
