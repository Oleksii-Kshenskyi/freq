package org.einax.freq.utils

import org.rogach.scallop._

class CLArgs(arguments: Seq[String]) extends ScallopConf(arguments) {
    version(s"freq version ${getClass.getPackage.getImplementationVersion}.")
    banner("""|
              |Usage: freq <input-file> <output-file>
              |
              |A small utility for frequency analysis of human language texts.
              |It will take a text (e.g. a book) from <input-file> in a supported 
              |format, perform frequency analysis on it and give you the report 
              |back into the <output-file>.
              |Supported file formats are: PDF and TXT.
              |
              |OPTIONS:
              |""".stripMargin)
    val inputFile = trailArg[String](descr = "File with the source text to be analyzed.", required = true)
    val outputFile = trailArg[String](descr = "Path where the result report of the frequency analysis will be written to.", required = true)
    verify()
}
