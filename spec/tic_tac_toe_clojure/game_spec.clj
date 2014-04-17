(ns tic-tac-toe_clojure.game_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.game :refer :all]))

(describe "tic_tac_toe_clojure.game"
	(around [it]
		(with-out-str (it)))

  (describe "change-player"
    (it "returns 0 or 1 if it is a human vs human game"
      (should= 1 (change-player "human" 0)))
    (it "returns 0 or 2 if the user is playing the computer"
      (should= 2 (change-player "dumb computer" 0))))

  (describe "get-computer-move"
    (it "gets a random, valid move"
      (let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
        (should= 1 (get-computer-move current-board)))))

  (describe "get-human-move"
  	(it "gets the move of the current player if its a valid move"
    	(let [current-board { 1 "" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
    		(should= 1 
      		(with-in-str "1"
      		(get-move 0 current-board)))))
  	(it "continues to prompt player if they input an invalid move"))
  
  (describe "get-mark"
  	(it "gets the current player's mark (X or O)"
    	(should= "X" (get-mark 0))
   	 	(should= "O" (get-mark 1))))

  (describe "update-board"
    (it "updates a given board"
      (should= { 1 "" 2 "O" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 
        (with-in-str "2"
        (update-board {1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 1)))))

  (describe "game-outcome"
  	(it "returns that player 1 wins"
  		(let [current-board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
  			(should= "Player 1 wins! Way to go X's!" (game-outcome current-board))))
  	(it "returns that player 2 wins"
  		(let [current-board { 1 "O" 2 "O" 3 "O" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
  			(should= "Player 2 wins! Way to go O's!" (game-outcome current-board))))
  	(it "returns that there's a tie"
  		(let [current-board { 1 "O" 2 "X" 3 "O" 4 "X" 5 "O" 6 "X" 7 "O" 8 "O" 9 "X"}]
  			(should= "Player 2 wins! Way to go O's!" (game-outcome current-board))))))
