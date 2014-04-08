(ns tic-tac-toe_clojure.core)

(defn print-message[message]
  (println message))

(defn get-input-from-user[]
  (read-line))

(defn display-empty-board[]
  (println "__|__|__\n__|__|__\n  |  |  "))

(defn display-numbered-board[]
  (println " 1 | 2 | 3 \n-----------\n 4 | 5 | 6 \n-----------\n 7 | 8 | 9 "))

(defn -main[]
  
   (print-message "Welcome to Tic Tac Toe!")
   (print-message "This is how the board is numbered:")
   (display-numbered-board)
   (print-message "Who is first player? Please enter your name:")
   (get-input-from-user))
