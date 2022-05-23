package org.einax.freq.extractors

object ChooseExtractor {
    def basedOnFileType(fileName: String): Extractor = {
        println(getFileExtension(fileName.toLowerCase))
        getFileExtension(fileName.toLowerCase()) match {
            case "pdf" => PdfExtractor(fileName)
            case _ => PlainTextExtractor(fileName)
        }
    }

    private def getFileExtension(fileName: String): String = {
        if(fileName.contains('.'))
            fileName.drop(fileName.lastIndexOf('.') + 1)
        else fileName
    }
}
