(ns tic_tac_toe_clojure.setup
	(:use [tic_tac_toe_clojure.cli]
				[tic_tac_toe_clojure.board]))

(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

(defn ask-for-opponent[]
  (print-message "Please enter who you would you like to play against: 
    a human (type in 'human')
    dumb computer (type in 'dumb computer')
    smart computer (type in 'smart computer')."))

(defn set-opponent[]
  (let [opponent (get-input-from-user)]
    opponent))

(defn get-opponent[]
  (ask-for-opponent)
  (set-opponent))

(defn ask-first-or-second[]
	(print-message "Would you like to go first or second?"))

(defn get-first-or-second-input[opponent]
	(if (= (get-input-from-user) "first")
    0 ;return 0, so Player 1 goes first
    (if (= opponent "dumb computer")
      2
      3))) ; return 2 so the computer goes first

(defn get-starter[opponent]
  (ask-first-or-second)
  (get-first-or-second-input opponent))

(defn set-starter[opponent]
  (if (or (= opponent "dumb computer") (= opponent "smart computer"))
    (get-starter opponent)
    (Integer. 0)))
