import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def roller_coaster(fileLine):
  result = ""
  flag = True
  for i in range(len(fileLine)):
    letter = fileLine[i]
    if letter.isalpha():
      letter = letter.upper() if flag else letter.lower()
      flag = not flag
    result += letter
  return result


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print roller_coaster(test)
test_cases.close()
