(ns tic_tac_toe_clojure.player
	(:use [tic_tac_toe_clojure.cli]))

(defn get-player1-move[]
  (print-message "Player 1, where would you like to place your X?")
  (get-input-from-user))

(defn get-player2-move[]
  (print-message "Player 2, where would you like to place your O?")
  (get-input-from-user))