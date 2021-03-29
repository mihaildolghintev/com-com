(ns com-com.components.button)

(defn button [{:keys [on-click
                      html-type
                      disabled?]} & children]
  [:button {:on-click on-click
            :type html-type
            :disabled disabled?}
   (into [:<>] children)])
