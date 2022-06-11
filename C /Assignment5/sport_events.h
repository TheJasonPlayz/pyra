//To be implemented
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct event
{
    int number;
    char name[104];
    int event_size;
    char gender;
    int temp;
    struct event *next;
};

void erase_event(struct event** event_tbl);
void search_event(struct event** event_tbl);
void update_event(struct event** event_tbl);
void dump_event(struct event** event_tbl);
void restore_event(struct event** event_tbl);
void insert_event(struct event** event_tbl);
void print_event(struct event** event_tbl);
