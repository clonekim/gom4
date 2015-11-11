(ns bricks.core-test
  (:require [clojure.test :refer :all]
            [bricks.mongo :refer :all]
            [bricks.models.account :as account]
            [bricks.models.canvas :as  canvas]
            [monger.util :as mt]))

(connect "bricks-test")

(deftest create-test
  (let [x (account/create-user "x" "y")]
    (is (not (mt/get-id x) nil))))
