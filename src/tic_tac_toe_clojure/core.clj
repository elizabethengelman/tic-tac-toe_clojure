(ns tic_tac_toe_clojure.core
    (:use [tic_tac_toe_clojure.board]
          [tic_tac_toe_clojure.player] 
          [tic_tac_toe_clojure.cli]
          [tic_tac_toe_clojure.rules]
          [tic_tac_toe_clojure.game]
          [tic_tac_toe_clojure.setup]))

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
          (switch-player opponent current-player)
          (update-board current-board current-player)))))
    (goodbye-messages current-player board)))

(defn -main[]
   (start-the-game)
   (get-opponent)
   (set-starter)
   (game-loop opponent starter))
  