(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]))
 
(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (print-message (create-numbered-board-for-display)))

; (defn do-all-these-things[player, board]
;   (println "this is the player number" player) 
;   (if (= player 0)
;      (def move (Integer. (get-player1-move)))
;      (def move (Integer. (get-player2-move))))
;   ; (print-message (update-board board move))
;   ; (update-board board move)
;      (update-board board move "X")
;   )

; (defn get-move[player-number]
;   (if (= player-number 0)
;     (def move (Integer. (get-player1-move)))
;     (def move (Integer. (get-player2-move)))))

; (defn get-mark[player-number]
;   (if (= player-number 0)
;     (def mark "X")
;     (def mark "O")))


(defn game-loop[]
  (loop [turn-counter 0 
	      current-player 0 
        current-board { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}] 
   (if (= turn-counter 6)
      current-player 
      (recur
        (+ turn-counter 1)
        (- 1 current-player)
        (update-board current-board current-player)    

        ; (assoc current-board (get-move current-player) (get-mark current-player))
          ))))
        ; (do-all-these-things current-player current-board)

(defn -main[]
   (start-the-game)
   (game-loop))
