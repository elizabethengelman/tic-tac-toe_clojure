(ns tic-tac-toe_clojure.cli-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.cli :refer :all]))

(describe "tic-tac-toe_cli.core"
  (around [it]
    (with-out-str (it)))
  
  (it "prints a message"
    (should= "Welcome to Tic Tac Toe!\n"
    (with-out-str
    (print-message "Welcome to Tic Tac Toe!"))))

  (it "gets input from the user"
    (should= "test"
    (with-in-str "test"
    (get-input-from-user)))))

