import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def reversed_words(fileLine):
  words = fileLine.split(" ")
  print " ".join(words[::-1])


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  reversed_words(test)
test_cases.close()
