(ns puzzles.topology)

;; https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

;; Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to
;; small details like topography. During his last hike he took exactly n steps.
;; For every step he took, he noted if it was an uphill, U , or a downhill, D  step.
;; Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude.
;; We define the following terms:

;; A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
;; A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
;; Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

;; For example, if Gary's path is s = [DDUUUDD], he first enters a valley 2 units deep.
;; Then he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.

;; Complete the countingValleys function in the editor below.
;; It must return an integer that denotes the number of valleys Gary traversed.

;; countingValleys has the following parameter(s):
;;    n: the number of steps Gary takes
;;    s: a string describing his path

;; Input Format:
;;   The first line contains an integer n , the number of steps in Gary's hike.
;;   The second line contains a single string s, of n characters that describe his path.

;; Constraints:
;;   2 <= n <= 10^6
;;   s[i] either U or D

;; Sample Input:
;;  8 UDDDUDUU
;;  => 1

;; Explanation:
;; If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:
;; He enters and leaves one valley.
;; _/\      _
;;    \    /
;;     \/\/

(defn topology
  [s]
  (loop [directions (clojure.string/split s #"")
         direction (first directions)
         trip []
         altitude 0]
    (if (empty? direction)
      trip
      (let [altitude (if (= "U" direction)
                       (inc altitude)
                       (dec altitude))]
        (recur
         (rest directions)
         (second directions)
         (conj trip [direction altitude])
         altitude)))))

(defn countingValleys
  [n s]
  (->> (topology s)
       (filter #(and (= "D" (first %))
                     (= -1 (second %))))
       (count)))

;; => 1
;; up (1) down (0) down (-1) down (-2) up (-1) down (-2) up (-1) up (0)
(countingValleys 8 "UDDDUDUU")
