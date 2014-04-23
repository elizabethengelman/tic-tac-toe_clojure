(ns tic_tac_toe_clojure.computer
	(:use [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]))

(declare minimized-move)

(defn get-computer-move[current-board]
  (print-message "The computer is going...")
  (loop [computer-move (rand-int 10)]
    (if (valid-move? computer-move current-board)
      computer-move
      (recur (rand-int 10)))))

(defn get-smart-move[current-board turn-number]
	(print-message "The smart computer is making a move...")
	(print "Turn number: " turn-number "\n")
	(if (or (= turn-number 0) (= turn-number 1))
		5
		1))

(defn score[board]
	(cond 
		(= (winner? board) "X")
			-1
		(= (winner? board) "O")
			1
		(not= "" (some #{""} (vals board)))
		  0))

(defn available-moves[board]
	(for [space [1 2 3 4 5 6 7 8 ]
    :let [empty-space (get board space)]
    :when (= "" empty-space)]
    space))

(defn update-for-minimax[current-board move mark]; this is the same as the update-board method in the game ns
	(assoc current-board move mark))							 ; how else could I do this? if include game, i have a cyclic 
																								 ;dependency issue

; (defn run-minimax[board player-number]
; 		(for [empty-space (available-moves board)]
; 			:let[updated-board (update-for-minimax board empty-space "O")]
; 			)




; 	)





(defn maximized-move[current-board]
	(loop [path-score 0
				 available-moves (available-moves current-board)
				 current-board current-board]
		(if (game-over? current-board)
			path-score
			(recur 
				(+ path-score (minimized-move current-board))
				(rest available-moves)
				(update-for-minimax current-board (first available-moves) "X")))))
			

		; 	update the board with the first avail spot
		; if game is NOT over return the path score, and do the minimaxin' again
		; else if game is over, if there's a winner

(defn minimized-move[current-board] ;just a randomized space for now
  (loop [path-score 0
  			 available-moves (available-moves current-board)
  			 current-board current-board]
  (if (game-over? current-board)
  	(* -1 path-score)
  	(recur
  		(+ path-score (maximized-move current-board))
  		(rest available-moves)
  		(update-for-minimax current-board (first available-moves) "O")))))




;   (loop [computer-move (rand-int 10)]
;     (if (valid-move? computer-move current-board)
;       computer-move
;       (recur (rand-int 10)))))

;(dissoc board 1 ) -> removes the first element from the board

; (remove #{2} [1 2 3] )
;=> (1 3)

; (pop [1 2 3])
;=> [1 2]

	; (loop [board-key 1
	; 			available-moves []]
	;   (if (= board-key 10)
	;   	available-moves
	;   	(recur 
	;   		(+ board-key 1)
	;   		(if (= (get board board-key) "") (into available-moves [(get board board-key)]))))))

