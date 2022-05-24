package org.einax.freq.extractors

import java.nio.file.Files
import java.nio.file.Paths

object ChooseExtractor {
    def basedOnFileType(fileName: String): Extractor = {
        Files.probeContentType(Paths.get(fileName)) match {
            case "application/pdf" => PdfExtractor(fileName)
            case _ => PlainTextExtractor(fileName)
        }
    }
}
