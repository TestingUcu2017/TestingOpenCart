#!/bin/sh
HOST='waws-prod-sn1-003.ftp.azurewebsites.windows.net'
USER='$open-cart'
PASSWD='b0v22TwzoPtv7ESsnfyT74xoFZZjPawpRbsuZ9kfd4jGBeaLE4q2wXT7xoXH'

ncftp -u $USER -p $PASSWD $HOST <<END_SCRIPT
passive
binary
mput *.yml
mput *.xml
mput *.md
mput *.json
mput *.txt
mput *.sql
mput *.dist
mput *.stackdump
mput *.properties
mput -R tests/
mput -R pa11y-master/
mput -R upload/
mput -R vaddy-master/
quit
END_SCRIPT
