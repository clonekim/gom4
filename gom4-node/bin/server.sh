#!/bin/sh

GOM4_HOME=/home/ubuntu/gom4
NODE_PID=$GOM4_HOME/node.pid
NODE_LOG=$GOM4_HOME/debug.log

case "$1" in

	start)
		if [ -f $NODE_PID ]
		then
			echo "$NODE_PID exists, process is already running or crashed"
		else
			echo "Starting Node Server ..."
			PID=`nohup /usr/local/node/bin/node server.js > $NODE_LOG 2>&1 & echo $!`
			
			if [ $PID -gt '0' ]
			then
				echo $PID > $NODE_PID
			fi
		fi
    ;;

	stop)
		if [ ! -f $NODE_PID ]
		then
			echo "PID does not exist, process is not running"
		else
			PID=$(cat $NODE_PID)
			echo "Stopping..."
			while [ -x /proc/${PID} ]
			do
				echo "Waiting for Node to shutdown..."
				kill -9 $PID
				sleep 1
			done
			rm $NODE_PID $NODE_LOG > /dev/null 2>&1
			echo "Node stopped"
		fi
	;;
	
	*)
	  echo "Please use start or stop as first argument"
    ;;
    
esac

exit 0
       
