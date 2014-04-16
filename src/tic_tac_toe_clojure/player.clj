(ns tic_tac_toe_clojure.player
	(:use [tic_tac_toe_clojure.cli]))

(defn is-a-number[str]
  (let [n (read-string str)]
       (if (number? n) n nil)))

(defn ask-for-move[player-number]
	(if (= player-number 0)
		(print-message "Player 1, where would you like to place your X?")
		(print-message "Player 2, where would you like to place your O?"))
	(def move (get-input-from-user))
	(if (is-a-number move)
		(Integer. move)
		0))
