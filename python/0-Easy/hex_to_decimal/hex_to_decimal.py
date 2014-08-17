import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def hex_to_decimal(fileLine):
  return int(fileLine, 16)


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print hex_to_decimal(test)
test_cases.close()
