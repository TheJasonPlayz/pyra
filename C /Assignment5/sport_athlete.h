//To be implemented
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct athlete
{
    int number;
    char name[25];
    int  age;
    char gender;
    struct athlete*next;
};


void erase_athlete(struct athlete** athlete_tbl);
void search_athlete(struct athlete** athlete_tbl);
void update_athlete(struct athlete** athlete_tbl);
void dump_athlete(struct athlete** athlete_tbl);
void restore_athlete(struct athlete** athlete_tbl);
void insert_athlete(struct athlete** athlete_tbl);
void print_athlete(struct athlete** athlete_tbl);
