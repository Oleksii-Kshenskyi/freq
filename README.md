# freq
Freq is a command line tool for frequency analysis of human languages based on books or other long texts.

## How it works

Freq is a command line tool written in Rust. It works the following way:

1. Take an input file with a text in any spaces-separated human language:
  - File can be plain text;
  - File can be PDF.
2. Analyze the text:
  - Count the number of times individual words are encountered in the text.
  - In the future, deconjugating words into their dictionary forms in specific languages is also planned.
3. Output the results in a form of a simple text file report.
  - For now consists of: the word, the number of times encountered, its resulting place in the list (the number: 1 is the most times encountered, 2 is lower, etc.).
  - Other data is possible in the future.

Specific examples of usage are to be written once the tool is ready.

## Current Goals

~~1. Skeleton of the console interface, using Clap.~~


2. Extracting text out of both plain text files and PDFs.
3. Counting the number of times a specific word is encountered in the text.
4. Trimming the words (removing spaces, punctuation etc.).
5. Outputting the results as a plain text report into a file.
6. To be considered: the possibility of customizing the analysis based on the specific language the text is written in (like deconjugation etc.).
7. To be considered: different types of reports.
8. To be considered: any other types of text analysis to help with language learning?