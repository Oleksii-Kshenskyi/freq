package org.einax.freq.reporters

import org.einax.freq.analyzers.Analysis

import java.io.{File,FileWriter}

class FreqReporter extends Reporter {
    def reportToFile(fileName: String, analysis: Analysis): Unit = {
        val writer = FileWriter(fileName)
        writer.write(analysisToString(analysis))
        writer.close()
    }

    private def analysisToString(analysis: Analysis): String = {
        "WRITE SOMETHING"
    }
}
