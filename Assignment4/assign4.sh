#!/bin/bash

dataDir=$1
tempFile=$2
date=$3
outDir=$4

if [[ $# -ne 4 && $# -ne 6 ]]; then 
	echo "Usage: <dataDir> <tempFile> <date> <outDir> [optionalArg1] [optionalArg2]" 
	exit 1
fi

if [[ ! -d "$dataDir" ]]; then
	echo "ERROR: DIR - $dataDir does not exist."
	exit 1
fi

if [[ ! -d "$outDir" ]]; then 
	echo "ERROR DIR - $outDir does not exist"
	exit 1
fi

readFiles(){
	read dept_code dept_name
	read course_name
	read course_sched course_start course_end
	read credit_hours
	read num_students
}

if [[ $# -eq 4 ]]; then 
	for files in $dataDir/*; do
	fileName=$(echo $files | awk -F"/" '{print $NF}')
	fileName=$(echo $fileName |awk -F"." '{print $1}')	
	course_num=$(echo $fileName | awk 'match($0,/[0-9]{4}/) {print substr($0,RSTART,RLENGTH)}')
	outFile="$fileName.warn"
	readFiles< $files
	if [[ $num_students -gt 50 ]]; then 
		while read line; do 
			sed -e "s|\[\[dept_code\]\]|$dept_code|g" -e "s|\[\[dept_name\]\]|$dept_name|g" -e "s|\[\[course_name\]\]|$course_name|g" -e "s|\[\[course_start\]\]|$course_sched|g" -e "s|\[\[course_end\]\]|$course_end|g" -e "s|\[\[credit_hours\]\]|$credit_hours|g" -e "s|\[\[num_students\]\]|$num_students|g" -e "s|\[\[course_num\]\]|$course_num|g" -e "s|\[\[date\]\]|$date|g" > "$outDir/$outFile"
		done < $tempFile
	fi
	done

elif [[ $# -eq 6 ]]; then 
	for files in $dataDir/*; do
	fileName=$(echo $files | awk -F"/" '{print $NF}')
	fileName=$(echo $fileName |awk -F"." '{print $1}')	
	course_num=$(echo $fileName | awk 'match($0,/[0-9]{4}/) {print substr($0,RSTART,RLENGTH)}')
	outFile="$fileName.warn"
	readFiles< $files
	if [[ $num_students -gt 50 ]]; then 
		while read line; do 
		sed -e "s@[\/\|\{]dept_code[\/\|\}]@$dept_code@g" -e "s@[\/\|\{]dept_name[\/\|\}]@$dept_name@g" -e "s@[\/\|\{]course_name[\/\|\}]@$course_name@g" -e "s@[\/\|\{]course_start[\/\|\}]@$course_start@g" -e "s@[\/\|\{]course_end[\/\|\}]@$course_end@g" -e "s@[\/\|\{]credit_hours[\/\|\}]@$credit_hoursd@g" -e "s@[\/\|\{]num_students[\/\|\}]@$num_students@g" -e "s@[\/\|\{]course_num[\/\|\}]@$course_num@g" -e "s@[\/\|\{]date[\/\|\}]@$date@g" > "$outDir/$outFile"
		done < $tempFile
	fi
	done
fi







