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
      (get-move-from-player))))))