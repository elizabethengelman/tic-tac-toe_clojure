(ns tic-tac-toe_clojure.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.board :refer :all]))

(describe "tic-tac-toe_board.core"
  (around [it]
    (with-out-str (it)))
  
  (it "creates an empty board for display"
    (should= "__|__|__\n__|__|__\n  |  |  \n"
    (with-out-str
    (display-empty-board))))

  (it "creates a numbered board for display"
    (should= " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 "
    (create-numbered-board-for-display)))

  (it "creates a blank board"
    (should= { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} (create-blank-board)))


  (it "updates a given board"
    (should= { 1 "" 2 "O" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 
      (update-board {1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 2 "O"))))

