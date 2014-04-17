(ns tic_tac_toe_clojure.board
	   (:use [tic_tac_toe_clojure.game]))


(defn create-new-board[]
  { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""})

(defn create-numbered-board-for-display[]
  " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ") ; don't want this to to actually print!

(defn update-board[current-board player-number] ;perhaps this should be in the game class
    (assoc current-board (get-move player-number current-board) (get-mark player-number)))

(defn print-board[current-board] ;NEED TO FIX THIS - there has to be a more efficient way to do this.
    (print (get current-board 1) " |"
    (get current-board 2) "|"
    (get current-board 3) "\n"
    (get current-board 4) "|"
    (get current-board 5) "|"
    (get current-board 6) "\n"
    (get current-board 7) "|"
    (get current-board 8) "|"
    (get current-board 9) "\n"))    
