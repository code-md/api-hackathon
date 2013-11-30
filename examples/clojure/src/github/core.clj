(ns github.core
  (:require [org.httpkit.client :as http])
  (:require [clojure.data.json :as json]))

(def repos-url "https://api.github.com/users/alisnic/repos")

(defn get-json [url]
  (let [{:keys [status headers body error] :as resp} @(http/get url)]
    (json/read-str body)))

(def repos
  (map #(select-keys % ["name" "forks" "stargazers_count"])
    (get-json repos-url)))

(defn pretty [item]
  (str "name: " (get item "name") "\t" "forks:" (get item "forks")))

(defn -main []
  (doseq [item repos]
    (println (pretty item))))
