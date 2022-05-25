package org.einax.freq

import org.einax.freq.extractors.ChooseExtractor
import org.einax.freq.analyzers.ChooseAnalyzer
import org.einax.freq.reporters.ChooseReporter
import org.einax.freq.analyzers.Analysis
import org.einax.freq.utils._

object Freq {
    def main(args: Array[String]): Unit = {
        System.setProperty("file.encoding", "UTF-8")
        val valid = Validation.init()
        val clargs = CLArgs(args)
        val infile: String = Utils.forceOptionOut(clargs.inputFile.toOption)
        val outfile: String = Utils.forceOptionOut(clargs.outputFile.toOption)
        val contentType = Utils.getFileContentType(infile)
        if !valid.validate(Array(infile, outfile), contentType) then {
            println(s"WHOOPS: ${valid.getMessage()}")
            return
        }

        try {
            val extracted_text = ChooseExtractor.basedOnFileType(infile, contentType).extractText()
            val freq_analysis = ChooseAnalyzer.basedOnAnalysisType(Analysis.FREQUENCY_ANALYSIS_TYPE).analyze(extracted_text)
            ChooseReporter.basedOnAnalysisType(Analysis.FREQUENCY_ANALYSIS_TYPE).reportToFile(outfile, freq_analysis)
        }
        catch {
            case e: Exception => println(s"OH NO, UNKNOWN CRITICAL ERROR: ${e.getMessage}")
            case _ => println("Something very bad happened, but no one knows what...")
        }
    }
}
