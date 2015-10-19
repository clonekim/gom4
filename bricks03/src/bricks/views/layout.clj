(ns bricks.views.layout
  (:require
    [hiccup.page :as page]))


(defn template [content]
  (page/html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
     [:title "bricks"]
     (page/include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")]
    [:body
     [:div {:class "navbar-header"}
      [:button {:class "navbar-toggle"
                :type "button"
                :data-toggle "collapse"
                :data-target "#navbar"}
       [:span.icon-bar]
       [:span.icon-bar]
       [:span.icon-bar]]
      [:a {:href "/" :class "navbar-brand"} "Bricks"]]

     [:nav {:id "navbar" :class "collapse navbar-collapse"}
      [:ul {:class "nav navbar-nav"}
       [:li [:a "Getting started"]]
       [:li [:a "How to use"]]]
      [:ul {:class "nav navbar-nav navbar-right"}
       [:li [:a {:href "/sign-in"} "Sign-in"]]
       [:li [:a {:href "/sign-up"} "Sign-up"]]]]
      [:div {:class "container" :id "main"} content]
     ]
   ))

(defn index-template []
  (template
    [:div]))

(defn signin-template []
   (template
      [:div.modal-dialog
       [:div.modal-content
        [:div.modal-body
         [:form {:post "/sign-in"}
          [:div.form-group
           [:label {:for "email"} "Email"]
           [:input.form-control {:id "email" :placeholder "Email"}]]
          [:div.form-group
           [:label {:for "password"} "Password"]
           [:input.form-control {:id "password" :placeholder "Password"}]]
          [:button {:class "btn btn-default" :type "submit"} "Sign-in"]]]]]))

