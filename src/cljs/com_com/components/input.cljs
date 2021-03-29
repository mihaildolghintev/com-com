(ns com-com.components.input)

(defn input [{:keys [on-change
                     on-blur
                     value
                     name
                     placeholder
                     disabled?
                     html-type]}]
  [:input {:on-change on-change
           :on-blur on-blur
           :name name
           :type html-type
           :value value
           :placeholder placeholder
           :disabled disabled?}])
