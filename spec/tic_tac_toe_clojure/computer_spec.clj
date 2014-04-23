(ns tic-tac-toe_clojure.computer_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.computer :refer :all]))
 
(describe "get-computer-move"
  (it "gets a random, valid move"
    (let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
      (should= 1 (get-computer-move current-board)))))


(describe "score"
	(it "returns -1 if the human (X) will win"
		(let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
			(should= -1 (score current-board))))

	(it "returns 1 if the computer (O) will win"
		(let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "O" 7 "O" 8 "X" 9 "X"}]
			(should= 1 (score current-board))))

	(it "returns 0 if it will be tie"
		(let [current-board { 1 "X" 2 "O" 3 "X" 4 "X" 5 "O" 6 "X" 7 "O" 8 "X" 9 "O"}]
			(should= 0 (score current-board)))))

(describe "available-moves"
	(it "returns the keys of all the availble moves on the board"
		(let [current-board { 1 "X" 2 "O" 3 "X" 4 "" 5 "O" 6 "" 7 "" 8 "" 9 "O"}]
			(should= [4 6 7 8] (available-moves current-board)))))

(describe "switch-players"
	(it "returns computer if the current player is human"
		(should= "computer" (switch-players "human")))
	(it "returns human if the current player is computer"
		(should= "human" (switch-players "computer"))))

(describe "minimax"
	(it "returns the correct move"
		(let [current-board { 1 "" 2 "X" 3 "O" 4 "" 5 "X" 6 "" 7 "" 8 "" 9 "O"}]
			(should= 8	
				(run-minimax)))))