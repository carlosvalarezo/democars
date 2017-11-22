(ns democars.business-rules
  (:require [cheshire.core :refer :all]
            [democars.variables.variable :as var]))

(defn getJsonValues [jsonString minimumAge]
  (let [{_rentDates :rentDates _car :car _membership :membership _age :age} jsonString]
    (let [_numberOfDays (var/numberOfDays _rentDates)]
      (let [_subtotal (var/subtotal _numberOfDays _car)]
        (let [_discount (var/totalDiscount _rentDates _numberOfDays _subtotal _car _membership)]
          (let [_insurance (var/insurance _numberOfDays _age _car)]
            (let [_totalPayment (var/totalPayment _subtotal _discount _insurance)]
              (prn (parse-string (generate-string (assoc {} :subtotal _subtotal :insuranceTotal _insurance :discountPercentage _discount :totalPayment _totalPayment) {:pretty true}))))))))))








