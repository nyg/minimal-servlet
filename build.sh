#!/bin/sh

#
# Creates the WAR archive.
#

JEE_LIBS=/usr/local/bin/tomee-1.7.2/lib/*
war=MinimalServlet.war
src=MinimalServlet.java

rm *.war
mkdir -p WEB-INF/classes

javac -cp "$JEE_LIBS" -d WEB-INF/classes $src

jar cf $war WEB-INF
jar tf $war

rm -rf WEB-INF
