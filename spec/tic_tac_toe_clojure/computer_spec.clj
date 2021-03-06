(ns tic-tac-toe_clojure.computer_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.computer :refer :all]))

(describe "get-computer-move"
  (it "gets a random, valid move"
    (let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
      (should= 1 (get-computer-move current-board)))))

(describe "available-moves"
	(it "returns the keys of all the availble moves on the board"
		(let [current-board { 1 "X" 2 "O" 3 "X" 4 "" 5 "O" 6 "" 7 "" 8 "" 9 "O"}]
			(should= [4 6 7 8] (available-moves current-board)))))

(describe "switch-player-mark"
	(it "switches 'O' to 'X'"
		(should= "X"
			(switch-player-mark "O")))

	(it "switches 'X' to 'O'"
		(should= "O"
			(switch-player-mark "X"))))

(describe "get-best-move"
	(it "returns the best move for the computer"
		(let [current-board { 1 "X" 2 "X" 3 "" 4 "O" 5 "O" 6 "" 7 "X" 8 "X" 9 "O"}]
			(should= 6
				(get-best-move current-board "O")))))

(describe "get-score"
	(it "returns -1 if the current player will lose (current player ='O')"
		(let [current-board { 1 "" 2 "X" 3 "X"
													4 "O" 5 "O" 6 "X"
													7 "O" 8 "X" 9 "X"}]
			(should= -1 (get-score current-board "O"))))

	(it "returns 1 if current player will win (current player ='O')"
		(let [current-board { 1 "" 2 "X" 3 "X"
													4 "O" 5 "O" 6 "O"
													7 "O" 8 "X" 9 "X"}]
			(should= 1 (get-score current-board "O"))))

	(it "returns 0 if it will be tie (current player ='O')"
		(let [current-board { 1 "X" 2 "O" 3 "X"
													4 "X" 5 "O" 6 "X"
													7 "O" 8 "X" 9 "O"}]
			(should= 0 (get-score current-board "O"))))

	(it "returns -1 if the current player will lose (current player ='X')"
		(let [current-board { 1 "" 2 "X" 3 "X"
													4 "O" 5 "O" 6 "O"
													7 "O" 8 "X" 9 "X"}]
			(should= -1 (get-score current-board "X")))))


(describe "switch-player-mark"
	(it "switches 'O' to 'X'"
		(should= "X"
			(switch-player-mark "O")))

	(it "switches 'X' to 'O'"
		(should= "O"
			(switch-player-mark "X"))))


(describe "get-best-move"
	(it "returns the best move for the computer"
		(let [current-board { 1 "X" 2 "X" 3 "" 4 "O" 5 "O" 6 "" 7 "X" 8 "X" 9 "O"}]
			(should= 6
				(get-best-move current-board "O"))))

	(it "blocks its opponent"
		(let [current-board { 1 "X" 2 "" 3 ""
													4 "" 5 "X" 6 ""
													7 "" 8 "O" 9 ""}]
			(should= 9
				(get-best-move current-board "O"))))

	(it "returns 6"
		(let [current-board { 1 "X" 2 "X" 3 ""
													4 "O" 5 "O" 6 ""
													7 "X" 8 "X" 9 ""}]
			(should= 6
				(get-best-move current-board "O")))))

