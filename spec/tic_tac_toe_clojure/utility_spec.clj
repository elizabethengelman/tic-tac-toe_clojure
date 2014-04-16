(ns tic-tac-toe_clojure.utility_spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.utility :refer :all]))

(describe "tic_tac_toe_clojure.utility"
	(describe "is-a-number?"
		(it "returns an Integer if str is a number"
			(should= 4 (is-a-number "4")))

		(it "returns nil if str is not a number"
			(should= nil (is-a-number "hey")))))