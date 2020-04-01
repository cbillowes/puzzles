(ns puzzles.hashtag-headings
  (:require [clojure.string :as string]))

(defn ->hashtags
  "https://gist.github.com/ericnormand/6218548273971aef0c31bf50f0bacb67
   - three longest words in the headline
   - ordered longest to shortest
   - with a # in front
   - if there are fewer than three words, use as many words as there are
   - if two words are of the same length, prefer the one that occurs
     closest to the beginning
   - hashtags are typically all lowercase"
  [headline]
  (->> (string/split headline #" ")
       (filter #(not (string/includes? % "-")))
       (map #(str "#" (string/lower-case %)))
       (sort #(> (count %1) (count %2)))
       (take 3)))
