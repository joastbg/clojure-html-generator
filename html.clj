; HTML-generator
; Johan Astborg 2012

; helpers
(def stag (fn[t] (reduce str ["<",t,">"])))
(def etag (fn[t] (reduce str ["</",t,">"])))
(def mtag (fn[t,b] (reduce str [(stag t),b,(etag t)])))

; tags
(defn html [& args] (mtag "html" (reduce str args)))
(defn head [& args] (mtag "head" (reduce str args)))
(defn body [& args] (mtag "body" (reduce str args)))
(defn title [& args] (mtag "title" (reduce str args)))
(defn footer [& args] (mtag "footer" (reduce str args)))
(defn p [& args] (mtag "p" (reduce str args)))

; h1-h6
(def h1 (fn[s] (mtag "h1" s)))
(def h2 (fn[s] (mtag "h1" s)))
(def h3 (fn[s] (mtag "h1" s)))
(def h4 (fn[s] (mtag "h1" s)))
(def h5 (fn[s] (mtag "h1" s)))
(def h6 (fn[s] (mtag "h1" s)))

; text-level semantics
(def b (fn[s] (mtag "b" s)))
(def big (fn[s] (mtag "big" s)))
(def mark (fn[s] (mtag "mark" s)))
(def i (fn[s] (mtag "i" s)))
(def strong (fn[s] (mtag "strong" s)))
(def small (fn[s] (mtag "small" s)))
(def strike (fn[s] (mtag "strike" s)))

; hr
(def hr (fn[] "<hr/>"))

; a href
(def ahref (fn[l,t] (reduce str ["<a href='",l,"'>",t,"</a>"])))

; ul, ol and li
(def li (fn[s] (mtag "li" s)))
(defn ol [& args] (mtag "ol" (reduce str (map li args))))
(defn ul [& args] (mtag "ul" (reduce str (map li args))))

; a test page
(println 
	(html 
		(head 
			(title "HTML-gen using Clojure")
		) 
	(body 
		(h1 "My Headline"))
		(ahref "http://www.google.se" "Google")
		(ul (mark (i "Test")),2,(strong 3))
		(ol "First", (strike "2nd"), 3)
		(footer
			(hr)
			(small "Test page")
		)
	)
)
