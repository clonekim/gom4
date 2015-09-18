(ns bricks.handler
  (:use 
  	 ring.middleware.session
  	 ring.util.response )
  	 
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body wrap-json-params]]
		    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]            
            [ring.middleware.anti-forgery :refer :all]  ))


(defn myip [request]
   {:your_ip (:remote-addr request) })

(defroutes app-routes       
  (GET "/what-my-ip" request (response (myip request))
  (GET "/set/:value" [value]
    (assoc (redirect "/") :session {:value value}))

  (GET "/" { {:keys [value], :or {value "no data"}} :session}
    (println (str "--> " value))
    (str "value = " value))  
  (route/not-found "Not Found"))

 
(def app-routes
	(-> app-routes		
	  (wrap-json-body {:keywords? true :bigdecimals? true})
		wrap-json-params
		wrap-json-response))
 
	              
(def app
 (-> app-routes   
   (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))
