from math import sqrt

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def is_prime(number):
  for i in primes:
    if number % i == 0:
      return False
    if i > sqrt(number):
      break
  return True


primes = []
number = 2
while len(primes) < 1000:
  if is_prime(number):
    primes.append(number)
  number += 1

print sum(primes)

