(ns bricks.views.jade_config
  (:require
    [clj-jade.core :as jade]
    [clojure.java.io :as io]))


(jade/configure {:template-dir "public" ;classpath에서 로딩안됨 bug
                 :pretty-print false
                 :cache? true})
