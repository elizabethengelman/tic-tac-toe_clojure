(ns tic-tac-toe_clojure.player_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.player :refer :all]))

(describe "tic-tac-toe_cli.core"
  (around [it]
    (with-out-str (it)))
  
  (describe "prompt-for-move"
    (it "prompts user for their move"
    	(should= "Player 1, where would you like to place your X?\n"
  	 (with-out-str
  	 (prompt-for-move 0)))))

  (describe "get-move-from-player"
    (it "gets move from the user"
      (should= 2
      (with-in-str "2"
      (get-move-from-player)))))

  (describe "get-human-move"
    (it "gets the move of the current player if its a valid move"
      (let [current-board { 1 "" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
        (should= 1 
          (with-in-str "1"
          (get-player-move 0 current-board)))))
    
    (it "continues to prompt player if they input an invalid move")))