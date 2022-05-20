import java.io.{File, FileInputStream, FileWriter}
import org.apache.tika.Tika
import org.apache.tika.parser.*
import org.apache.tika.metadata.*
import org.apache.tika.sax.WriteOutContentHandler
import org.apache.tika.parser.pdf.PDFParser

object PdfExtractor {
    def main(args: Array[String]): Unit = {
        val source: String = args(0)
        val dest: String = args(1)
        val pdf_file: File = new File(source)
        val output_file = new FileWriter(dest)
        val pdf_stream = new FileInputStream(pdf_file)

        val pdf_parser = new PDFParser()
        val handler = new WriteOutContentHandler(-1)
        val metadata = new Metadata()
        val context = new ParseContext()
        pdf_parser.parse(pdf_stream, handler, metadata, context)
        output_file.write(handler.toString())
        output_file.close()
        pdf_stream.close()
    }
}