import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def find_a_writer(fileLine):
  encrypted, key = fileLine.split('|')
  positions = [int(k) - 1 for k in key.split()]
  writer = [encrypted[i] for i in positions]
  return "".join(writer)


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print find_a_writer(test)
test_cases.close()
