#!/bin/bash

# mvn clean package

java -jar target/bookm-parser-jar-with-dependencies.jar Bookmarks-Google_2016-07-25.html > Bookmarks-Google_2016-07-25.csv  
java -jar target/bookm-parser-jar-with-dependencies.jar Bookmarks-Chrome_2016-07-25.html > Bookmarks-Chrome_2016-07-25.csv
