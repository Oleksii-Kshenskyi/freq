package org.einax.freq.analyzers

import org.einax.freq.utils.Utils

class FreqAnalyzer extends Analyzer {
    def analyze(text: String): Analysis = {
        val words = text.replaceAll("""[\p{Punct}]""", "").toLowerCase.split("\\s+")
        
        val analysis = Analysis()
        words.foreach(word => analysis.freqAnalysisMap(word) += 1)

        analysis
    }
}
