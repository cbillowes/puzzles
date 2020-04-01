(ns puzzles.depth)

(defn depth
  "https://purelyfunctional.tv/issues/purelyfunctional-tv-newsletter-369-refactoring-replace-body-with-callback/
   Clojure code often deals with deeply nested collections.
   - Find the maximum depth of any given value.
   - Don’t forget the collections include lists, vectors, maps, and sets."
  [data]
  (if (or (map? data)
          (list? data)
          (vector? data)
          (set? data))
    (let [d (count data)]
      (if (zero? d) 1 d))
    0))
