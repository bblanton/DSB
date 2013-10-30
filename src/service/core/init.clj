(ns service.core.init
  (:require [clojurewerkz.quartzite.scheduler :as qs] 
            [taoensso.timbre :as log]))

(defn- init-logging
  []
  (log/set-config! [:appenders :spit :enabled?] true)
  (log/set-config! [:shared-appender-config :spit-filename] "/path/my-file.log"))

(defn- init-quartz
  []
  (qs/initialize)
  (qs/start)
  (log/info "Quartz has started"))

(defn run
  []
  (init-logging)
  (log/info "Running init scripts")
  (init-quartz)
  (log/info "Init scripts complete"))


