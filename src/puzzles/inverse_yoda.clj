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
  "https://purelyfunctional.tv/issues/purelyfunctional-tv-newsletter-371-chain-map-filter-and-reduce/
  Talk like this, Yoda does. Translate back to normal, you must.
  - Expect at most one comma in the sentence.
  - If there is no comma, it doesn’t need translation.
  - Try to handle capitals correctly.
  - There may be more than one sentence. Handle all of them."
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
