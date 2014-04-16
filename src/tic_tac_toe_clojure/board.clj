(ns tic_tac_toe_clojure.board
	   (:use [tic_tac_toe_clojure.player]
           [tic_tac_toe_clojure.cli]))

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

(defn display-empty-board[]
  (println "__|__|__\n__|__|__\n  |  |  ")) 

(defn create-numbered-board-for-display[]
  " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 ") ; don't want this to to actually print!

(defn create-blank-board[]
	{ 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""})

(defn get-move[player-number]
  (if (= player-number 0)
    (def move (Integer. (get-player1-move)))
    (def move (Integer. (get-player2-move))))
    move)

(defn get-mark[player-number]
  (if (= player-number 0)
    (def mark "X")
    (def mark "O"))
    mark)

(defn update-board[current-board player-number]
    (assoc current-board (get-move player-number) (get-mark player-number)))
  
; (defn print-out-the-winner[player-number]
;   (if (= player-number 1)
;     (print-message "Player 1 wins!")
;     (print-message "Player 2 wins!")))

; (defn is-there-a-winner[current-board]
;   (loop [current-line-index 0
;          current-line (get winners current-line-index)]
;     (if (and
;         (apply = (map #(get current-board %)current-line))
;         (not= (get current-board (get current-line 0)) "")
;         )
;       (get current-board (get current-line 0))
;       (recur
;         (+ current-line-index 1)
;         (print-message "this is the current line"))
;       )))

(defn its-a-winner?[current-board winners-index]
  (and
    (not= (get current-board (first (get winners winners-index))) "")
    (apply = (map #(get current-board %) (get winners winners-index)))))

; (defn winner?[current-board]
;   (def outcome (loop [winners-index 0
;         there-is-a-winner []]
;     (if (> winners-index 7)
;       there-is-a-winner
;       (recur
;         (+ winners-index 1)
;         (into there-is-a-winner (repeat 1 (its-a-winner current-board winners-index)))))))
;     (print outcome)
;     (if (= (some true? outcome) true)
;       true
;       false))

(defn winner?[current-board]
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

(defn game-outcome[current-board]
  (let [winner (winner? current-board)]
      (cond 
        (= winner true)
          "Player 1 wins! Way to go X's!"
        (= winner true)
          "Player 2 wins! Way to go O's!"
        :else "It's a tie!")))

(defn print-board[current-board] ;NEED TO FIX THIS!
    (print (get current-board 1) " |"
    (get current-board 2) "|"
    (get current-board 3) "\n"
    (get current-board 4) "|"
    (get current-board 5) "|"
    (get current-board 6) "\n"
    (get current-board 7) "|"
    (get current-board 8) "|"
    (get current-board 9) "\n"))    

