(ns freq.core)

(import org.apache.pdfbox.pdmodel.PDDocument 
        org.apache.pdfbox.text.PDFTextStripper
        java.io.File)

(defn pdf-to-text [input-file output-file]
  (let [doc (PDDocument/load (File. input-file))
        text (.getText (PDFTextStripper.) doc)]
    (spit output-file text)))

(defn -main [& args]
  (if (and (seq args) (== (count args) 2))
    (let [input-file (nth args 0)
          output-file (nth args 1)]
      (pdf-to-text input-file output-file))

    (println "WHOOPS: Expected exactly 2 arguments: input and output file!")))



