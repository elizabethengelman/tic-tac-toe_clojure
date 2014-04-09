(ns tic_tac_toe_clojure.cli)

(defn print-message[message]
  (println message))

(defn get-input-from-user[]
  (read-line))