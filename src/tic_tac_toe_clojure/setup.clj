(ns tic_tac_toe_clojure.setup
	(:use [tic_tac_toe_clojure.cli]
				[tic_tac_toe_clojure.board]))

(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

(defn ask-for-opponent[]
  (print-message "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb')."))

(defn set-opponent[]
  (if (= (get-input-from-user) "dumb")
    (def opponent "dumb computer")
    (def opponent "human")))

(defn first-or-second[]
  (print-message "Would you like to go first or second?")
  (if (= (get-input-from-user) "first")
    0
    2))

(defn set-starter[]
  (if (= opponent "dumb computer")
    (def starter (first-or-second))
    (def starter (Integer. 0))))

