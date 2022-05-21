package org.einax.freq.extractors

import java.io.{File,FileWriter}
import java.io.IOException

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

class PdfExtractor(extractFrom: String) extends Extractor {
    def extractText(): String = {
        val doc = docFromFileName(extractFrom)
        val text = textFromDoc(doc)

        doc.close()
        text
    }

    private def docFromFileName(fileName: String): PDDocument = PDDocument.load(File(fileName))
    private def textFromDoc(doc: PDDocument): String = PDFTextStripper().getText(doc)

}