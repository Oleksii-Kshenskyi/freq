package org.einax.freq.analyzers

trait Analyzer {
    def analyze(text: String): Analysis
}
