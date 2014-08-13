import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def rightmost_char(fileLine):
  line, char = fileLine.split(",")
  print line.rfind(char)


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  rightmost_char(test)
test_cases.close()
