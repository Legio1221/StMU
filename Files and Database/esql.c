#include <stdio.h>
#include "SQLite3.h"

int tupleNumber;
int julianDays1,julianDays2;
int totalOfIntervals,maxInterval,minInterval;

//----------------------------------------------------------
int main(int argc, char *argv[])
//----------------------------------------------------------
{
    /*
     111111111122222222223333333333444444444455555555556
     123456789012345678901234567890123456789012345678901234567890
     Tuple# Supplier Name        Part Name            Interval
     ------ --------------------------------------------------
     1 XXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXX
     . .                    .                           .
     . .                    .                           .
     XXXXXX XXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXX XXXXXXXX
     . .                    .                           .
     . .                    .                           .
     Range = [XXXXXXXX,XXXXXXXX], mean = XXXXXXXX.X
     */
    int callback(void *notUsed,int argc,char *argv[],char *azColName[]);
    
    sqlite3 *db;
    char *errorMessage = NULL;
    
    if ( sqlite3_open("SP.db",&db) )
    {
        fprintf(stderr,"Cannot open database \"SP.db\"\n",sqlite3_errmsg(db));
        sqlite3_close(db);
        system("PAUSE");
        return( 1 );
    }
    printf("Tuple# Supplier Name        Part Name            Interval\n");
    printf("------ --------------------------------------------------\n");
    tupleNumber = 0;
    julianDays1 = julianDays2 = 0;
    totalOfIntervals = 0;
    if ( sqlite3_exec(db,
                      //Student provides SELECT statement to satisfy query requirements
                      "SELECT DISTINCT sname, pname,julianDay(dueDate) FROM s,p,sp WHERE s.sno = sp.sno AND p.pno = sp.pno ORDER BY dueDate;",
                      callback,0,&errorMessage) != SQLITE_OK )
    {
        fprintf(stderr,"SQL error %s\n",errorMessage);
        sqlite3_free(errorMessage);
    }
    printf("Range = [%8d,%8d], mean = %10.1f\n",minInterval,maxInterval,
           (double) totalOfIntervals/(tupleNumber-1));
    sqlite3_close(db);
    system("PAUSE");
    return( 0 );
}

//----------------------------------------------------------
int callback(void *notUsed,int argc,char *argv[],char *azColName[])
//----------------------------------------------------------
{
    int interval;
    
    tupleNumber++;
    julianDays1 = julianDays2;
    julianDays2 = atoi(argv[2]);
    printf("%6d %-20s %-20s",tupleNumber,argv[0],argv[1]);
    
    //Student provides code to compute totalOfIntervals, minInterval, and maxInterval
    if (tupleNumber == 1) //Only the First tuple
    {
    }
    
    else if(tupleNumber == 2) //The Second
    {
        interval = abs(julianDays2-julianDays1);
        maxInterval = interval;
        minInterval = interval;
        totalOfIntervals += interval;
        printf(" %8d", interval);
    }
    else //Every other case possible
    {
        interval = abs(julianDays2-julianDays1);
        if(interval > maxInterval)
            maxInterval = interval;
        else if(interval < minInterval)
            minInterval = interval;
        totalOfIntervals += interval;
        printf(" %8d", interval);
    }
    
    printf("\n");
    return( 0 );
}
