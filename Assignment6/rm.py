#!/usr/bin/env python3

import sys
import os
import re

userHome=os.path.expanduser('~')
trashPath=userHome+'/rm_trash'

if os.path.exists(trashPath)!=True:
    subprocess.check_output('mkdir ~rm/trash', shell=True)

recursiveFlag=False
for file in sys.argv[1::]:
    if file=="-r":
        recursiveFlag=True
        while "-r" in sys.argv:
            sys.argv.remove('-r')

for file in sys.argv[1::]:
    if os.path.isdir(file) and recursiveFlag==False:
        print(sys.argv[0]+ ': cannot remove '+ file +' : Is a directory', file=sys.stderr)
        continue

    if not os.path.exists(file):
        print(sys.argv[0]+ ': cannot remove '+ file +' : No such file or directory', file=sys.stderr)
        continue

    elif recursiveFlag==False: 
        trashFile=trashPath+'/'+file
        baseName=os.path.basename(file)
        fileName=baseName.split('.',1)[0]     
        extension=baseName.split('.', 1)[1]

        counter=1
        while os.path.exists(trashFile):
            trashFile=trashPath+'/'+fileName+'-'+str(counter)+'.'+extension
            counter+=1
        os.rename(file,trashFile)
    
    if recursiveFlag==True:
       baseName=os.path.basename(file)
       fileName, extension=os.path.splitext(baseName)
       trashFile=trashPath+'/'+fileName+extension
       counter=1
        
       while os.path.exists(trashFile):
            trashFile=trashPath+'/'+fileName+'-'+str(counter)+extension
            counter+=1
       os.rename(file,trashFile)



    
