(ns freq.core
 (:require [freq.extraction :as e]
           [freq.analysis :as a]
           [freq.report :as r])
  (:gen-class))

(defn -main [& args]
  (System/setProperty "file.encoding" "UTF-8")
  (if (== (count args) 2)
    (let [input-file (nth args 0)
          output-file (nth args 1)]
      (->> input-file
           (e/extract-text)
           (a/analyze-text)
           (r/freq-map-to-report)
           (r/report-to-file output-file)))

    (println "WHOOPS: Expected exactly 2 arguments: input and output file!")))