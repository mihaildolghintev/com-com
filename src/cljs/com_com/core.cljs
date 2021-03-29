(ns com-com.core
  (:require
   [reagent.dom :as rdom]
   [stylefy.core :as style]
   [re-frame.core :as re-frame]
   [com-com.events :as events]
   [com-com.routes :as routes]
   [com-com.views :as views]
   [com-com.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/start!)
  (style/init)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
