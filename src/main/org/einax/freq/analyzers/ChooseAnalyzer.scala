package org.einax.freq.analyzers

import org.einax.freq.analyzers.Analysis

object ChooseAnalyzer {
    def basedOnAnalysisType(analysisType: Int): Analyzer = {
        analysisType match {
            case Analysis.FREQUENCY_ANALYSIS_TYPE => DummyAnalyzer()
            case _ => DummyAnalyzer()
        }
    }
}
