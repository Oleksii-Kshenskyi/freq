package org.einax.freq.utils

import java.io.{FileWriter}

object Utils {
    def stringToFile(string: String, fileName: String): Unit = {
        val writer = FileWriter(fileName)
        writer.write(string)
        writer.close()
    }
}
