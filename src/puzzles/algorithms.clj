(ns puzzles.algorithms)

(defn binary-search
  [data value]
  (loop [min 0
         max (count data)
         guess 0
         tries 0]
    (if (= 10 tries)
      nil

      (if (>= min max)
        -1
        (let [guess (int (Math/floor (/ (+ min max) 2)))
              target (get data guess)]
          (if (= target value)
            guess
            (recur
             (if (< target value) (inc guess) min)
             (if (> target value) (dec guess) max)
             guess
             (inc tries))))))))
