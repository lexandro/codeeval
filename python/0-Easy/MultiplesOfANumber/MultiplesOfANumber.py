import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

def multiples_of_a_number(fileLine):
  x, n = fileLine.split(',')
  x, n = int(x), int(n)
  multiplier=n
  while(n<x):
    n+=multiplier
  print n

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  multiples_of_a_number(test)
test_cases.close()
