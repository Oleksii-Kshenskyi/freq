import sys
import pdfplumber

def extract_text(source, dest):
    reader = pdfplumber.open(source)

    text = ""
    for page in reader.pages:
        text += page.extract_text()
        
    with open(dest, "w") as output_file:
        output_file.write(text)
        
    reader.close()
        

def main():
    source = sys.argv[1]
    dest = sys.argv[2]
    extract_text(source, dest)

if __name__ == "__main__":
    main()