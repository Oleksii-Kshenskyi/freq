package org.einax.freq

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

object Freq {
    @JvmStatic fun main(args : Array<String>) {
        System.setProperty("file.encoding", "UTF-8")
        val doc = docFromFileName(args[0])
        val text = textFromDoc(doc)
        doc.close()

        Files.write(Paths.get(args[1]), text.toByteArray())
    }

    private fun docFromFileName(fileName: String): PDDocument {
        return PDDocument.load(File(fileName))
    }
    private fun textFromDoc(doc: PDDocument): String {
        return PDFTextStripper().getText(doc)
    }
}