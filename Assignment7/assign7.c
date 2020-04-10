#include <stdio.h>
#include <string.h>
#include "assign7.h"

//#define DATA_DIR "./data"   //place in .h file
#define DATA_FILE "courses.dat"    //place in .h file

FILE * courseInfo; //Binary File

int main(int argc, char *argv[]){
    
    char inBuffer[101];
    char command;
    long relativeBA; // Relative Byte Address
    int readResult;
    int seekResult;

    COURSE courseStruct;  // course data
    int courseNumber;
    char courseName[64];
    char courseSched[4];
    unsigned int courseHours;
    unsigned int courseSize;
    
    // If file does not exist, will be created
    courseInfo=fopen(DATA_FILE, "rb+");

    if(courseInfo == NULL){
        courseInfo=fopen(DATA_FILE,"rb+");
    }
  
    while(fgets(inBuffer,101,stdin) !=NULL){
        printf("Enter one of the following actions or press CTRL-D to exit.\n");
        printf("C - create a new course record.\n");
        printf("R - read an existing course record.\n");
        printf("U - update an existing course record.\n");
        printf("D - delete an existing course record.\n");
    
        sscanf(inBuffer, "%c\n", &command);
        printf("> %c\n",command);
        
        switch(toupper(command)){
            case 'C':
               printf("Enter a CS course number: "); 
               fgets(inBuffer,100,stdin);
               sscanf(inBuffer,"%d", &courseNumber);

               fflush(stdin);
               fflush(stdout);
               
               relativeBA=(courseNumber-1)*sizeof(COURSE);
               fseek(courseInfo, relativeBA, SEEK_SET);
               readResult=fread(&courseStruct, sizeof(COURSE), 1L, courseInfo);

                if(readResult==1 && (courseStruct.courseHours!=0)){
                    
                     printf("ERROR: Course already exists.\n");
                }
                else{
                 printf("Enter a course name: ");                            
                 fgets(inBuffer, sizeof(courseStruct.courseName), stdin);
                 sscanf(inBuffer, "%[^\n]s",courseStruct.courseName);
  
                 printf("Enter a course schedule (MWF or TR): ");
                 fgets(inBuffer, sizeof(courseStruct.courseSched), stdin);
                 sscanf(inBuffer, "%s",courseStruct.courseSched);
                 
                 printf("Enter a course credit hours: ");
                 scanf("%u",&courseStruct.courseHours);

                 printf("Enter student enrollment: ");
                 scanf("%u",&courseStruct.courseSize);

                 fwrite(&courseStruct, sizeof(COURSE), 1L, courseInfo);
                 fflush(stdout);             
               }   
               break;
            
            case 'R':
               printf("Enter a CS course number: "); 
               fgets(inBuffer,100,stdin);
               sscanf(inBuffer,"%d", &courseNumber);

               relativeBA=(courseNumber)*sizeof(COURSE);
               seekResult=fseek(courseInfo,relativeBA,SEEK_SET);
               readResult=fread(&courseStruct, sizeof(COURSE),1L, courseInfo);
               
               if(readResult==1 && courseStruct.courseSize!=0){
                   printf("Course number: %d\n", courseNumber);
                   printf("Course name: %s\n", courseStruct.courseName);

                   printf("Schedule days:%s\n", courseStruct.courseSched);

                   printf("Credit hours: %u\n", courseStruct.courseHours);
                   printf("Enrolled Students:%u\n", courseStruct.courseSize);
               
               }
               else { 
                  printf("ERROR: course not found.\n");    
                }

                break;
            case 'U':
               printf("Course number: ");
               fgets(inBuffer,100,stdin) ;
               sscanf(inBuffer,"%d", &courseNumber);
               
               relativeBA=(courseNumber)*sizeof(COURSE);
               seekResult=fseek(courseInfo,relativeBA,SEEK_SET);
               readResult=fread(&courseStruct,sizeof(COURSE), 1L,courseInfo);
               
               if(readResult==1 && courseStruct.courseSize !=0){
                    printf("Course name: ");
                    fgets(inBuffer,sizeof(courseStruct.courseName),stdin);
                    if(strcmp(inBuffer,"\n")!=0){
                        sscanf(inBuffer,"%[^\n]s", courseStruct.courseName);
                    }
                    printf("Course schedule: ");
                    fgets(inBuffer,sizeof(courseStruct.courseSched),stdin);
                    if(strcmp(inBuffer, "\n")!=0){
                        sscanf(inBuffer,"%s", courseStruct.courseSched);
                    }
                    printf("Course credit hours: ");
                    fgets(inBuffer,sizeof(courseStruct.courseHours),stdin);
                    if(strcmp(inBuffer,"\n")!=0){
                        sscanf(inBuffer,"%u",&courseStruct.courseHours);
                    }
                    printf("Course enrollment: ");
                    fgets(inBuffer,sizeof(courseStruct.courseSize),stdin);
                    if(strcmp(inBuffer,"\n")!=0){
                        sscanf(inBuffer,"%u",&courseStruct.courseSize);
                    }
                    fseek(courseInfo,relativeBA,SEEK_SET);
                    fwrite(&courseStruct,sizeof(COURSE),1L,courseInfo);        
               }
               else { 
                    printf("ERROR: course not found");    
               }
   
                break;
            case 'D':
               printf("Enter a course number:");
               fgets(inBuffer, 100, stdin);
               sscanf(inBuffer, "%d", &courseNumber);
               
               relativeBA=(courseNumber)*sizeof(COURSE);

               seekResult=fseek(courseInfo, relativeBA, SEEK_SET);
               readResult=fread(&courseStruct,sizeof(COURSE), 1L, courseInfo);

               if(readResult=1 && (courseStruct.courseHours!=0)){
                   strcpy(courseStruct.courseName, "");
                   strcpy(courseStruct.courseSched, "");
                   courseStruct.courseHours=0;
                   courseStruct.courseSize=0;
                   fseek(courseInfo, relativeBA,SEEK_SET);
                   fwrite(&courseStruct,sizeof(COURSE),1L,courseInfo);
                   if(strcmp(courseStruct.courseName, "")==0){               
                       printf("course number %d was successfully deleted.\n",courseNumber);
                   }
                   else{
                    printf("Not deleted %d.", courseNumber);
                   }
                 }
               else{
                    printf("ERROR: course not found.\n");    
               }
                break;
            default:
                 printf("ERROR: invalid option.\n");
                break;
        }
    }
    fclose(courseInfo);
}

        



