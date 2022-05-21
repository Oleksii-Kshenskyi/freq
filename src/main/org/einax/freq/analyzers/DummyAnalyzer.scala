package org.einax.freq.analyzers

class DummyAnalyzer extends Analyzer {
    def analyze(text: String): Analysis = Analysis()
}
