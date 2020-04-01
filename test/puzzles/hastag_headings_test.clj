(ns puzzles.hastag-headings-test
  (:require [puzzles.hashtag-headings :as heading]
            [clojure.test :refer :all]))

(deftest parse-sentence
  "Imagine you work for a newspaper and you're job is to automatically post
   news articles to Twitter. Of course, you need hash tags. Write a function
   that takes the headline (as a string) and returns a list of hashtags.
   The hashtags should be the three longest words in the headline, ordered
   longest to shortest, and of course, with a # in front. If there are fewer
   than three words, use as many words as there are. If two words are of the
   same length, prefer the one that occurs closest to the beginning."

  (testing "example 1"
    (let [actual (heading/->hashtags "Violently Bored Americans Begin Looting Puzzle Stores")
          expected '("#violently" "#americans" "#looting")]
      (is (= expected actual))))

  (testing "example 2"
    (let [actual (heading/->hashtags "Trump Quietly Checks With Aides To Make Sure He’d Be Included In Receiving $1,000 Government Checks")
          expected '("#government" "#receiving" "#included")]
      (is (= expected actual))))

  (testing "example 3"
    (let [actual (heading/->hashtags "Nation Demands More Slow-Motion Footage Of Running Basset Hounds")
          expected '("#demands" "#footage" "#running")]
      (is (= expected actual)))))
