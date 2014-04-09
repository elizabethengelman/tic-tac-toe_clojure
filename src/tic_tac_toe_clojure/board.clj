(ns tic_tac_toe_clojure.board)

(defn display-empty-board[]
  (println "__|__|__\n__|__|__\n  |  |  ")) ; don't want display empty board to actually print!

(defn create-numbered-board-for-display[]
  " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ") ; don't want this to to actually print!

(defn create-blank-board[]
	{ 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""})

(defn update-board[board position mark]
	(assoc board position mark))