(ns puzzles.inverse-yoda
  (:require [clojure.string :as string]
            [clojure.string :as str]))

(defn reorder
  [sentence]
  (->> (string/split sentence #", ")
       (map #(str (string/trim %) "."))
       (reverse)
       (string/join)))

(defn reconstruct
  [sentence]
  (apply str (->> (string/split sentence #"\.")
                  (string/join " ")
                  (string/capitalize))
         "."))

(defn ayoda
  [yoda-speak]
  (prn)
  (->> (map
        (fn [sentence]
          (->> sentence
               reorder
               reconstruct))
        (string/split yoda-speak #"\."))
       (string/join " ")))

(ayoda "Talk like this, Yoda does.")

(ayoda "Translate back to normal, you must")

(ayoda "Fun, Clojure is. Learn it, I will.")

(ayoda "Do or do not. There is no try.")
