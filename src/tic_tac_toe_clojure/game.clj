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
      (= opponent "smart computer")
        (if (= current-player 0)
          3
          0)  
      (= opponent "human")
        (- 1 current-player)))

(defn get-move[player-number current-board turn-number]
  (print "player number: " player-number)
  (cond 
    (= player-number 0)
      (get-player-move player-number current-board)
    (= player-number 1)
      (get-player-move player-number current-board)
    (= player-number 2)
      (get-computer-move current-board)
    (= player-number 3)
      (get-smart-move current-board turn-number)))

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn update-board[current-board move mark] ;get move needs to be given to this board, instead of calling get-move
    (assoc current-board move mark))

(defn game-outcome[current-board]
  (cond 
    (= (winner? current-board) "X")
        "Player 1 wins! Way to go X's!"
    (= (winner? current-board) "O")
        "Player 2 wins! Way to go O's!"
    :else
      "It's a tie!"))

(defn goodbye-messages[current-player current-board]
  (print-board current-board)
  (print-message "Game over!")
  (print-message (game-outcome current-player)))

