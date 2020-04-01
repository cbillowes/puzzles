(ns puzzles.inverse-yoda-test
  (:require [puzzles.inverse-yoda :as yoda]
            [clojure.test :refer :all]))

(deftest parse-sentence
  "Talk like this, Yoda does. Translate back to normal, you must."

  (testing "A single Yoda-style sentence"
    (let [yoda-speak "Talk like this, Yoda does."
          actual (yoda/ayoda yoda-speak)
          expected "Yoda does talk like this."]
      (is (= expected actual))))

  (testing "End sentence with a full stop"
    (let [yoda-speak "Translate back to normal, you must"
          actual (yoda/ayoda yoda-speak)
          expected "You must translate back to normal."]
      (is (= expected actual))))

  (testing "Multiple Yoda-style sentences"
    (let [yoda-speak "Fun, Clojure is. Learn it, I will."
          actual (yoda/ayoda yoda-speak)
          expected "Clojure is fun. I will learn it."]
      (is (= expected actual))))

  (testing "Multiple ordinary sentences"
    (let [speak-ordininarily "Do or do not. There is no try."
          actual (yoda/ayoda speak-ordininarily)
          expected speak-ordininarily]
      (is (= expected actual)))))
