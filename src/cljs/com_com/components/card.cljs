(ns com-com.components.card
  (:require [stylefy.core :as style]))

(defn card-style [{:keys [align-items width]}]
  {:padding "16px"
   :background-color "#fefeef"
   :border "2px dashed #7f7f7f"
   :border-radius "8px"
   :display :flex
   :flex-direction :column
   :gap "8px"
   :justify-content :flex-start
   :min-width width
   :align-items align-items})

(defn card [{:keys [align-items width]
             :or {width "10%"}} & children]
  [:div
   (style/use-style (card-style {:align-items align-items
                                 :width width}))
   (into [:<>] children)])
