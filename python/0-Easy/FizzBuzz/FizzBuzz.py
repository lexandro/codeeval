import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def fizz_buzz(fileLine):
  a, b, n = (int(i) for i in fileLine.split())
  for i in xrange(1, n + 1):
    if i % a == 0 and i % b == 0:
      print "FB",
    elif i % a == 0:
      print "F",
    elif i % b == 0:
      print "B",
    else:
      print str(i),
  print


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  fizz_buzz(test)
test_cases.close()
