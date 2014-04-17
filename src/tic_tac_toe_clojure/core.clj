(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]
          [tic_tac_toe_clojure.rules]
          [tic_tac_toe_clojure.game]))
 
(defn ask-computer-or-human[]
  (print-message "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb')."))

(defn set-opponent[]
  (def opponent (get-input-from-user)))

(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

(defn game-loop[]
  (let [current-board (create-new-board)] 
      (def board   
      (loop [game "in progress"
             turn-counter 0 
	           current-player 0 
             current-board current-board] 
      (if (game-over? current-board)
        current-board 
        (recur
          (print-board current-board)
          (+ turn-counter 1)
          (- 1 current-player)
          (update-board current-board current-player )))))
    (print-board board) 
    (print-message "Game over!")
    (print-message (game-outcome board))))

(defn -main[]
   (ask-computer-or-human)
   (set-opponent)
   (start-the-game)
   (game-loop))
  

;TODO
  ;user chooses who goes first
  ;user chooses if they want to play against the computer
      ; or another human
  ;