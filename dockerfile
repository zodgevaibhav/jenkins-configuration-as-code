FROM jenkins

MAINTAINER zodgevaibhav@gmail.com

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY plugins/*.* /usr/share/jenkins/ref/plugins/
COPY groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY shell-scripts/install-plugins.sh /usr/local/bin/install-plugins.sh