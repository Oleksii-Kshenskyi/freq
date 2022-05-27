~~# freq~~

Freq is a command line tool for frequency analysis of human languages based on books or other long texts.

## How it works

Freq is a command line tool. It works the following way:

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
~~1. Skeleton of the console interface.~~


2. Extracting text out of both plain text files and PDFs.
3. Counting the number of times a specific word is encountered in the text.
4. Trimming the words (removing spaces, punctuation etc.).
5. Outputting the results as a plain text report into a file.
6. Choosing file type based on magic strings
7. Do proper error handling
8. Handle command line arguments efficiently with a command line library of sorts, with the possibility of adding more optional arguments to enhance processing
9. Start converting the app to functional Scala and refactoring it.
10. Add analysis data:
    - overall number of words in the text
    - number of different words
    - groups of different words (by times encountered)
    - total number of these groups
    - number of words that are encountered only once
    - percentage of one-shot words ((encountered once) / (number of different words))
11. Add the functionality to look up frequency stats of a single word.
12. To be considered: the possibility of customizing the analysis based on the specific language the text is written in (like deconjugation etc.).
13. To be considered: different types of reports.
14. To be considered: any other types of text analysis to help with language learning?