package org.einax.freq.utils

import java.nio.file.{Files,Paths}

class Validation {
    def validate(args: Array[String], contentType: String): Boolean = {
        for(validator <- validators) {
            if !validator(args, contentType) then return false
        }

        true
    }

    def getMessage(): String = message

    private var validators: List[(Array[String], String) => Boolean] = List()
    private var message: String = String()
}

object Validation {
    def init(): Validation = {
        var v = Validation()
        v.validators = List(((args: Array[String], contentType: String) => {
            if args.length.compare(2) == 0 then true else { v.message = Validation.FRQ_ARGS_CNT; false }
        }), ((args: Array[String], contentType: String) => {
            if Files.exists(Paths.get(args(0))) then true else { v.message = Validation.FRQ_IN_NOEX; false }
        }), ((args: Array[String], contentType: String) => {
            if Files.exists(Paths.get(args(1))) then { v.message = Validation.FRQ_OUT_EX; false } else true
        }), ((args: Array[String], contentType: String) => {
            if (Validation.knownContentTypes contains contentType) || contentType == null then true else { v.message = Validation.FRQ_NOT_SUPP; false}
        }))

        v.message = String()

        v
    }

    private val FRQ_ARGS_CNT = "Argument count is not right. Expecting 2 arguments: input and output file names."
    private val FRQ_IN_NOEX = "Input file does not exist."
    private val FRQ_OUT_EX = "Output file already exists. Refusing to overwrite an existing file. Please delete first."
    private val FRQ_NOT_SUPP = "Input file's format is not supported."
    private val knownContentTypes = List("application/pdf")
}
