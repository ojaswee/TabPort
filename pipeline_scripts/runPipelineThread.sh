#!/usr/bin/env bash

if [ $# -eq 0 ]
then 
	echo "Usage: runPipelineThread.sh"
	echo "-d database"
    echo "-u user"
	echo "-p password"
	echo "-r requestID"
fi

myname='sishir'

if test $# -gt 0
	then
	while getopts :d:u:p:r: opt
	do
	case $opt in
  	d)
		database=$OPTARG
		;;
  	u)
   		user=$OPTARG
		;;
    p)
      	password=$OPTARG
   		;;
	r)
      	requestID=$OPTARG
   		;;
	:)
		echo "Option -$OPTARG requires an argument." ; exit
		;;
	\?)
		echo "Invalid option: -$OPTARG"; exit
	esac
	done
	shift $((OPTIND-1))
fi



echo "running from runPipelinThread"
echo " $user, $database , $password ,$requestID"

### TODO implement tabcmd command to send report request to tableau virtual machine



