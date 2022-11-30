# HybridFramework_FreeCRM

open terminal and move to the project directory

maven installation check ==> mvn -version

if maven is not installed got to (for linux)==> https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-20-04/

run command ==> mvn clean then mvn install

for allure report ==> install Allure Report ==> --> curl -o allure-2.13.8.tgz -OLs https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.13.8/allure-commandline-2.13.8.tgz --> sudo tar -zxvf allure-2.13.8.tgz -C /opt/ --> sudo ln -s /opt/allure-2.13.8/bin/allure /usr/bin/allure --> allure --version

to see allure report run command ==> allure serve allure-results
