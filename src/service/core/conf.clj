(ns service.core.conf
  ^{:Author "Bryce Blanton"
        :Description "A namespace that holds utility functions for working with the
                                      configuration file."}
  (:require [clojure.edn :only (read-string) :as edn]))

(defn- load-configuration-file
    ^{:Description "Loads the app.conf file"}
    []
    (edn/read-string (slurp "service.conf")))

(def ^{:Description "A variable to hold the loaded configuration"} configuration (load-configuration-file))

(defn get-value
    ^{:Description "Returns the value from the configuration file based on the key."}
    [key]
    (key configuration))
