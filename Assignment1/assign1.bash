#!/bin/bash

#Main Menu script
runit=0
#continuous loop
while [ $runit ]; do
	echo "Enter one of the following actions or press CTRL-D to exit."
	echo "C - create a new course record"
	echo "R - read an existing course record"
	echo "U - update an existing course record"
	echo "D - delete an existing course record"
	echo "E - update enrolled student count of existing course"
	echo "T - show total course count"

	if ! read reply; then
		break
	fi

	case "$reply" in
		
#C-create an new course record
		[Cc]) ./create.bash;;
		
#R-read an existing course record
		[Rr]) 
			read -p "Enter department code and course number:" dept_code course_num
			dept_code=${dept_code^^}
			recordName=$dept_code$course_num
			if [ ! -e data/${recordName}.crs ]; then
				echo "ERROR: course not found"
				
			else
				export dept_code
				export course_num
	
				bash read.bash < data/"$recordName".crs
			fi
			;;		

	
#U-update an enrolled student count of existing course
		[Uu])
           
	        #prompt from all new vars
        		read -p "Department Code: " dept_code_val
		        read -p "Department Name: " dept_name_val
		        read -p "Course number: " course_num_val
		        read -p "Course name: " course_name_val
		        read -p "Course meeting days: " course_sched_val
		        read -p "Course start date: " course_start_val
		        read -p "Course end date: " course_end_val
		        read -p "Course credit hours: " course_hours_val
		        read -p "Course enrollment: " course_size_val
        
		        export dept_name_val
		        export course_name_val
		        export course_sched_val
		        export course_start_val
		        export course_end_val
		        export course_hours_val
		        export course_size_val        
            
		        dept_code_val=${dept_code_val^^}
		        record_name=$dept_code_val$course_num_val
			export dept_code_val
			export course_num_val
			export record_name
		      ./update.bash < data/"$record_name".crs 
		      ;;

#D-delete an existing course record
		[Dd]) 
			read -p "Enter a course department code and number: " dept_code course_num

		        dept_code=${dept_code^^}
		        record_name=$dept_code$course_num
			export dept_code
			export record_name
			export course_num

			./delete.bash < data/"$record_name".crs;;


#E-update enrolled student count of exisiting course 
		[Ee]) 
			read -p "Enter a course department code and number: " dept_code course_num
			read -p "Enter an enrollment change amount: " change_amt
		        dept_code=${dept_code^^}
		        record_name=$dept_code$course_num
			export dept_code
			export record_name
			export course_num
			export change_amt			
			
			./enroll.bash < data/"$record_name".crs;;

#T-show total course count
		[Tt]) 	
			./total.bash;;

# None of the Choices
		*) echo "Error: invalid option."	
	esac
done
