#!/bin/bash

read -p "Enter Department Code: " dept_code

read -p "Enter Department Name: " dept_name

read -p "Enter Course Number: " course_number

read -p "Enter Course Name: " course_name

read -p "Enter Course Schedule: " course_sched

read -p "Enter Course Start Date: " start_date

read -p "Enter Course End Date: " end_date

read -p "Enter Course Credit Hours: " course_hours

read -p "Enter Initial Course Enrollment: " course_size

#lower case to upper case and format

dept_code=${dept_code^^}
recordName="$dept_code$course_number"

if [ -e data/"$recordName".crs ]; then
	echo "Error: course already exists"

else
	echo "$dept_code $dept_name" >> data/"$recordName".crs
	echo "$course_name" >> data/"$recordName".crs
	echo "$course_sched $start_date $end_date" >> data/"$recordName".crs
	echo "$course_hours" >> data/"$recordName".crs 
	echo "$course_size" >> data/"$recordName".crs
#queries log
	echo "[`date`] CREATED: $dept_code $course_number $course_name" >> data/queries.log  

fi

