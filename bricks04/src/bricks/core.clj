(ns bricks.core
	(:use [org.httpkit.server :only [run-server]]))

(defn app-handler [request]
   {:status 200
    :header {"Content-Type" "text/html"}
    :body "Hello Ring"})
 
 
(defn -main []
   (run-server app-handler {:port 8080}))