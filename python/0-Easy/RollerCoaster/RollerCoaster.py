import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def rollerCoaster(fileLine):
  result = ""
  flag = True
  for i in range(len(fileLine)):
    letter = fileLine[i]
    if letter.isalpha():
      if flag:
        result += letter.upper()
      else:
        result += letter.lower()
      flag = not flag
    else:
      result += letter
  return result


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print rollerCoaster(test)
test_cases.close()