import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

test_cases = open(sys.argv[1], 'r')


def capitalize_word(file_line):
  words = [word[0].upper() + word[1:] for word in file_line.split()]
  return " ".join(words)


for test in test_cases:
  print capitalize_word(test.strip())
test_cases.close()
