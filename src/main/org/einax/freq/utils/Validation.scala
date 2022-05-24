package org.einax.freq.utils

import java.nio.file.{Files,Paths}

class Validation {
    def validate(args: Array[String]): Boolean = {
        for(validator <- validators) {
            if !validator(args) then return false
        }

        true
    }

    def getMessage(): String = message

    private var validators: List[Array[String] => Boolean] = List()
    private var message: String = String()
}

object Validation {
    def init(): Validation = {
        var v = Validation()
        v.validators = List(((args: Array[String]) => {
            if args.length.compare(2) == 0 then true else { v.message = Validation.FRQ_ARGS_CNT; false }
        }), ((args: Array[String]) => {
            if Files.exists(Paths.get(args(0))) then true else { v.message = Validation.FRQ_IN_NOEX; false }
        }), ((args: Array[String]) => {
            if Files.exists(Paths.get(args(1))) then { v.message = Validation.FRQ_OUT_EX; false } else true
        }))
        v.message = String()

        v
    }

    private val FRQ_ARGS_CNT = "Argument count is not right. Expecting 2 arguments: input and output file names."
    private val FRQ_IN_NOEX = "Input file does not exist."
    private val FRQ_OUT_EX = "Output file already exists. Refusing to overwrite an existing file. Please delete first."
}
