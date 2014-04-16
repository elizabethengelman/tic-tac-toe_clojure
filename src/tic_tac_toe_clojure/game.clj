(ns tic_tac_toe_clojure.game
	(:use [tic_tac_toe_clojure.player]
        [tic_tac_toe_clojure.rules]))

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn valid-move?[move current-board]
  (and 
    (= (get current-board move) "")
    (not= nil (some #{move} '(1 2 3 4 5 6 7 8 9))))) 

(defn get-move[player-number current-board]
  (loop [move (ask-for-move player-number)]
    (if (valid-move? move current-board)
      move
      (recur(ask-for-move player-number)))))

(defn game-outcome[current-board]
  (cond 
    (= (who-wins? current-board) "X")
      "Player 1 wins! Way to go X's!"
    (= (who-wins? current-board) "O")
      "Player 2 wins! Way to go O's!"
    :else "It's a tie!"))