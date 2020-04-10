#!/bin/bash

#find the file


#if not found throw error
if [ ! -e data/${record_name}.crs ]; then

  echo "ERROR: File not found"

#read current version, save vars  
else
  read dept_code_old dept_name_old
  read course_name_old
  read course_sched_old course_start_old course_end_old
  read course_hours_old
  read course_size_old

# compare if diff then save to file
# use var: #_#_new to store var for rewrite 

  if [[ "$dept_code_val" == ""  ]]; then 
  	dept_code_new=$dept_code_old
  else 
  	dept_code_new=$dept_code_val
  fi
  
  if [[ "$dept_name_val" == "" ]]; then
  	dept_name_new=$dept_name_old
  else
  	dept_name_new=$dept_name_val
  fi
  
  if [[ "$course_num_val" == "" ]]; then
  	course_num_new=$course_num_new
  else
  	course_num_new=$course_num_val
  fi
  
  if [[ "$course_name_val" == "" ]]; then
  	course_name_new=$course_name_old
  else
  	course_name_new=$course_name_val
  fi
  
  if [[ "$course_sched_val" == "" ]]; then
  	course_sched_new=$course_sched_old
  else
  	course_sched_new=$course_sched_val
  fi
  
  if [[ "$course_start_val" == "" ]]; then
  	course_start_new=$course_start_old
  else
  	course_start_new=$course_start_val
  fi
  
  if [[ "$course_end_val" == "" ]]; then
  	course_end_new=$course_end_old
  else
  	course_end_new=$course_end_val
  fi
  
  if [[ "$course_hours_val" == "" ]]; then
  	course_hours_new=$course_hours_old
  else
  	course_hours_new=$course_hours_val
  fi
  
  if [[ "$course_size_val" == "" ]]; then
  	course_size_new=$course_size_old
  else
  	course_size_new=$course_size_val
  fi


  echo "$dept_code_new $dept_name_new" > data/"$record_name".crs
  echo "$course_name_new" >> data/"$record_name".crs
  echo "$course_sched_new $course_start_new $course_end_new" >> data/"$record_name".crs
  echo "$course_hours_new" >> data/"$record_name".crs
  echo "$course_size_new" >> data/"$record_name".crs

echo "[`date`] UPDATED: $dept_code_new $course_num_new $course_name_new" >> data/queries.log

fi
