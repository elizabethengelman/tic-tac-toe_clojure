(ns tic_tac_toe_clojure.utility)

(defn is-a-number[str]
  (let [n (read-string str)]
       (if (number? n) n nil)))