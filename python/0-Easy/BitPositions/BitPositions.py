import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def get_bit(number, position):
  return (number >> (position - 1)) & 1


def bit_positions(fileLine):
  n, p1, p2 = (int(i) for i in fileLine.split(","))
  bit1 = get_bit(n, p1)
  bit2 = get_bit(n, p2)
  print "true" if bit1 == bit2 else "false"


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  bit_positions(test)
test_cases.close()
