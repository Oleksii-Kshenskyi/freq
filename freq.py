import sys
from PyPDF2 import PdfFileReader

def extract_text(source, dest):
    reader = PdfFileReader(source)

    text = ""
    for page in reader.pages:
        text += page.extractText()
        
    with open(dest, "w") as output_file:
        output_file.write(text)
        

def main():
    source = sys.argv[1]
    dest = sys.argv[2]
    extract_text(source, dest)

if __name__ == "__main__":
    main()