import sys

def modulo(fileLine):
  n, m = fileLine.split(',')
  n, m = int(n), int(m)

  print n-((n/m)*m)

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  if len(test) == 0:
    continue
  modulo(test)
test_cases.close()
