use clap::{Command, Arg};
use std::path::Path;
use std::fs::File;
use std::error::Error;
use std::io::Write;

mod extractors;
use extractors::ExtractText;

fn validate_file_names(input_file: &str, _output_file: &str) -> Result<(), Box<dyn Error>> {
    if !Path::new(input_file).exists() {
        println!("WHOOPSIE: input file does not exist!");
        return Err("WHOOPSIE: input file does not exist!".into())
    }
    Ok(())
}

fn main() -> Result<(), Box<dyn Error>> {
    let clap_matches = Command::new("Freq")
        .about("A simple command line utility for frequency analysis of texts.")
        .arg(
            Arg::new("file_with_text")
                .required(true)
                .help("The path to the text file to analyze.")
                .long_help("The path to the text file to analyze.\nAt the moment, can be either a plain text file or a PDF file.")
        )
        .arg(
            Arg::new("output_report")
                .required(true)
                .help("Name of the output file that is going to contain the result frequency report.")
        )
    .get_matches();

    let input_file = clap_matches.value_of("file_with_text").unwrap();
    let output_file = clap_matches.value_of("output_report").unwrap();
    validate_file_names(input_file, output_file)?;
    

    let mut output = File::create(output_file)?;
    match ExtractText::from(input_file) {
        Err(e) => println!("WHOPSIE: {}", e),
        Ok(out) => write!(output, "{}", out)?,
    }

    Ok(())
}
