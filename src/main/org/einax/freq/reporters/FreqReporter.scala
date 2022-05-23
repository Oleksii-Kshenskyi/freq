package org.einax.freq.reporters

import org.einax.freq.analyzers.Analysis
import org.einax.freq.utils.Utils
import scala.collection.immutable.ListMap
import java.lang.StringBuilder

class FreqReporter extends Reporter {
    def reportToFile(fileName: String, analysis: Analysis): Unit = Utils.stringToFile(analysisToString(analysis), fileName)

    private def analysisToString(analysis: Analysis): String = {
        var resultReport = StringBuilder()
        val sorted = ListMap(analysis.freqAnalysisMap.toSeq.sortWith(_._2 > _._2): _*)

        sorted.zipWithIndex.foreach(
            (item, index) => resultReport.append(s"${index + 1}. ${item._1}: ${item._2};").append(System.lineSeparator)
        )

        resultReport.toString
    }
}
