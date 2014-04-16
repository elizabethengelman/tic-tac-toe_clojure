(ns tic_tac_toe_clojure.player
	(:use [tic_tac_toe_clojure.cli]))

(defn ask-for-move[player-number]
	(if (= player-number 0)
		(print-message "Player 1, where would you like to place your X?")
		(print-message "Player 2, where would you like to place your O?"))
	(Integer. (get-input-from-user)))