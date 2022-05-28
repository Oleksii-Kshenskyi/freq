(ns freq.core
 (:require [freq.extraction :as e]))

(defn -main [& args]
  (System/setProperty "file.encoding" "UTF-8")
  (if (== (count args) 2)
    (let [input-file (nth args 0)
          output-file (nth args 1)]
      (spit output-file (e/extract-text input-file)))

    (println "WHOOPS: Expected exactly 2 arguments: input and output file!")))