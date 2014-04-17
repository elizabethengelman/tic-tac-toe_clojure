(ns tic-tac-toe_clojure.setup_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.setup :refer :all]))

(describe "tic_tac_toe_clojure.setup"
	(around [it]
		(with-out-str (it)))

	(describe "start-the-game"
    (it "prints a welcome, info and numbered board"
      (should= "Welcome to Tic Tac Toe!\n\nPlayer 1 will be X's and Player 2 will be O's. This is how the board is numbered:\n\n 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 \n"
      (with-out-str
        (start-the-game)))))

	(describe "ask-for-opponent"
		(it "asks if the user would like to play against the computer or another human"
			(should= "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb').\n"
				(with-out-str
					(ask-for-opponent)))))

	(describe "set-opponent"
		(it "sets opponent to 'dumb computer' if the user enters 'dumb'"
	; 		(let [opponent "dumb computer"]
	; 		(should= opponent
	; 			(with-in-str "dumb"
	; 			(set-opponent))))))
		))


    (describe "first-or-second"
    	(it "asks the user if they would like to go first or second"
    		(should= "Would you like to go first or second?\n"
    			(with-out-str
    				(ask-first-or-second)))))

    	(it "returns the player-number 0 if the user wants to go first"
    		(should= 0
    			(with-in-str "first"
    			(get-first-or-second-input))))

    	(it "returns the player-number 2 if the user wants to go second"
    		(should= 2
    			(with-in-str "second"
    				(get-first-or-second-input))))


    	(describe "set-starter"
    		(it "sets the starting player, depending on user inputer")))
   


  ; (describe "ask-computer-or-human"
  ; 	(it "asks the user who they would like to play: a human or a computer"
  ; 		(should= "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb').\n"
  ; 			(with-out-str
  ; 				(ask-for-opponent)))))