#include "sport_events.h"

/* dump: Dumps contents of the event_tbl to specified
 *       file. Prints error message and does not
 *       terminate program upon failure. Does not store
 *       next pointer.
 */
void dump_event(struct event **event_tbl)
{
    FILE *fp;
    char filename[255];
    struct event **node = event_tbl;

    printf("Enter name of output file: ");
    fgets(filename, 255,stdin);

    if ((fp = fopen(filename, "wb")) == NULL)
    {
        fprintf(stderr, "File %s could not be written\n", filename);
        return;
    }

    while (*node)
    {
        fwrite(*node, sizeof(struct event) - sizeof(struct event *), 1, fp);
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

/* restore: Restores contents from specified file. Does
 *          not terminate upon file open failure, but
 *          terminates upon malloc failure.
 */
void restore_event(struct event **event_tbl)
{
    FILE *fp;
    char filename[255];
    struct event buffer;
    struct event *temp;
    struct event **node;

    printf("Enter name of input file: ");
    fgets(filename, 255,stdin);

    if ((fp = fopen(filename, "rb")) == NULL)
    {
        fprintf(stderr, "Error: file %s cannot be opened\n", filename);
        return;
    }

    while (*event_tbl)
    {
        temp = *event_tbl;
        *event_tbl = (*event_tbl)->next;
        free(temp);
    }

    node = event_tbl;

    while (fread(&buffer,sizeof(struct event) - sizeof(struct event *),1,fp) == 1)
    {
        if ((*node = malloc(sizeof(struct event))) == NULL)
        {
            fprintf(stderr, "Error: malloc failed in restore\n");
            exit(EXIT_FAILURE);
        }
        (*node)->number = buffer.number;
        strcpy((*node)->name, buffer.name);
        (*node)->event_size = buffer.event_size;
        (*node)->gender = buffer.gender;
        (*node)->next = NULL;
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

//To be implemented

void insert_event(struct event **event_tbl)
{
    struct event *newEvent;
    char temp[10];
    int number;
    printf("Enter event code: ");
    scanf("%d", &number);
    if (number < 0)
    {
        printf("Invalid code\n");
        return;
    }

    while (*event_tbl != NULL)
    {
        if ((*event_tbl)->number == number)
        {
            printf("Event already exists.\n");
            return;
        }
        event_tbl = &((*event_tbl)->next);
    }

    if ((newEvent = malloc(sizeof(struct event))) == NULL)
    {
        fprintf(stderr, "Error: malloc failed in restore\n");
        exit(EXIT_FAILURE);
    }
    newEvent->number=number;
    while (getchar() != '\n');
    printf("Enter event name: ");
    fgets(newEvent->name, 50,stdin);
    newEvent->name[strlen(newEvent->name) - 1] = '\0';
    //fgets(newEvent->name, 50,stdin);
    printf("Enter number of competitors: ");
    scanf("%d", &(newEvent->event_size));
    if (newEvent->event_size < 10 || newEvent->event_size>99)
    {
        printf("Invalid number of competitors!\n");
        free(newEvent);
        return;
    }
    printf("Enter the gender: ");
    fgets(temp,9,stdin);
    fgets(temp, 9,stdin);
    newEvent->gender=temp[0];
    if ((!(newEvent->gender == 'M' || newEvent->gender == 'W' || newEvent->gender == 'X'))
            )
    {
        printf("Invalid gender!\n");
        free(newEvent);
        return;
    }
    //newEvent->next = *event_tbl;

    *event_tbl = newEvent;
    newEvent->next = NULL;
}

void search_event(struct event **event_tbl)
{
    int code;
    printf("Enter event code: ");
    scanf("%d", &code);
    while (*event_tbl)
    {
        if ((*event_tbl)->number == code)

        {
            printf("Event Code      Event Name          Competitors      Gender\n");
            printf("%6d\t%15s\t%18d\t\t%7c\n", (*event_tbl)->number, (*event_tbl)->name,
                   (*event_tbl)->event_size, (*event_tbl)->gender);
            return;
        }
        event_tbl = &(*event_tbl)->next;
    }
    printf("Not found\n");
}

void update_event(struct event **event_tbl)
{
    int code;
    char temp[10];
    struct event *newEvent;
    printf("Enter event code: ");
    scanf("%d", &code);
    while (*event_tbl)
    {
        if ((*event_tbl)->number == code)
        {
            newEvent = (*event_tbl);
            printf("Enter event name: ");
            fgets(newEvent->name, 50,stdin);
            fgets(newEvent->name, 50, stdin);
            printf("Enter number of competitors: ");
            scanf("%d", &(newEvent->event_size));
            if (newEvent->event_size < 10 || newEvent->event_size>99)
            {
                printf("Invalid number of competitors!\n");
                free(newEvent);
                return;
            }
            printf("Enter the gender: ");
            fgets(temp, 9, stdin);
            fgets(temp, 9, stdin);
            newEvent->gender = temp[0];
            if ((!(newEvent->gender == 'M' || newEvent->gender == 'W' || newEvent->gender == 'X'))
                || strlen(temp) != 1)
            {
                printf("Invalid gender!\n");
                free(newEvent);
                return;
            }

            return;
        }
        event_tbl = &(*event_tbl)->next;
    }
    printf("Not found\n");

}

void print_event(struct event **event_tbl)
{
    printf("Event Code      Event Name          Competitors      Gender\n");
    while (*event_tbl)
    {
        printf("%6d\t%15s\t%18d\t\t%7c\n", (*event_tbl)->number, (*event_tbl)->name,
               (*event_tbl)->event_size, (*event_tbl)->gender);

        event_tbl = &(*event_tbl)->next;
    }

}

void erase_event(struct event **event_tbl)
{
    int code;
    struct event *temp;
    printf("Enter event code: ");
    scanf("%d", &code);
    while (*event_tbl)
    {
        if ((*event_tbl)->number == code)
        {
            temp = *event_tbl;
            *event_tbl = (*event_tbl)->next;
            free(temp);
            printf("deleted!\n");
            return;
        }
        event_tbl = &(*event_tbl)->next;
    }
    printf("Not found\n");
}

