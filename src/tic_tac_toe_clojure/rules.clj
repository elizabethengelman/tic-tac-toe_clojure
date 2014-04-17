(ns tic_tac_toe_clojure.rules)

(def winners
  [[1 2 3]
   [4 5 6]
   [7 8 9]
   [1 4 7]
   [2 5 8]
   [3 6 9]
   [1 5 9]
   [3 5 7]
   ])

(defn its-a-winner?[current-board winners-index] ;checks if the current line is a winner
  (and
    (not= (get current-board (first (get winners winners-index))) "")
    (apply = (map #(get current-board %) (get winners winners-index)))))

(defn winner?[current-board] ; true if there is a winner, false if not. doesn't tell you who the winner is
  (loop [winners-index 0
         there-is-a-winner false]
    (if (or (> winners-index 7) (= there-is-a-winner true))
      there-is-a-winner
      (recur
        (+ winners-index 1)
        (its-a-winner? current-board winners-index)))))

(defn game-over?[board] 
  (cond
    (winner? board)
      true
    (not= "" (some #{""} (vals board)))    
      true
    :else
      false))

(defn who-wins?[current-board]
  (def winning-line-index 
    (loop [winners-index 0
           there-is-a-winner false]
      (if (= there-is-a-winner true)
        (- winners-index 1)
        (recur
          (+ winners-index 1)
          (its-a-winner? current-board winners-index)))))
  (get current-board (get (get winners winning-line-index)0)))  ;most nested get gives the vector of the winning line, ie [1 2 3]
                                                                ;the next get gives the value at index 0, ie 1
                                                              ;the next get gives us the value at 1 in the board, to give us an X or O
(defn valid-move?[move current-board] ;should this be in game or rules?
  (and 
    (= (get current-board move) "")
    (not= nil (some #{move} '(1 2 3 4 5 6 7 8 9))))) 







