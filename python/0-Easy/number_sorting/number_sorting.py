import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def number_sorting(file_line):
  print " ".join([('{:.3f}'.format(num)) for num in sorted(float(i) for i in file_line.split(' '))])


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  number_sorting(test)
test_cases.close()
