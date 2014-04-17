(ns tic-tac-toe_clojure.core_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.core :refer :all]))

(describe "tic-tac-toe_clojure.core_spec"
  (around [it]
    (with-out-str (it)))

  (describe "game-loop"
  	(it "runs through a game, until game-over? evals to true")))

