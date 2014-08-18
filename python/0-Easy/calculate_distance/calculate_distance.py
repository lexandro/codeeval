import sys
import math

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def calculate_distance(fileLine):
  x1, y1, x2, y2 = [int(i) for i in fileLine.replace('(', '').replace(')', '').replace(',', '').split()]
  return int(math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2))


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print calculate_distance(test)
test_cases.close()
