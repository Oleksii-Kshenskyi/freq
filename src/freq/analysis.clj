(ns freq.analysis
  (:require [clojure.string :as str]))

(defn strip-punct [text] (str/replace text #"[\p{Punct}]" ""))
(defn split-by-space [text] (str/split text #"\s+"))

(defn analyze-text [text]
  (->> text 
       (strip-punct)
       (str/lower-case)
       (split-by-space)
       (frequencies)))