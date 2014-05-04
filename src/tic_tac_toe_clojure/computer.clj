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
		(get-best-move current-board "O"))

(defn get-score[board player-mark]
	(cond 
		(and (not= (winner? board) player-mark) (not= (winner? board) nil))
			-100 
		(= (winner? board) player-mark)
			100
		(not= "" (some #{""} (vals board)))
		  0 )) 

(defn available-moves[board]
	(for [space [1 2 3 4 5 6 7 8 9]
    :let [empty-space (get board space)]
    :when (= "" empty-space)]
    space))

(defn update-for-minimax[current-board move mark]
	(assoc current-board move mark))							 
																								 
(defn switch-player-mark[current-player-mark]
	(if (= current-player-mark "O")
		"X"
		"O"))

(defn score-move [depth board mark move]
	(let [updated-board (update-for-minimax board move mark)
		    updated-depth (inc depth)]
		(if (game-over? updated-board)
				[(/ (get-score  updated-board mark) updated-depth) move updated-depth]
				[(* -1 (first (negamax updated-board (switch-player-mark mark) updated-depth))) move updated-depth])))
							
(defn negamax [board mark depth] 
	(let [moves (available-moves board)]
	  (apply max-key first (map (partial score-move depth board mark) moves)))) 
 
(defn get-best-move[board computer-mark]	
	(second (negamax board computer-mark 0)))
