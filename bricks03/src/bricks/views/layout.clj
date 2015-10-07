(ns bricks.views.layout
  (:require
    [hiccup.page :as page]))


(defn base []
  (page/html5
    [:head
      [:title "Index"]
      [:script {:src "jquery.js"}]
     ]
    [:body
      [:div {:class "content"} "Hello World"]
     ]
    )
  )