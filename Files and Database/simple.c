//----------------------------------------------------------
// Oscar Guillermo Castro
// Dr. Art Hanna
// Modified version of the simple C program found in SQLite3 documentation at
//    URL https://sqlite.org/quickstart.html
// Simple.c
//----------------------------------------------------------
#include <stdio.h>
#include ".\SQLite3.h"

//----------------------------------------------------------
static int callback(void *notUsed,int argc,char *argv[],char *azColName[])
//----------------------------------------------------------
{
   int i;

   for(i = 0; i < argc; i++)
      printf("%s = %s\t",azColName[i],(argv[i] ? argv[i] : "NULL"));
   printf("\n");
   return( 0 );
}

//----------------------------------------------------------
int main(int argc, char *argv[])
//----------------------------------------------------------
{
   sqlite3 *db;
   char *errorMessage = NULL;

   if ( argc != 3 )
   {
      fprintf(stderr,"Usage error. Try ...>Simple databaseName \"SQLStatement\"\n",argv[0]);
      system("PAUSE");
      return( 1 );
   }
   if ( sqlite3_open(argv[1],&db) )
   {
      fprintf(stderr,"Cannot open database \"%s\"\n",sqlite3_errmsg(db));
      sqlite3_close(db);
      system("PAUSE");
      return( 1 );
   }
   if ( sqlite3_exec(db,argv[2],callback,0,&errorMessage) != SQLITE_OK )
   {
      fprintf(stderr,"SQL error %s\n",errorMessage);
      sqlite3_free(errorMessage);
   }
   sqlite3_close(db);
   system("PAUSE");
   return( 0 );
}
