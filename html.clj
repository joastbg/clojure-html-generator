; HTML-generator
; Johan Astborg 2012

(def stag (fn[t] (reduce str ["<",t,">"])))
(def etag (fn[t] (reduce str ["</",t,">"])))
(def mtag (fn[t,b] (reduce str [(stag t),b,(etag t)])))

(defn sum [& args] (reduce + args))

(defn html [& args] (mtag "html" (reduce str args)))
(defn head [& args] (mtag "head" (reduce str args)))
(defn body [& args] (mtag "body" (reduce str args)))
(defn title [& args] (mtag "title" (reduce str args)))

(println (html (head (title "hello")) (body "Hello World")))
