import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

test_cases = open(sys.argv[1], 'r')
sum = 0
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  sum += int(test)
print sum
test_cases.close()

