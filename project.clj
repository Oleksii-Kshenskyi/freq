(defproject freq "0.1.0-dev"
  :description "A small utility for frequency analysis of texts."
  :license {:name "MIT"
            :url "http://unlicense.org/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [org.apache.pdfbox/pdfbox "2.0.26"]]
  :repl-options {:init-ns freq.core}
  :main freq.core
  :aot [freq.core])
