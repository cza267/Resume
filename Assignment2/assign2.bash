#!/bin/bash

# echo $0: name of command
# echo $1: first parameter
pathVar=$1
newDate=`date +%m/%d/%Y`
if [[ ! -e $pathVar ]]; then 

	echo "File does not exist"
else
	 
	sed -i.sav -E -f matchScript.sed $pathVar
	
	sed -i.sav -e "s|<date>|$(date +%m/%d/%Y)|g" $pathVar
fi

