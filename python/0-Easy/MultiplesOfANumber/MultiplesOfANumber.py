import sys

def multiplesOfANumber(fileLine):
  x, n = fileLine.split(',')
  x, n = int(x), int(n)
  multiplier=n
  while(n<x):
    n+=multiplier
  print n

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  multiplesOfANumber(test)
test_cases.close()
