#!/bin/sh
HOST='waws-prod-sn1-003.ftp.azurewebsites.windows.net'
USER='$open-cart'
PASSWD='b0v22TwzoPtv7ESsnfyT74xoFZZjPawpRbsuZ9kfd4jGBeaLE4q2wXT7xoXH'

ncftp -u $USER -p $PASSWD $HOST <<END_SCRIPT
passive
binary
mput -R *
quit
END_SCRIPT
