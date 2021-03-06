(defproject bricks "0.1.5"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [clj-jade "0.1.7"]
                 [com.novemberain/monger "3.0.1"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler bricks.handler/app}
  :main bricks.handler)
