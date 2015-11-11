(ns bricks.models.account
  (:use bricks.mongo)
  (:require [monger.collection :as mc])
  (:import (org.bson.types ObjectId)))


(defn create-user [email password]
  (mc/insert-and-return @db "accounts" {:email email :password password}))



(defn delete-user [id]
  (if-let [oid (
                 try
                    (ObjectId. id)
                    (catch Exception e
                      (prn "Wrong id")))]
    (.getN (mc/remove-by-id @db "accounts" oid))))




(defn login [email password]
  (println (str "finding email: " email ", password: " password))
  (mc/find-one-as-map @db "accounts" {:email email :password password}))




(defn get-user [param]
  (if-let [id (try
                (ObjectId. (get param :id))
                (catch Exception e))]
    (mc/find-one-as-map @db "accounts" { :_id id})))



(defn get-users []
  (mc/find-maps @db "accounts"))
