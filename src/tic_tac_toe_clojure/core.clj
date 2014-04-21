(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]
          [tic_tac_toe_clojure.rules]
          [tic_tac_toe_clojure.game]
          [tic_tac_toe_clojure.setup]))

(defn game-loop[opponent]
  (let [current-board (create-new-board)
        current-player (set-starter opponent)] 
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
              (switch-player opponent current-player)
              (update-board current-board current-player)))))
      (print-board board) 
      (print-message "Game over!")
      (print-message (game-outcome board))))

(defn -main[]
   (start-the-game)
   (game-loop (get-opponent)))
  