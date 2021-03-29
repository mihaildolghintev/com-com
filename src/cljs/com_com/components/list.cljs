(ns com-com.components.list
  (:require [stylefy.core :as style]
            [com-com.util.colors :refer [colors]]))

(def list-style {:margin 0
                 :padding 0
                 :list-style :none})

(def list-item-style {:padding "1px 8px"
                      :margin "2px"
                      :background-color (:yellow colors)
                      :border-radius "4px"})

(defn cclist [{:keys [items]}]
  [:ul (style/use-style list-style)
   (doall (for [item items]
      [:li (style/use-style list-item-style {:key item}) item]))])
