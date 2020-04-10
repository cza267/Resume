#!/usr/bin/env python3
import os
import sys
import re

#NON EXTRA CREDIT SECTION--------------------------------------------------------------

if len(sys.argv) ==5:
    
    dataDir=sys.argv[1]
    template=sys.argv[2]
    date=sys.argv[3]
    outDir=sys.argv[4]
    #ERROR CHECKING ARGS
    if not os.path.isdir(dataDir):
        print(dataDir + " is not a directory")
        sys.exit(1)
    if not os.path.isfile(template):
        print(template + " is not a file")
        sys.exit(1)
    if not os.path.isdir(outDir):
        print(outDir + " does not exist")
    #READ DATA FILES & STORE VARS
    else:
        for file in os.listdir(dataDir):
            myDir=dataDir+'/'+file
            matchNum=re.search("[0-9]{4}",file)
            if matchNum:
                course_num=matchNum.group(0)
            with open(myDir,'r') as infile:
                   fileLines=infile.readlines()
                   line1=fileLines[0].rstrip().split(" ", 1)
                   dept_code=line1[0]
                   dept_name=line1[1]
                   course_name=fileLines[1].rstrip() 
                   line3=fileLines[2].rstrip().split()
                   course_sched=line3[0]
                   course_start=line3[1]
                   course_end=line3[2]
                   credit_hours=fileLines[3].rstrip()
                   num_students=int(fileLines[4].rstrip())
            if num_students > 50:
                num_students=str(num_students)
                outputPath=outDir+'/'+dept_code+course_num+'.warn'
                findPattern=("[[dept_code]]", "[[dept_name]]", "[[course_name]]","[[course_start]]", "[[course_end]]", "[[credit_hours]]", "[[num_students]]","[[course_num]]", "[[date]]")
                replacePattern=(dept_code,dept_name,course_name,course_start, course_end, credit_hours,num_students,course_num,date)
                with open(template,'r') as tempFile:
                    tempLines=tempFile.readlines()
                with open(outputPath, 'w') as createFile:
                    for line in tempLines:
                        for tempWord,valueWord in zip(findPattern, replacePattern): 
                            line=line.replace(tempWord,valueWord)
                        createFile.write(line)                

#EXTRA CREDIT SECTION------------------------------------------------------------------------------------
elif len(sys.argv) == 7:

    # Escape every character in my begin/end delimiters with a backslash
    begin_delim = sys.argv[5]
    end_delim = sys.argv[6]

    dataDir=sys.argv[1]
    template=sys.argv[2]
    date=sys.argv[3]
    outDir=sys.argv[4]
    #ERROR CHECKING ARGS
    if not os.path.isdir(dataDir):
        print(dataDir + " is not a directory")
        sys.exit(1)
    if not os.path.isfile(template):
        print(template + " is not a file")
        sys.exit(1)
    if not os.path.isdir(outDir):
        print(outDir + " does not exist")
    #READ DATA FILES & STORE VARS
    else:
        for file in os.listdir(dataDir):
            myDir=dataDir+'/'+file
            matchNum=re.search("[0-9]{4}",file)
            if matchNum:
                course_num=matchNum.group(0)
            with open(myDir,'r') as infile:
                   fileLines=infile.readlines()
                   line1=fileLines[0].rstrip().split(" ",1)
                   dept_code=line1[0]
                   dept_name=line1[1]
                   course_name=fileLines[1].rstrip("\n") 
                   line3=fileLines[2].split(" ")
                   course_sched=line3[0]
                   course_start=line3[1]
                   course_end=line3[2].rstrip("\n")
                   credit_hours=fileLines[3].rstrip("\n")
                   num_students=int(fileLines[4].rstrip("\n"))
            if num_students > 50:
                num_students=str(num_students)
                outputPath=outDir+'/'+dept_code+course_num+'.warn'
                with open(template,'r') as tempFile:
                    tempLines=tempFile.readlines()
                with open(outputPath, 'w') as createFile:
                    for line in tempLines:
                        repList = line
                        repList = repList.replace(begin_delim + "dept_code" + end_delim, dept_code)
                        repList = repList.replace(begin_delim + "dept_name" + end_delim, dept_name)
                        repList = repList.replace(begin_delim + "course_name" + end_delim, course_name)
                        repList = repList.replace(begin_delim + "course_num" + end_delim, course_num)
                        repList = repList.replace(begin_delim + "course_sched" + end_delim, course_sched)
                        repList = repList.replace(begin_delim + "course_start" + end_delim, course_start)
                        repList = repList.replace(begin_delim + "course_end" + end_delim, course_end)
                        repList = repList.replace(begin_delim + "credit_hours" + end_delim, credit_hours)
                        repList = repList.replace(begin_delim + "num_students" + end_delim, num_students)
                        repList = repList.replace(begin_delim + "date" + end_delim, date)
                
                        createFile.write(repList)
else: 
    print("Usage: " + "<data dir> "+ "<template> " + "<date> " +"<output dir> "+"<optional arg1> "+ "<optional arg2> ")
