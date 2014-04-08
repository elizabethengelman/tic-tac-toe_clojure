(ns tic-tac-toe_clojure.core)

(defn print-message[message]
  (println message))

(defn get-input-from-user[]
  (read-line))

(defn display-empty-board[]
  (println "__|__|__\n__|__|__\n  |  |  "))

(defn display-numbered-board[]
  (println " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 "))

(defn new-board[]
 [" " " " " " " " " " " " " " " "]
)

(defn update-board[board-vector]
  (println "This is from the update-board method")  
(assoc board-vector 1 "X")
)

(defn game-loop[]
  (loop [turn-counter 0 
	current-player 0
        current-board [" " " " " " " "]] 
   (if (= turn-counter 10)
      current-player 
      (recur
        (+ turn-counter 1)
        (- 1 current-player)
        (println current-board)))))

(defn start-the-game[]
   (print-message "Welcome to Tic Tac Toe!\n")
   (print-message "Player 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n")
   (display-numbered-board)
)

(defn -main[]
   (start-the-game)
   (print-message "Player 1, where would you like to place your X?")
   (game-loop))
