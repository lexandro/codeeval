from math import sqrt

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def is_prime(number):
  for i in xrange(2, int(sqrt(number) + 1)):
    if number % i == 0:
      return False
  return True

def is_palindrome(number):
  text = str(number)
  if text == text[::-1]:
    return True
  return False


for i in xrange(1000, 0, -1):
  if is_palindrome(i) and is_prime(i):
    print i
    break

