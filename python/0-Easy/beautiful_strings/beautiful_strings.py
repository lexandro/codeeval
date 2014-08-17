import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""


def calculate_character_occurrence(text):
  char_occurrences = {}
  for char in text:
    if char.isalpha() and char not in char_occurrences:
      char_occurrences[char] = text.count(char)
  return char_occurrences


def calculate_beautiness(occurrences):
  value = 26
  sum = 0
  for i in occurrences:
    sum += i * value
    value -= 1
  return sum


def beautiful_strings(fileLine):
  char_occurrences = calculate_character_occurrence(fileLine.lower())
  occurrences = sorted(char_occurrences.values(), reverse=True)
  return calculate_beautiness(occurrences)


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
  test = test.strip()
  print beautiful_strings(test)
test_cases.close()
