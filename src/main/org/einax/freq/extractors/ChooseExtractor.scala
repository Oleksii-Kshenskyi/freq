package org.einax.freq.extractors

object ChooseExtractor {
    def basedOnFileType(fileName: String): Extractor = {
        getFileExtension(fileName.toLowerCase()) match {
            case "pdf" => PdfExtractor(fileName)
            case _ => PdfExtractor(fileName)
        }
    }

    private def getFileExtension(fileName: String): String = {
        if(fileName.contains('.'))
            fileName.take(fileName.lastIndexOf('.'))
        else fileName
    }
}
