(ns puzzles.algorithms-test
  (:require [puzzles.algorithms :as algorithms]
            [clojure.test :refer :all]))

(deftest binary-search
  (is
   (= 20 (algorithms/binary-search [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97] 73))

   ))
