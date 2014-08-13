import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def set_intersection(fileLine):
  set_a, set_b = test.split(';')
  intersect = set(set_a.split(',')) & set(set_b.split(','))
  print ','.join(sorted(intersect, key=lambda n: int(n)))


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  set_intersection(test)
test_cases.close()
