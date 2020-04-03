(ns puzzles.topology-test
  (:require [puzzles.topology :as topology]
            [clojure.test :refer :all]))

(deftest samples
  (is (= 1 (topology/countingValleys 8 "UDDDUDUU"))))


(let [sample (slurp "resources/samples/topology-1.txt")
      params (clojure.string/split sample #"\n")
      [n s] params]
  (topology/countingValleys n s))
