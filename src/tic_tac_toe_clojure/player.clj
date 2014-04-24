(ns tic_tac_toe_clojure.player
	(:use [tic_tac_toe_clojure.cli]
				[tic_tac_toe_clojure.utility]))

(defn prompt-for-move[player-number]
	(if (= player-number 0)
		(print-message "Player 1, where would you like to place your X?")
		(print-message "Player 2, where would you like to place your O?")))

(defn get-move-from-player[]
	(def move (get-input-from-user))
	(if (is-a-number move)
		(Integer. move)
		0))

(defn ask-for-move[player-number]
	(prompt-for-move player-number)
	(get-move-from-player))
