package org.einax.freq.utils

import java.nio.file.{Files,Paths}

object Utils {
    def stringToFile(string: String, fileName: String): Unit =
        Files.write(Paths.get(fileName), string.getBytes)

    def getFileContentType(fileName: String): String = Files.probeContentType(Paths.get(fileName))

    def forceOptionOut[T](opt: Option[T]): T = {
        opt match {
            case Some(value) => value
            case None => throw new RuntimeException("An option has been forced open, but the value is None.")
        }
    }
}
