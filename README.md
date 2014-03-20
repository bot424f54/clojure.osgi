clojure.osgi
============

Clojure / OSGi integration
Due to the fact that OSGI had seperate classloaders clojure will not work out of the box.  The clojure.osgi bundle gives you the ability to run clojure code in osgi.

Works on Apache Karaf 3.0.0 simple example with no dependencies

Usage
==========

Build the clojure.osgi module using maven
cd clojure.osgi
mvn clean install

This should give you a "clojureized" bundle for use in karaf exporting the main clojure.  Deploy this in karaf.

Build the karaf-demo module.
cd karaf-demo
mvn clean install

This a very useless app that just prints out to System.out that the bundle has started. Deploy this in karaf. 
start the clojure bundle and you should see system.out saying that main bundle has started.

The key point to this demo is specifying the namespace that contains your bundle activator function.  As of now this is hardcoded as "bundle-start"

If you look in the pom in the karaf-demo you can see the instructions to the bnd plugin 
<Bundle-SymbolicName>${project.artifactId}</Bundle-SymbolicName>
	                      <Import-Package>
                            <!--${project.artifactId}; version=$(Bundle-Version),-->
                            !sun.misc,
                            clojure.lang;version="1.6.0.RC1",
			    clojure.osgi;version="1.6.0.beta2-1",
			    org.osgi.framework
                        </Import-Package>
<Clojure-Require>demo.main</Clojure-Require>
<Clojure-ActivatorNamespace>demo.main</Clojure-ActivatorNamespace>
			
Notice Clojure-Require and Clojure-ActivatorNamespace custom entries to the manifest.
This invokes a the BundleTracker in the clojure bundle which starts your bundle with the namespace specified.
Thats it have fun playing with clojure on karaf

Caveats
================
Beware of namespace issues like clojure.java as when you define your imports and exports your going to have a lot of split package issues.

Next
==============
AOT (Ahead of Time) compiled classes demo.
OSGI Service.
There are examples from the main repos this was forked from all I am doing is using the maven bnd plugin to update the Manifest.
