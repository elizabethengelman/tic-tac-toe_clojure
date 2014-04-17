(ns tic-tac-toe_clojure.core_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.core :refer :all]))

(describe "tic-tac-toe_clojure.core_spec"
  (around [it]
    (with-out-str (it)))

  (describe "ask-computer-or-human"
  	(it "asks the user who they would like to play: a human or a computer"
  		(should= "Please enter who you would you like to play against: a human (type in 'human') or a dumb computer (type in 'dumb').\n"
  			(with-out-str
  				(ask-computer-or-human)))))

  (describe "game-loop"
  	(it "runs through a game, until game-over? evals to true")))

