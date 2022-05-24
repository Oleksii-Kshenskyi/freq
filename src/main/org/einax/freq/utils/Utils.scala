package org.einax.freq.utils

import java.nio.file.{Files,Paths}

object Utils {
    def stringToFile(string: String, fileName: String): Unit =
        Files.write(Paths.get(fileName), string.getBytes)

    def getFileContentType(fileName: String): String = Files.probeContentType(Paths.get(fileName))
}
