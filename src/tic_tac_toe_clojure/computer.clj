	(ns tic_tac_toe_clojure.computer
	(:use [tic_tac_toe_clojure.rules]
        [tic_tac_toe_clojure.cli]
        [tic_tac_toe_clojure.board]))

(declare get-best-move)
(declare negamax)

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

(defn get-score[board player-mark]
	(cond
		(and (not= (winner? board) player-mark) (not= (winner? board) nil))
			-1 ;lose
		(= (winner? board) player-mark)
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

(defn score-move [board mark move]
	(let [updated-board (update-for-minimax board move mark)]
		(if (game-over? updated-board)
				[(get-score  updated-board mark) move]
				[(* -1 (first (negamax updated-board (switch-player-mark mark)))) move])))

(defn negamax [board mark]
	(let [moves (available-moves board)]
		(apply max-key first (map (partial score-move board mark) moves))))

(defn get-best-move[board computer-mark]
	(second (negamax board computer-mark)))


