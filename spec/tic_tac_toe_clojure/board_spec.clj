(ns tic-tac-toe_clojure.board_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.board :refer :all]))

(describe "tic-tac-toe_board.core"
  (around [it]
    (with-out-str (it)))

  ; DISPLAY-EMPTY-BOARD
  (it "creates an empty board for display"
    (should= "__|__|__\n__|__|__\n  |  |  \n"
    (with-out-str
    (display-empty-board))))

  ;CREATE-NUMBERED-BOARD-FOR-DISPLAY
  (it "creates a numbered board for display"
    (should= " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 "
    (create-numbered-board-for-display)))

  ;CREATE-BLANK-BOARD
  (it "creates a blank board"
    (should= { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} (create-blank-board)))


  ;GET-MOVE, also tests get-player1-move and get-player2-move
  (it "gets the move of the current player"
    (should= 1 
      (with-in-str "1"
      (get-move 0 )))

    (should= 4
      (with-in-str "4"
      (get-move 1))))

  ;GET-MARK
  (it "gets the current player's mark (X or O)"
    (should= "X" (get-mark 0))
    (should= "O" (get-mark 1)))

  ;UPDATE-BOARD
  (it "updates a given board"
    (should= { 1 "" 2 "O" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 
      (with-in-str "2"
      (update-board {1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""} 1))))


  ;IS-THERE-A-WINNER
  (it "returns true when there is a win in a row 1-2-3"
    (let [board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in a row 4-5-6"
    (let [board { 1 "" 2 "" 3 "" 4 "X" 5 "X" 6 "X" 7 "" 8 "" 9 ""}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in a row 7-8-9"
    (let [board { 1 "" 2 "" 3 "" 4 "" 5 "" 6 "" 7 "X" 8 "X" 9 "X"}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in a column 1-4-7"
    (let [board { 1 "X" 2 "" 3 "" 4 "X" 5 "" 6 "" 7 "X" 8 "" 9 ""}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in a column 2-5-8"
    (let [board { 1 "" 2 "X" 3 "" 4 "" 5 "X" 6 "" 7 "" 8 "X" 9 ""}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in a column 3-6-9"
    (let [board { 1 "" 2 "" 3 "X" 4 "" 5 "" 6 "X" 7 "" 8 "" 9 "X"}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in diagonal 1-5-9"
    (let [board { 1 "X" 2 "" 3 "" 4 "" 5 "X" 6 "" 7 "" 8 "" 9 "X"}]
      (should= true (is-there-a-winner board))))

  (it "returns true when there is a win in diagonal 1-5-9"
    (let [board { 1 "" 2 "" 3 "X" 4 "" 5 "X" 6 "" 7 "X" 8 "" 9 ""}]
      (should= true (is-there-a-winner board))))

  ;CHECK-GAME-STATUS

  (it "returns 'over' if there-is-a-winner returns 'X'"
    (let [board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
      (should= "over" (check-game-status board))))


  (it "returns 'over' if there-is-a-winner returns 'O'"
    (let [board { 1 "O" 2 "O" 3 "O" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
      (should= "over" (check-game-status board))))


  (it "returns 'over' if there is a tie"
      (let [board { 1 "X" 2 "O" 3 "X" 4 "O" 5 "X" 6 "O" 7 "O" 8 "X" 9 "O"}]
      (should= "over" (check-game-status board))))  

  ;PRINT-GAME-STATUS
  (it "returns that player 1 wins"
    (let [board { 1 "X" 2 "X" 3 "X" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
      (should= "Player 1 wins! Way to go X's!" (game-outcome board))))

 ; (it "returns that player 2 wins"
 ;    (let [board { 1 "O" 2 "O" 3 "O" 4 "" 5 "" 6 "" 7 "" 8 "" 9 ""}]
 ;      (should= "Player 2 wins! Way to go O's!" (game-outcome board))))

  ; (it "displays that it's a tie"
  ;   (let [board { 1 "X" 2 "O" 3 "X" 4 "O" 5 "X" 6 "O" 7 "O" 8 "X" 9 "O"}]
  ;     (should= "It's a tie!" (game-outcome board))))  

  ;PRINT-BOARD
)

