(ns freq.extraction)

(require '[clojure.string :as str])

(import org.apache.pdfbox.pdmodel.PDDocument
        org.apache.pdfbox.text.PDFTextStripper
        java.io.File)

(defn pdf [filename]
  (let [doc (PDDocument/load (File. filename))
        text (.getText (PDFTextStripper.) doc)]
    text))

(defn txt [filename] (slurp filename))

(def extraction-funcas {"pdf" pdf})

(defn file-extension [filename]
  (let [split-name (str/split filename #"\.")
        n-elems (count split-name)]
    (if (> n-elems  1)
      (last split-name)
      (first split-name))))

(defn get-extraction-func [filename] 
  (get extraction-funcas 
       (file-extension filename) 
       txt))

(defn extract-text [filename]
  (let [extraction-func (get-extraction-func filename)]
    (extraction-func filename)))