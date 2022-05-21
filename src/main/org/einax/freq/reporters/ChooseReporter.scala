package org.einax.freq.reporters

import org.einax.freq.analyzers.Analysis

object ChooseReporter {
    def basedOnAnalysisType(analysisType: Int): Reporter = {
        analysisType match {
            case Analysis.FREQUENCY_ANALYSIS_TYPE => FreqReporter()
            case _ => FreqReporter()
        }
    }
}
