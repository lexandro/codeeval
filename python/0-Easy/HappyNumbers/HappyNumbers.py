import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def digit_squares_sum(number):
  return sum([int(i) ** 2 for i in str(number)])


def happy_numbers(fileLine):
  number = int(fileLine)
  sums = []
  while not number in sums:
    sums.append(number)
    number = digit_squares_sum(number)

  print 1 if 1 in sums else 0


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  happy_numbers(test)
test_cases.close()
