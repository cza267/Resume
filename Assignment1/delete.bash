#!/bin/bash

#find it
if [ ! -e data/"$record_name".crs ]; then

	echo "ERROR: course not found"

else
#delete it 
	read dept_code dept_name
	read course_name
	`rm data/"$record_name".crs`
#log it
	echo " [`date`] DELETED: $dept_code $course_num" >> data/queries.log
	echo $dept_code $course_num $course_name

#print message
	echo "$course_num was successfully deleted."

fi
