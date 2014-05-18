(ns tic_tac_toe_clojure.game
	(:use [tic_tac_toe_clojure.player]
        [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]
        [tic_tac_toe_clojure.computer]
        [tic_tac_toe_clojure.board]))

(defn switch-player[opponent current-player]
    (cond 
      (= opponent "dumb computer")
        (if (= current-player 0)
          2
          0)
      (= opponent "human")
        (- 1 current-player)))

(defn get-move[player-number current-board]
  (cond 
    (= player-number 0)
      (get-player-move player-number current-board)
    (= player-number 1)
      (get-player-move player-number current-board)
    (= player-number 2)
      (get-computer-move current-board)))

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn update-board[current-board player-number] 
    (assoc current-board (get-move player-number current-board) (get-mark player-number)))

(defn game-outcome[current-board]
  (if (winner? current-board)
    (cond 
      (= (who-wins? current-board) "X")
        "Player 1 wins! Way to go X's!"
      (= (who-wins? current-board) "O")
        "Player 2 wins! Way to go O's!")
        "It's a tie!"))

(defn goodbye-messages[current-player current-board]
  (print-board current-board)
  (print-message "Game over!")
  (print-message (game-outcome current-player)))

