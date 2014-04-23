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
			(should= "Please enter who you would you like to play against: \n    a human (type in 'human')\n    dumb computer (type in 'dumb computer')\n    smart computer (type in 'smart computer').\n"
				(with-out-str
					(ask-for-opponent)))))

	(describe "get-opponent"
		(it "gets which opponent the user wants to play against"
		  (should= "dumb computer"
		  	(with-in-str "dumb computer"
			(get-opponent)))))

    (describe "ask-first-or-second"
    	(it "asks the user if they would like to go first or second"
    		(should= "Would you like to go first or second?\n"
    			(with-out-str
    				(ask-first-or-second)))))
    (describe "get-first-or-second-input"
    	(it "returns the player-number 0 if the user wants to go first"
    		(should= 0
    			(with-in-str "first"
    			(get-first-or-second-input "dumb computer"))))

    	(it "returns the player-number 2 if the user wants to go second against the dumb comp"
    		(should= 2
    			(with-in-str "second"
    				(get-first-or-second-input "dumb computer"))))

        (it "returns the player-number 3 if the user wants to go second against the smart comp"
            (should= 3
                (with-in-str "second"
                    (get-first-or-second-input "smart computer")))))

    (describe "set-starter"
        (it "returns 0 if the user is playing again another human"
            (should= 0 (set-starter "human")))

    	(it "returns 0, if the user wants to go first vs. the computer"
            (should= 0
                (with-in-str "first"
                (set-starter "dumb computer")))))


        (it "returns 2 if the user wants to go second vs. the dumb computer"
            (should= 2
                (with-in-str "second"
                (set-starter "dumb computer"))))

        (it "returns 3 if the user wants to go second vs. the smart computer"
            (should= 3
                (with-in-str "second"
                (set-starter "smart computer")))))


