(ns tic_tac_toe_clojure.player
	(:use [tic_tac_toe_clojure.cli]
				[tic_tac_toe_clojure.utility]))

(defn ask-for-move[player-number]
	(if (= player-number 0)
		(print-message "Player 1, where would you like to place your X?")
		(print-message "Player 2, where would you like to place your O?"))
	(def move (get-input-from-user))
	(if (is-a-number move)
		(Integer. move)
		0))
