(ns tic-tac-toe_clojure.game_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.game :refer :all]))

(describe "tic_tac_toe_clojure.game"
	(around [it]
		(with-out-str (it)))

  (describe "change-player"
    (it "returns 0 or 1 if it is a human vs human game"
      (should= 1 (switch-player "human" 0)))
    (it "returns 0 or 2 if the user is playing the computer"
      (should= 2 (switch-player "dumb computer" 0))))

  (describe "get-move"
    (it "gets the human move if the player number is 1"
      (let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
        (should= 9
          (with-in-str "9"
            (get-move 0 current-board 1))))))

  (describe "get-mark"
  	(it "gets the current player's mark (X or O)"
    	(should= "X" (get-mark 0))
   	 	(should= "O" (get-mark 1))))

  (describe "update-board"
    (it "updates a given board"
      (should= { 1 "" 2 "O" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} (update-board {1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 2 "O"))))

  (describe "game-outcome"
  	(it "returns that player 1 wins"
  		(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
  			(should= "Player 1 wins! Way to go X's!" (game-outcome current-board))))
  	(it "returns that player 2 wins"
  		(let [current-board { 1 "O" 2 "O" 3 "O" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
  			(should= "Player 2 wins! Way to go O's!" (game-outcome current-board))))
  	(it "returns that there's a tie"
  		(let [current-board { 1 "X" 2 "O" 3 "X" 4 "X" 5 "O" 6 "X" 7 "O" 8 "X" 9 "O"}]
  			(should= "It's a tie!" (game-outcome current-board))))))
