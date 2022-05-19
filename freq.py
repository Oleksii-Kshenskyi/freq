import fitz
import sys

def freq(source, dest):
    with fitz.open(source) as doc:
        text = ""
        for page in doc:
            text += page.get_text()
        
        with open(dest, "w") as output_file:
            output_file.write(text)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Need 2 args: source pdf and output txt.")
        sys.exit()
    source = sys.argv[1]
    dest = sys.argv[2]
    freq(source, dest)