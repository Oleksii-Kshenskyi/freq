package org.einax.freq

import org.einax.freq.extractors.ChooseExtractor
import org.einax.freq.analyzers.ChooseAnalyzer
import org.einax.freq.reporters.ChooseReporter
import org.einax.freq.analyzers.Analysis
import org.einax.freq.utils.Validation

object Freq {
    def main(args: Array[String]): Unit = {
        System.setProperty("file.encoding", "UTF-8")
        val valid = Validation.init()
        if !valid.validate(args) then {
            println(s"WHOOPS: ${valid.getMessage()}")
            return
        }

        val extracted_text = ChooseExtractor.basedOnFileType(args(0)).extractText()
        val freq_analysis = ChooseAnalyzer.basedOnAnalysisType(Analysis.FREQUENCY_ANALYSIS_TYPE).analyze(extracted_text)
        ChooseReporter.basedOnAnalysisType(Analysis.FREQUENCY_ANALYSIS_TYPE).reportToFile(args(1), freq_analysis)
    }
}
