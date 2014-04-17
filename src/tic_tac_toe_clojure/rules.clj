(ns tic_tac_toe_clojure.rules)

(def winners
  [[1 2 3] ;0
   [4 5 6] ;1
   [7 8 9] ;2
   [1 4 7] ;3
   [2 5 8] ;4
   [3 6 9] ;5
   [1 5 9] ;6
   [3 5 7] ;7
   ])

(defn its-a-winner?[current-board winners-index]
  (and
    (not= (get current-board (first (get winners winners-index))) "")
    (apply = (map #(get current-board %) (get winners winners-index)))))

(defn winner?[current-board]
  (def winning-line (loop [
         there-is-a-winner false
         winners-index 0]
    (if (or (= there-is-a-winner true) (= winners-index 8))
      winners-index
       (recur
          (its-a-winner? current-board winners-index)
          (+ winners-index 1)))))
    (if (< winning-line 8)
      (get current-board (get(get winners (- winning-line 1)) 0))
      nil))

(defn game-over?[board]
  (cond
    (winner? board)
      true
    (not= "" (some #{""} (vals board)))
      true
    :else
      false))                                                             ;the next get gives the value at index 0, ie 1
                                                                ;the next get gives us the value at 1 in the board, to give us an X or O
(defn valid-move?[move current-board] ;should this be in game or rules?
  (and
    (= (get current-board move) "")
    (not= nil (some #{move} '(1 2 3 4 5 6 7 8 9)))))
