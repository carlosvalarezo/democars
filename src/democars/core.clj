(ns democars.core
  (:require [democars.file-manager :as fm]
            [democars.business-rules :as br])
  (:gen-class))

(defn -main
  "I do magic from here!!!"
  [& args]
  (br/getJsonValues (fm/getJsonData (str "data/democars.json")) 18))
