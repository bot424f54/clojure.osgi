(ns demo.main
	(:use clojure.osgi.core) 
)

;(println "main.clj(bundle1): loaded. Bundle symbolic name is:" (.. *bundle* getSymbolicName))

(defn- bundle-start [context]
	(println "main.clj(demo): bundle-start is called")
)

(defn- bundle-stop [context]
	(println "main.clj(bundle1): bundle-stop is called")
)
