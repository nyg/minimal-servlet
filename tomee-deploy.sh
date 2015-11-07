#!/bin/sh

#
# Deploys the WAR archive to TomEE.
#

TOMEE=/usr/local/bin/tomee-1.7.2
war=MinimalServlet

"$TOMEE"/bin/shutdown.sh
rm -rf "$TOMEE"/apps/$war*
"$TOMEE"/bin/tomee.sh "deploy -o $war.war"
"$TOMEE"/bin/startup.sh