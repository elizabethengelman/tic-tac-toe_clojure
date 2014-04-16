(ns tic-tac-toe_clojure.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.board :refer :all]))

(describe "tic-tac-toe_board.core"
  (around [it]
    (with-out-str (it)))

  (describe "create-new-board"
    (it "creates a new board"
      (should= { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} (create-new-board))))
    
  (describe "create-numbered-board-for-display"
    (it "creates a numbered board for display"
      (should= " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 "
      (create-numbered-board-for-display))))

  (describe "update-board"
    (it "updates a given board"
      (should= { 1 "" 2 "O" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 
        (with-in-str "2"
        (update-board {1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 1)))))

  (describe "print-board"
    (it "prints the current board"
      (let [board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
      (should= "X  | X | X \n  |  |  \n  |  |  \n" 
      (with-out-str (print-board board)))))))
