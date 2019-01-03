#FROM jenkins
from jenkins/jenkins:lts
MAINTAINER zodgevaibhav@gmail.com

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

COPY downloads/*.* /var/jenkins_home/downloads/
USER root
RUN tar -xf /var/jenkins_home/downloads/node-v11.6.0-linux-x64.tar.gz --directory /usr/local --strip-components 1

COPY plugins/*.* /usr/share/jenkins/ref/plugins/
COPY groovy/*.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY shell-scripts/install-plugins.sh /usr/local/bin/install-plugins.sh