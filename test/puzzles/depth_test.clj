(ns puzzles.depth-test
  (:require [puzzles.depth :as deeply-nested-collection]
            [clojure.test :refer :all]))

(deftest find-the-depth-of-a-nested-collection
  "Talk like this, Yoda does. Translate back to normal,
   you must.Clojure code often deals with deeply nested collections.
   Find the depth of a nested structure."

  (testing "A number"
    (let [actual (deeply-nested-collection/depth 0)
          expected 0]
      (is (= expected actual))))

  (testing "An empty vector"
    (let [actual (deeply-nested-collection/depth [])
          expected 1]
      (is (= expected actual))))

  (testing "A nested vector"
    (let [actual (deeply-nested-collection/depth [[0] [2] [1 [2]]])
          expected 3]
      (is (= expected actual))))

  (testing "A nested map"
    (let [actual (deeply-nested-collection/depth {:a "a" {:b "b"} {:c {:d "d"}}})
          expected 2]
      (is (= expected actual)))))
