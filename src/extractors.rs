/*
Code in this file is responsible for the initial extraction of text from the input file.
Code gets input file name, extracts text from the file and passes it further as a single String.
*/

use std::fs;
use std::error::Error;
use std::path::Path;
use infer;

enum ExtractionKind {
    PDF,
    PlainText,
}

trait TextExtractor {
    fn extract_from_file(file_name: &str) -> Result<String, Box<dyn Error>>;
}

struct PdfExtractor;
impl TextExtractor for PdfExtractor {
    fn extract_from_file(file_name: &str) -> Result<String, Box<dyn Error>> {
        Ok(String::from(file_name))
    }
}

struct PlainTextExtractor;
impl TextExtractor for PlainTextExtractor {
    fn extract_from_file(file_name: &str) -> Result<String, Box<dyn Error>> {
        Ok(fs::read_to_string(file_name)?)
    }
}


pub struct ExtractText;
impl ExtractText {
    pub fn from(file: &str) -> Result<String, Box<dyn Error>> {
        match ExtractText::which_kind(file) {
            ExtractionKind::PDF => PdfExtractor::extract_from_file(file),
            ExtractionKind::PlainText => PlainTextExtractor::extract_from_file(file),
        }
    }

    fn which_kind(file: &str) -> ExtractionKind {
        if Path::new(&file.to_lowercase()).extension().unwrap() == "pdf" &&
        infer::get_from_path(file)
            .expect("infer: cant open file")
            .expect("infer: dont know file type")
            .mime_type() == "application/pdf" {
            ExtractionKind::PDF
        } else {
            ExtractionKind::PlainText
        }

    }
}