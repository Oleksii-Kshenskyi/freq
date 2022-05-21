package org.einax.freq.analyzers

import scala.collection.mutable
import scala.collection.mutable.HashMap

class Analysis {
    var freqAnalysisMap: mutable.HashMap[String, Long] = mutable.HashMap()
}

object Analysis {
    val FREQUENCY_ANALYSIS_TYPE = 0
}