(ns tic_tac_toe_clojure.board
	   (:use [tic_tac_toe_clojure.player]
           [tic_tac_toe_clojure.cli]))

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


(defn print-out-the-winner[player-number]
  (if (= player-number 1)
    (print-message "Player 1 wins!")
    (print-message "Player 2 wins!")))

(defn is-there-a-winner[current-board]
  ; (if (=(get current-board 1) "X") 
  ;   "X"
  ;   nil
  "X"
  )

(defn check-game-status[board]
    (cond 
      (= (is-there-a-winner board) "O")
        "over"
      (= (is-there-a-winner board) "X")
        "over"
      (not= "" (some #{""} (vals board)))
        "over"
      :else
        "not over"))

    ;this should do this:
    ;if (some #{""} (vals board)) != nil
    ;return "over"  AND print out that there's a tie

    ;if this method finds a winner, it prints out who the winner is AND returns true - probably should change to only do one thing, duh
; if the board is full
; "over"
; if play1 wins 
; "over"
; if player2 wins
; "over"
; else
; "not over"


(defn print-game-status[current-board]
  (let [winner (is-there-a-winner current-board)]
      (cond 
        (= winner "X")
          "Player 1 wins! Way to go X's!"
        (= winner "O")
          "Player 2 wins! Way to go O's!"
        :else "It's a tie!")))

(defn its-a-tie?[board]
  (= nil (some #{""} (vals board))))

(defn update-board[current-board player-number]
    (assoc current-board (get-move player-number) (get-mark player-number)))

(defn print-board[current-board] ;NEED TO FIX THIS!
    (print (get current-board 1) " |"
    (get current-board 2) "|"
    (get current-board 3) "\n"
    (get current-board 4) "|"
    (get current-board 5) "|"
    (get current-board 6) "\n"
    (get current-board 7) "|"
    (get current-board 8) "|"
    (get current-board 9) "\n"))    

