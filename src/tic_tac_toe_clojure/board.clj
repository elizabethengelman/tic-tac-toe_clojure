(ns tic_tac_toe_clojure.board
	   (:use [tic_tac_toe_clojure.player]))

(defn display-empty-board[]
  (println "__|__|__\n__|__|__\n  |  |  ")) ; don't want display empty board to actually print!

(defn create-numbered-board-for-display[]
  " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ") ; don't want this to to actually print!

(defn create-blank-board[]
	{ 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""})

(defn get-move[player-number]
  (if (= player-number 0)
    (def move (Integer. (get-player1-move)))
    (def move (Integer. (get-player2-move))))
    move)

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn update-board[current-board player-number]
	 (print (get-mark player-number))
	 (print (assoc current-board (get-move player-number) (get-mark player-number)))
	 (assoc current-board (get-move player-number) (get-mark player-number)))


