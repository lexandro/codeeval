import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

test_cases = open(sys.argv[1], 'r')


def nice_angles(file_line):
  angle = float(file_line)
  fraction = (angle % 1) * 3600
  ##
  hour = int(angle)
  minute = int(fraction / 60)
  second = int(fraction % 60)
  return "{0:d}.{1:02d}'{2:02d}\"".format(hour, minute, second)


for test in test_cases:
  print nice_angles(test.strip())
test_cases.close()
