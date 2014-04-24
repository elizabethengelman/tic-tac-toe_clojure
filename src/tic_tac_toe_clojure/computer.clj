(ns tic_tac_toe_clojure.computer
	(:use [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]))

(declare minimized-move)
(declare get-best-move)

(defn get-computer-move[current-board]
  (print-message "The computer is going...")
  (loop [computer-move (rand-int 10)]
    (if (valid-move? computer-move current-board)
      computer-move
      (recur (rand-int 10)))))

(defn get-smart-move[current-board turn-number]
	(print-message "The smart computer is making a move...")
	(print "Turn number: " turn-number "\n")
	; (if (or (= turn-number 0) (= turn-number 1))
	; 	5
		(get-best-move current-board "O"))

(defn get-score[board player-marker]
	(cond 
		(= (winner? board) player-marker)
			-1 ;lose
		(not= (winner? board) player-marker)
			1 ; win
		(not= "" (some #{""} (vals board)))
		  0 )) ;tie

(defn available-moves[board]
	(for [space [1 2 3 4 5 6 7 8 9]
    :let [empty-space (get board space)]
    :when (= "" empty-space)]
    space))

(defn update-for-minimax[current-board move mark]; this is the same as the update-board method in the game ns
	(assoc current-board move mark))							 ; how else could I do this? if include game, i have a cyclic 
																								 ;dependency issue

(defn switch-player-mark[current-player-mark]
	(if (= current-player-mark "O")
		"X"
		"O"))

(defn run-minimax[board current-player-mark]
		(for [empty-space (available-moves board)
				:let[updated-board (update-for-minimax board empty-space current-player-mark)]]
			
			(cond
				; (= "O" (winner? board))
				(game-over? updated-board)
					(get-score updated-board current-player-mark)
				:else
					(run-minimax updated-board (switch-player-mark current-player-mark)))))
					
(defn get-best-move[board computer-mark]	
	(def possible-moves
		(apply hash-map (interleave (available-moves board) (flatten(run-minimax board computer-mark)))))
	(print possible-moves "\n")
	(key (apply max-key val possible-moves)))

			
	; (if (> (count possible-moves) 1)
	; 	(val (apply max-key possible-moves))
	; 	(first (vals possible-moves))))

; (if (= "O" (winner? board))




; (winning-move-available? player-marker board (generate-winning-combinations)) (get-score player-marker altered-board)
; 					(= (count (empty-spaces board)) 1) (get-score player-marker board)
; 					:else (* -1 (apply max (flatten (negamax altered-board (alternate-player-marker player-marker) 1)))))))

; _________________Notes_________________
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

