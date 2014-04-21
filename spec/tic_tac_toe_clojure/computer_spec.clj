(ns tic-tac-toe_clojure.computer
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.computer :refer :all]))
 
(describe "get-computer-move"
  (it "gets a random, valid move"
    (let [current-board { 1 "" 2 "X" 3 "X" 4 "O" 5 "O" 6 "X" 7 "O" 8 "X" 9 "X"}]
      (should= 1 (get-computer-move current-board)))))
