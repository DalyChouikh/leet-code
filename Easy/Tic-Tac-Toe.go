package main

import "fmt"

func tictactoe(moves [][]int) string {
	board := [3][3]rune{}
	for i, move := range moves {
		row, col := move[0], move[1]
		if i%2 == 0 {
			board[row][col] = 'X'
		} else {
			board[row][col] = 'O'
		}
	}

	checkWin := func(player rune) bool {
		for i := 0; i < 3; i++ {
			if board[i][0] == player && board[i][1] == player && board[i][2] == player {
				return true
			}
			if board[0][i] == player && board[1][i] == player && board[2][i] == player {
				return true
			}
		}
		if board[0][0] == player && board[1][1] == player && board[2][2] == player {
			return true
		}
		if board[0][2] == player && board[1][1] == player && board[2][0] == player {
			return true
		}
		return false
	}
	if checkWin('X') {
		return "A"
	}
	if checkWin('O') {
		return "B"
	}

	if len(moves) < 9 {
		return "Pending"
	}

	return "Draw"
}

func main() {
	fmt.Println(tictactoe([][]int{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}))                                 // Player A wins
	fmt.Println(tictactoe([][]int{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}))                         // Player B wins
	fmt.Println(tictactoe([][]int{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}})) // Draw
	fmt.Println(tictactoe([][]int{{0, 0}, {1, 2}}))                                                         // Pending
}
