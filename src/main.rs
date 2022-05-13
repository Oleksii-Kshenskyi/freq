use clap::{Command, Arg};

fn main() {
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

    println!("Path to the text file: {}", clap_matches.value_of("file_with_text").unwrap());
    println!("Path to the output file: {}", clap_matches.value_of("output_report").unwrap());
}
