(ns democars.insurance.insurance-policy)

(defn insurancePolicyByCar [numberOfDays age recharge]
  (cond
    (and (<= age 25) (>= age 18)) (* (* numberOfDays recharge) 0.25)
    (> age 25) (* numberOfDays recharge)
    :else 0
    ))

(defn applyInsurancePolicy [policy]
  (fn [numberOfDays age recharge]
    (policy numberOfDays age recharge)))

(def policyCars (applyInsurancePolicy insurancePolicyByCar))

(defn calculateInsurancePolicy [numberOfDays age car]
  (let [typeOfCar (:type car)]
    (cond
      (= typeOfCar "small")
      (policyCars numberOfDays age 5)
      (= typeOfCar "sport")
      (policyCars numberOfDays age 7)
      (= typeOfCar "SUV")
      (policyCars numberOfDays age 10))))






