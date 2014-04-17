(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]
          [tic_tac_toe_clojure.rules]
          [tic_tac_toe_clojure.game]))
 
(defn ask-computer-or-human[]
  (print-message "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb')."))

(defn set-opponent[]
  (if (= (get-input-from-user) "dumb")
    (def opponent "dumb computer")
    (def opponent "human")))


(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

(defn change-player[opponent current-player]
    (cond 
      (= opponent "dumb computer")
        (if (= current-player 0)
          2
          0)
      (= opponent "human")
        (- 1 current-player)))

(defn first-or-second[]
  (print-message "Would you like to go first or second?")
  (if (= (get-input-from-user) "first")
    0
    2))

(defn set-starter[]
  (if (= opponent "dumb computer")
    (def starter (first-or-second))
    (def starter (Integer. 0))))

(defn game-loop[opponent current-player]
  (let [current-board (create-new-board)] 
      (def board   
      (loop [game "in progress"
             turn-counter 0 
	           current-player current-player
             current-board current-board] 
      (if (game-over? current-board)
        current-board 
        (recur
          (print-board current-board)
          (+ turn-counter 1)
          (change-player opponent current-player)
          (update-board current-board current-player)))))
    (print-board board) 
    (print-message "Game over!")
    (print-message (game-outcome board))))

(defn -main[]
   (start-the-game)
   (ask-computer-or-human)
   (set-opponent)
   (set-starter)
   (print "this is the opponent you've chosen: "opponent "\n")
   (game-loop opponent starter))
  



; human 1 : 0
; human 2 : 1
; dumb compter : 2

;TODO
  ;user chooses who goes first
  ;user chooses if they want to play against the computer
      ; or another human
  ;