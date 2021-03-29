(ns com-com.auth.views
  (:require [com-com.routes :as r]
            [stylefy.core :as style]
            [com-com.components.card :refer [card]]
            [com-com.components.button :refer [button]]
            [com-com.components.list :refer [cclist]]
            [com-com.components.input :refer [input]]
            [fork.reagent :as fork]))

(defn validate [values]
  (let [email (get values "email" "")
        password (get values "password" "")]
    (cond-> {}
      (not (re-matches #".+@.+\..+" email))
      (assoc "email" "Email must be valid")
      (< (count password) 6)
      (assoc "password" "Password must be 6 or more digits")
      (empty? email)
      (assoc "email" "Email must be not empty"))))

(def page-style {:display :flex
                 :flex-direction :column
                 :justify-content :center
                 :align-items :center
                 :height "100vh"
                 :padding 0
                 :gap "20px"
                 :margin 0})

(defn login-page []
  [:div (style/use-style page-style)
   [card {:align-items :flex-start} [cclist {:items ["one" "two" "three"]}]]
   [fork/form {:validation validate
               :on-submit #(js/console.log (:values %))
               :prevent-default? true}
    (fn [{:keys [values
                 errors
                 handle-change
                 handle-submit]}]
      [:form {:on-submit handle-submit}
       [card {:align-items :center}
        [:h3 "Login"]
        [input {:placeholder "Email"
                :html-type :email
                :name "email"
                :value (values "email")
                :on-change #(handle-change %)}]
        [input {:placeholder "Password"
                :name "password"
                :value (values "password")
                :on-change handle-change 
                :html-type :password}]

        [button {:html-type :submit
                 :disabled? (seq errors)} "Enter"]]])]])

(defmethod r/panels :login-panel [] [login-page])
