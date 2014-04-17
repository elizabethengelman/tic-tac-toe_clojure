(ns tic_tac_toe_clojure.game
	(:use [tic_tac_toe_clojure.player]
        [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]))

(defn change-player[opponent current-player]
    (cond 
      (= opponent "dumb computer")
        (if (= current-player 0)
          2
          0)
      (= opponent "human")
        (- 1 current-player)))

(defn get-computer-move[current-board]
  (print-message "The computer is going...")
  (loop [computer-move (rand-int 10)]
    (if (valid-move? computer-move current-board)
      computer-move
      (recur (rand-int 10)))))

(defn get-human-move[player-number current-board]
    (loop [move (ask-for-move player-number)]
      (if (valid-move? move current-board)
        move
        (recur(ask-for-move player-number)))))

(defn get-move[player-number current-board]
  (cond 
    (= player-number 0)
      (get-human-move player-number current-board)
    (= player-number 1)
      (get-human-move player-number current-board)
    (= player-number 2)
      (get-computer-move current-board)))

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn update-board[current-board player-number] ;perhaps this should be in the game class
    (assoc current-board (get-move player-number current-board) (get-mark player-number)))

(defn game-outcome[current-board]
  (if (winner? current-board)
    (cond 
      (= (who-wins? current-board) "X")
        "Player 1 wins! Way to go X's!"
     (= (who-wins? current-board) "O")
        "Player 2 wins! Way to go O's!")
        "It's a tie!"))

