(ns bricks.views.jade-config
  (:require
    [clj-jade.core :as jade]))

(println "jade !!!")

(jade/configure {:template-dir "resources/public"
                 :pretty-print false
                 :cache? false})
