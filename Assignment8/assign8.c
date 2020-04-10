#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
/*
examples 6-8 in notes
*/

int main(int argc, char *argv[]){
   
   long forkPID;
   long waitPID;
   int cmdCnt=1;
   int x=0;
   int y=0;
   int exitStatus;

   /*
   Count the number of commands
   */
   
   for(x=0; x< argc; x++){
       if(strcmp(argv[x], ",")==0){
           cmdCnt++;
        }
   }
   
   /*
    Hold all args cmds in 2D Array, parsing by comma ',' delimiter
   */
   char *cmds[x][10];
   int temp=1;
   while(temp < argc){
       for(x=0; x<cmdCnt; x++){
        for(y=0; y < 6; y++){
           if(temp < argc && (strcmp(argv[temp], ",")!=0)){
                cmds[x][y]= argv[temp];
                temp++;
                if(temp>=argc || (strcmp(argv[temp],",")==0)){
                    cmds[x][y+1]=NULL;
                    temp++;
                    y=6;
                }
            } 
         }
        }
    }

    int tempExit;

    /*
        Starting fork, -1: Failure, 0: Child Process, default: Parent Process recieves child PID
        for loop to to start all processes
    */

    for(x=0; x<cmdCnt; x++){
        forkPID= fork();
        switch(forkPID){
            case -1:
                printf("Fork Failed.\n");
                exit(1);
                break;
            case 0:
                fprintf(stderr,"PID :%ld, PPID:%ld CMD: %s\n",(long)getpid(), (long)getppid(), cmds[x][0]);
                execvp(cmds[x][0],cmds[x]);
            default:
                printf("PID: %d\n", getpid());
                break;        
            }
        }
        /*
        For loop to wait on exit status on all child proceses
        */
       for(x=0;x<cmdCnt;x++){
           wait(&exitStatus);
        }
    return 0;
}
