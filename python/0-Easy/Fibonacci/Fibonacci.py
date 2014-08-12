import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def fibonacci(n):
  a, b = 0, 1
  for i in xrange(n):
    b += a
    a = b - a
  return a


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  print fibonacci(int(test))
test_cases.close()
