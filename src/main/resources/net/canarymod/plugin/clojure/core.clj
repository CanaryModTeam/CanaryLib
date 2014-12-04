(ns net.canarymod.plugin.clojure.core
  (:import [net.canarymod.plugin.impl ClojureCommandMeta])
  (:use [clojure.tools.nrepl.server :only (start-server stop-server)])
  (:import [net.canarymod.plugin.Priority]
           [net.canarymod.logger.Logman]
           [net.canarymod.plugin.impl.ClojureCommandMeta]))

(defmulti log (fn [severity _] severity))
(defmethod log :info [_ msg]
  (.info (net.canarymod.logger.Logman/getLogman "ClojurePlugin") msg))

(defn lookup-handler [sym]
  (fn [& args] (apply (resolve sym) args)))

(defn register-hook [plugin]
  (fn [[hookName handler-sym priority]]
    (.registerHook plugin hookName (lookup-handler handler-sym) priority)))

(defn- in-s-a [col]
  (into-array java.lang.String col))

(defn create-meta [{:keys [aliases permissions description tooltip parent helpLookup searchTerms min max version]
                    :or {aliases [] permissions [] description "" tooltip "" parent "" helpLookup "" searchTerms [] min 1 max -1 version 1}}]
  (ClojureCommandMeta. (in-s-a aliases) (in-s-a permissions) description tooltip parent helpLookup (in-s-a searchTerms) min max version) )

(defn register-command [plugin]
  (fn [[meta-inf handler-sym force]]
    (let [meta (create-meta meta-inf)
          handler (lookup-handler handler-sym)]
      (.registerCommand plugin handler meta force))))

(defn registerAll [plugin config]
  (doall (map (register-hook plugin) (:hooks config)))
  (doall (map (register-command plugin) (:commands config))))

(def repls (atom {}))

(def stop-repl)
(defn start-repl [plugin port]
  (log :info (str "Starting repl on port " port))
  (if (contains? @repls plugin) (stop-repl plugin))
  (swap! repls (fn [o] (assoc o plugin (start-server :port port)))))

(defn stop-repl [plugin]
  (log :info "Stopping repl")
  (stop-server (get @repls plugin))
  (swap! repls (fn [o] (dissoc o plugin))))