(ns fluokitten-test.core
  (:use [uncomplicate.fluokitten.core :refer [fmap! fmap fold foldmap]]
        [uncomplicate.neanderthal core native]
        [criterium.core]))

(def n 100000)
(def nx (dv (range n)))
(def ny (dv (range n)))
(defn p+ ^double [^double x ^double y] (+ x y))
(defn p* ^double [^double x ^double y] (* x y))

(defn -main
  []
  (with-progress-reporting (quick-bench (foldmap p+ 0.0 p* nx ny)))
  )
