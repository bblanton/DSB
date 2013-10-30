(ns service.core.main
  (:require [service.core.init :as init]
            [service.core.conf :as conf]
            [service.content.job :as job]
            [clojurewerkz.quartzite.scheduler :as qs]
            [clojurewerkz.quartzite.triggers :as t]
            [clojurewerkz.quartzite.jobs :as j]
            [clojurewerkz.quartzite.jobs :refer [defjob]]
            [clojurewerkz.quartzite.schedule.simple :refer [schedule repeat-forever with-interval-in-milliseconds]])
  (:gen-class))

(defjob service
        [ctx]
        (job/run))

(defn -main
  [& m]
  (init/run)
  (let [job (j/build
              (j/of-type service)
              (j/with-identity (j/key (str "job." (conf/get-value :Service-Name)))))
        trigger (t/build
                  (t/with-identity (t/key "triggers.1"))
                  (t/start-now)
                  (t/with-schedule (schedule
                                     (repeat-forever)
                                     (with-interval-in-milliseconds 200))))]
    (s/schedule job trigger)))
