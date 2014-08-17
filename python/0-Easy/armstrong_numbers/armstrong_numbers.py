import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def is_armstrong_number(fileLine):
  sum = 0
  for digit in fileLine:
    sum += int(digit) ** len(fileLine)
  return sum == int(fileLine)


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print is_armstrong_number(test)
test_cases.close()
