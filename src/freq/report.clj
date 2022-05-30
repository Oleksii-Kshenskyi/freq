(ns freq.report)

;; fn map-to-list(map: HashMap) -> Vec<(i64, String)>
;; map - the result of analysis' analyze-text() function
;; returns - a vector of pairs, sorted (descending), v[0] is count of occurrences, v[1] is the word
(defn freq-map-to-vector [freq-map]
  (->> freq-map
       (into [])
       (sort-by last #(compare %2 %1))
       (into [])))

(defn report-line [counter word occurrences]
  (str counter ". " word ": " occurrences ";" (System/lineSeparator)))

;; fn list-to-report(list: Vec<(i64, String)>) -> String
;; list - the result of map-to-list
;; returns - list of strings of the format: "<place>. <word>: <count-occurs>;"
(defn report-to-file [filename report] (spit filename report))

(defn vector-to-report [freq-list]
  (loop [index 0 acc ""]
    (if (< index (count freq-list))
      (recur (inc index) 
             (str acc (report-line (inc index) (first (get freq-list index)) (last (get freq-list index)))))
      acc)))

(defn freq-map-to-report [freq-map]
  (->> freq-map
       (freq-map-to-vector)
       (vector-to-report)))