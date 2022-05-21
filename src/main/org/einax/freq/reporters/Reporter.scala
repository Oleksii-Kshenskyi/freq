package org.einax.freq.reporters

import org.einax.freq.analyzers.Analysis

trait Reporter {
    def reportToFile(fileName: String, analysis: Analysis): Unit
}
