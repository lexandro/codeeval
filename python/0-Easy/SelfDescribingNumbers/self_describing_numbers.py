import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def self_descibing_numbers(fileLine):
  for index, digit in enumerate(fileLine):
    if int(digit) != fileLine.count(str(index)):
      return 0
  return 1


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print self_descibing_numbers(test)
test_cases.close()
