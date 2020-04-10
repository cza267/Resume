#!/bin/bash

#find file
if [ ! -e data/"$record_name".crs ]; then
	echo "ERROR: course not found"

else
#read current enrollment
	read dept_code dept_name
	read course_name
	read course_sched course_start course_end
	read course_hours
	read course_size	#need this var

#change values
# pipe bc and use if greater then 0 or not
	if [ $change_amt -gt 0 ]; then 
		let course_size=$(($change_amt+$course_size))
	elif [ $change_amt -lt 0 ]; then 
		let course_size=$(($change_amt+$course_size))
	else
		course_size=$course_size
	fi

#log it
	echo "[`date`] ENROLLMENT: $dept_code $course_num $course_name 
		changed by $change_amt" >> data/queries.log
#overwrite it

  echo "$dept_code $dept_name" > data/"$record_name".crs
  echo "$course_name" >> data/"$record_name".crs
  echo "$course_sched $course_start $course_end" >> data/"$record_name".crs
  echo "$course_hours" >> data/"$record_name".crs
  echo "$course_size" >> data/"$record_name".crs

fi

