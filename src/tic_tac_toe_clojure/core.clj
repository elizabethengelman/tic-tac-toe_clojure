(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]))
 
(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

(defn game-loop[]
  (loop [game 0
         turn-counter 0 
	       current-player 0 
         current-board { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}
        ] 
   (if (or (= turn-counter 10) (check-for-winner current-board))
      current-player 
      (recur
        (print-board current-board)
        (+ turn-counter 1)
        (- 1 current-player)
        (update-board current-board current-player)    
        ))))

(defn -main[]
   (start-the-game)
   (game-loop))
