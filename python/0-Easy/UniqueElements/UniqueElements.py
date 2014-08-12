import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  numbers = sorted(set([int(item) for item in test.split(',')]))
  print ','.join((str(number) for number in numbers))
test_cases.close()
