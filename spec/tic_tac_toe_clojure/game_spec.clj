(ns tic-tac-toe_clojure.game_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.game :refer :all]))

(describe "tic_tac_toe_clojure.game"
	(around [it]
		(with-out-str (it)))

	(describe "valid-move?"
			(it "returns true if valid"
				(let [current-board { 1 "" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
					(should= true (valid-move? 1 current-board))))
		  (it "returns false if the space is already taken"
		  	(let [current-board { 1 "" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
		  		(should= false (valid-move? 2 current-board))))
			(it "returns false if the move is out of the scope of the board"
				(let [current-board { 1 "" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
					(should= false (valid-move? 0 current-board)))))
				
  (describe "get-move"
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
