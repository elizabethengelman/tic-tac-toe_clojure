(ns tic_tac_toe_clojure.computer
<<<<<<< HEAD
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
	(if (or (= turn-number 0) (= turn-number 1))
		5
		(print(get-best-move current-board "O"))))

(defn get-score[board]
	(cond
		(= (winner? board) "X")
			-1 ;lose
		(= (winner? board) "O")
			1 ; win
		(not= "" (some #{""} (vals board)))
		  0 )) ;tie

(defn available-moves[board]
	(for [space [1 2 3 4 5 6 7 8 ]
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
				(game-over? updated-board)
					(int(get-score updated-board))
				:else
					(run-minimax updated-board (switch-player-mark current-player-mark)))))

(defn get-best-move[board computer-mark]
	(def possible-moves
		(apply hash-map (interleave (flatten (run-minimax board computer-mark)) (available-moves board))))
	(print possible-moves)
	(if (> (count possible-moves) 1)
		(val (apply max-key possible-moves))
		(first(vals possible-moves))))


