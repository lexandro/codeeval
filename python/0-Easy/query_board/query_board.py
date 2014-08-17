import sys

"""
Author: Robert Stern (lexandro2000@gmail.com)
All of my solutions are available from https://github.com/lexandro/codeeval
"""

board_size = 256


def init_board():
  board = [[0 for x in xrange(board_size)] for x in xrange(board_size)]
  return board


def set_row(board, params):
  row, value = params
  board[row] = [value for x in xrange(board_size)]


def set_col(board, params):
  col, value = params
  for row in board:
    row[col] = value


def query_col(board, param):
  print sum(row[param[0]] for row in board)


def query_row(board, param):
  print sum(board[param[0]])


options = {'SetCol': set_col,
           'SetRow': set_row,
           'QueryCol': query_col,
           'QueryRow': query_row,
}


def process_command(board, command):
  items = [int(item) if item.isdigit() else item for item in command.split()]
  options[items[0]](board, items[1:])


test_cases = open(sys.argv[1], 'r')

board = init_board()

for test in test_cases:
  test = test.strip()
  process_command(board, test)
test_cases.close()
