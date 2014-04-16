(ns tic-tac-toe_clojure.cli-spec
  (:require [speclj.core :refer :all]
            [tic_tac_toe_clojure.cli :refer :all]))

(describe "tic-tac-toe_cli.cli"
  (around [it]
    (with-out-str (it)))
  
  (describe "print-message"
    (it "prints a message"
      (should= "Welcome to Tic Tac Toe!\n"
      (with-out-str
      (print-message "Welcome to Tic Tac Toe!")))))

  (describe "print-message"
    (it "gets input from the user"
      (should= "test"
      (with-in-str "test"
      (get-input-from-user))))))

