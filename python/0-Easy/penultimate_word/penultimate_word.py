import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  print test.strip().split()[-2]
test_cases.close()
