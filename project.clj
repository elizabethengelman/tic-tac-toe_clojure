(defproject tic-tac-toe_clojure "0.1.0-SNAPSHOT"
  :description "Tic Tac Toe"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:dependencies [[speclj "3.0.1"]]}}
  :plugins [[speclj "3.0.1"]]
  :test-paths ["spec"]
  :main tic_tac_toe_clojure.core)
