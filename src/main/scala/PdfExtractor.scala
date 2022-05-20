import java.io.{File,FileWriter};
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

object PdfExtractor {
    def main(args: Array[String]): Unit = {
        val doc = docFromFileName(args(0))
        val text = textFromDoc(doc)
        textToFile(text, args(1))

        doc.close()
    }

    def docFromFileName(fileName: String): PDDocument = PDDocument.load(File(fileName))
    def textFromDoc(doc: PDDocument): String = PDFTextStripper().getText(doc)
    def textToFile(text: String, outFileName: String): Unit = {
        val writer = FileWriter(outFileName)
        writer.write(text)
        writer.close()
    }
}