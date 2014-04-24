(ns tic-tac-toe_clojure.rules_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.rules :refer :all]))

(describe "tic_tac_toe_clojure.rules"

	(describe "its-a-winner?"
		(it "returns true if the current line is a winner"
			(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= true (its-a-winner? current-board 0)))))

		(it "returns false if the current line is NOT a winner"
			(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= false (its-a-winner? current-board 1))))

	(describe "winner?"
		(it "returns true when there is a win in a row 1-2-3"
			(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= true (winner? current-board))))

		(it "returns true when there is a win in a row 4-5-6"
    	(let [current-board { 1 "" 2 "" 3 "" 4 "X" 5 "X" 6 "X" 7 "" 8 "" 9 ""}]
      	(should= true (winner? current-board))))

  	(it "returns true when there is a win in a row 7-8-9"
  	  (let [current-board { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "X" 8 "X" 9 "X"}]
    	  (should= true (winner? current-board))))

  	(it "returns true when there is a win in a column 1-4-7"
    	(let [current-board { 1 "X" 2 "" 3 "" 4 "X" 5 "" 6 "" 7 "X" 8 "" 9 ""}]
      	(should= true (winner? current-board))))

  	(it "returns true when there is a win in a column 2-5-8"
    	(let [current-board { 1 "" 2 "X" 3 "" 4 "" 5 "X" 6 "" 7 "" 8 "X" 9 ""}]
      	(should= true (winner? current-board))))

  	(it "returns true when there is a win in a column 3-6-9"
    	(let [current-board { 1 "" 2 "" 3 "X" 4 "" 5 "" 6 "X" 7 "" 8 "" 9 "X"}]
      	(should= true (winner? current-board))))

  	(it "returns true when there is a win in diagonal 1-5-9"
    	(let [current-board { 1 "X" 2 "" 3 "" 4 "" 5 "X" 6 "" 7 "" 8 "" 9 "X"}]
      	(should= true (winner? current-board))))

  	(it "returns true when there is a win in diagonal 1-5-9"
    	(let [current-board { 1 "" 2 "" 3 "X" 4 "" 5 "X" 6 "" 7 "X" 8 "" 9 ""}]
    	  (should= true (winner? current-board))))

		(it "returns false if there is NOT a winner on the board"
			(let [current-board { 1 "X" 2 "" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= false (winner? current-board)))))

	(describe "game-over?"
		(it "returns true if the game is a winner"
			(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= true (game-over? current-board))))

		(it "returns true if there is a tie"
			(let [current-board { 1 "X" 2 "O" 3 "X" 4 "X" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
				(should= true (game-over? current-board))))

		(it "returns false if the game is still in progres"
			(let [current-board { 1 "X" 2 "" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= false (game-over? current-board)))))

	(describe "who-wins?"
		(it "returns X if X wins"
			(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= "X" (who-wins? current-board)))))

		(it "returns O if O wins"
			(let [current-board { 1 "O" 2 "O" 3 "O" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
				(should= "O" (who-wins? current-board)))))
	