package org.einax.freq.extractors

import java.io.{File,FileWriter}
import java.io.IOException

class PlainTextExtractor(extractFrom: String) extends Extractor {
    def extractText(): String = {
        val source = scala.io.Source.fromFile(extractFrom)
        val text = source.getLines mkString "\n"

        source.close
        text
    }
}