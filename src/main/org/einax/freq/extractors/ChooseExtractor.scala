package org.einax.freq.extractors

object ChooseExtractor {
    def basedOnFileType(fileName: String, contentType: String): Extractor = {
        contentType match {
            case "application/pdf" => PdfExtractor(fileName)
            case _ => PlainTextExtractor(fileName)
        }
    }
}
