(ns cljfmt.test-util.clojure
  (:require [clojure.test :as test]
            [cljfmt.test-util.common :as common]))

(defmethod test/assert-expr 'reformats-to? [msg form]
  `(let [report-result# (common/reformats-to-event ~msg ~form)]
     (test/do-report report-result#)
     (= :pass (:type report-result#))))
