(ns tic_tac_toe_clojure.computer
	(:use [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]))

(defn get-computer-move[current-board]
  (print-message "The computer is going...")
  (loop [computer-move (rand-int 10)]
    (if (valid-move? computer-move current-board)
      computer-move
      (recur (rand-int 10)))))

(defn get-smart-move[current-board]
	(print-message "The smart computer is making a move...")
  )

(defn score[board]
	(cond 
		(= (winner? board) "X")
			-1
		(= (winner? board) "O")
			1
		(not= "" (some #{""} (vals board)))
		  0	
			))

(defn available-moves[board]
	(for [x [1 2 3 4 5 6 7 8 ]
    :let [y (get board x)]
    :when (= "" y)]
    x))

; (defn minimax[current-board]
; 	(loop [path-score 0
; 				available-moves (available-moves current-board)
; 				current-board current-board]
; 		(if (not (game-over? current-board))
			
; 			update the board with the first avail spot
; 		if game is NOT over return the path score, and do the minimaxin' again
; 		else if game is over, if there's a winner

; 		))






	; (loop [board-key 1
	; 			available-moves []]
	;   (if (= board-key 10)
	;   	available-moves
	;   	(recur 
	;   		(+ board-key 1)
	;   		(if (= (get board board-key) "") (into available-moves [(get board board-key)]))))))


(defn max_move[])

(defn min_move[])

