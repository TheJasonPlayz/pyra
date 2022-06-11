#include "sport_athlete.h"

/* dump: Dumps contents of the athlete_tbl to specified
 *       file. Prints error message and does not
 *       terminate program upon failure. Does not store
 *       next pointer.
 */
void dump_athlete(struct athlete **athlete_tbl)
{
    FILE *fp;
    char filename[255];
    struct athlete **node = athlete_tbl;

    printf("Enter name of output file: ");
    fgets(filename, 255,stdin);

    if ((fp = fopen(filename, "wb")) == NULL)
    {
        fprintf(stderr, "File %s could not be written\n", filename);
        return;
    }

    while (*node)
    {
        fwrite(*node, sizeof(struct athlete) - sizeof(struct athlete *), 1, fp);
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

/* restore: Restores contents from specified file. Does
 *          not terminate upon file open failure, but
 *          terminates upon malloc failure.
 */
void restore_athlete(struct athlete **athlete_tbl)
{
    FILE *fp;
    char filename[255];
    struct athlete buffer;
    struct athlete *temp;
    struct athlete **node;

    printf("Enter name of input file: ");
    fgets(filename, 255,stdin);

    if ((fp = fopen(filename, "rb")) == NULL)
    {
        fprintf(stderr, "Error: file %s cannot be opened\n", filename);
        return;
    }

    while (*athlete_tbl)
    {
        temp = *athlete_tbl;
        *athlete_tbl = (*athlete_tbl)->next;
        free(temp);
    }

    node = athlete_tbl;

    while (fread(&buffer,sizeof(struct athlete) - sizeof(struct athlete *),1,fp) == 1)
    {
        if ((*node = malloc(sizeof(struct athlete))) == NULL)
        {
            fprintf(stderr, "Error: malloc failed in restore\n");
            exit(EXIT_FAILURE);
        }
        (*node)->number = buffer.number;
        strcpy((*node)->name, buffer.name);
        (*node)->age = buffer.age;
        (*node)->gender = buffer.gender;
        (*node)->next = NULL;
        node = &(*node)->next;
    }
    fclose(fp);
    return;
}

//To be implemented


void insert_athlete(struct athlete **athlete_tbl)
{
    struct athlete *newAthlete;
    char temp[10];
    int number;
    printf("Enter athlete code: ");
    scanf("%d", &number);
    if (number < 0)
    {
        printf("Invalid code\n");
        return;
    }

    while (*athlete_tbl != NULL)
    {
        if ((*athlete_tbl)->number == number)
        {
            printf("Athlete already exists.\n");
            return;
        }
        athlete_tbl = &((*athlete_tbl)->next);
    }

    if ((newAthlete = malloc(sizeof(struct athlete))) == NULL)
    {
        fprintf(stderr, "Error: malloc failed in restore\n");
        exit(EXIT_FAILURE);
    }
    newAthlete->number = number;
    while (getchar() != '\n');
    printf("Enter athlete name: ");
    fgets(newAthlete->name, 50,stdin);
    newAthlete->name[strlen(newAthlete->name)-1]='\0';
    //fgets(newAthlete->name, 50,stdin);
    printf("Enter age: ");
    scanf("%d", &(newAthlete->age));
    if (newAthlete->age < 10 || newAthlete->age>99)
    {
        printf("Invalid age!\n");
        free(newAthlete);
        return;
    }
    printf("Enter the gender: ");
    fgets(temp, 9, stdin);
    fgets(temp, 9, stdin);
    newAthlete->gender = temp[0];
    if ((!(newAthlete->gender == 'M' || newAthlete->gender == 'W' || newAthlete->gender == 'X'))
            )
    {
        printf("Invalid gender!\n");
        free(newAthlete);
        return;
    }
    //newAthlete->next = *athlete_tbl;

    *athlete_tbl = newAthlete;
    newAthlete->next = NULL;
}

void search_athlete(struct athlete **athlete_tbl)
{
    int code;
    printf("Enter athlete code: ");
    scanf("%d", &code);
    while (*athlete_tbl)
    {
        if ((*athlete_tbl)->number == code)
        {
            printf("Athlete Code    Athlete Name          Age         Gender\n\n");
            printf("%6d\t%15s\t%18d\t\t%7c\n", (*athlete_tbl)->number, (*athlete_tbl)->name,
                   (*athlete_tbl)->age, (*athlete_tbl)->gender);
            return;
        }

        athlete_tbl = &(*athlete_tbl)->next;
    }
    printf("Not found\n");
}

void update_athlete(struct athlete **athlete_tbl)
{
    int code;
    char temp[10];
    struct athlete *newAthlete;
    printf("Enter athlete code: ");
    scanf("%d", &code);
    while (*athlete_tbl)
    {
        if ((*athlete_tbl)->number == code)
        {
            newAthlete = (*athlete_tbl);
            while (getchar() != '\n');
            printf("Enter athlete name: ");
            fgets(newAthlete->name, 50, stdin);
            newAthlete->name[strlen(newAthlete->name) - 1] = '\0';
            //fgets(newAthlete->name, 50, stdin);
            printf("Enter age: ");
            scanf("%d", &(newAthlete->age));
            if (newAthlete->age < 10 || newAthlete->age>99)
            {
                printf("Invalid age!\n");
                free(newAthlete);
                return;
            }
            printf("Enter the gender: ");
            fgets(temp, 9, stdin);
            //fgets(temp, 9, stdin);
            newAthlete->gender = temp[0];
            if ((!(newAthlete->gender == 'M' || newAthlete->gender == 'W' || newAthlete->gender == 'X'))
             )
            {
                printf("Invalid gender!\n");
                free(newAthlete);
                return;
            }

            return;
        }
        athlete_tbl = &(*athlete_tbl)->next;
    }
    printf("Not found\n");

}

void print_athlete(struct athlete **athlete_tbl)
{
    printf("Athlete Code      Athlete Name          Age      Gender\n");
    while (*athlete_tbl)
    {
        printf("%6d\t%15s\t%18d\t\t%7c\n", (*athlete_tbl)->number, (*athlete_tbl)->name,
               (*athlete_tbl)->age, (*athlete_tbl)->gender);

        athlete_tbl = &(*athlete_tbl)->next;
    }

}

void erase_athlete(struct athlete **athlete_tbl)
{
    int code;
    struct athlete *temp;
    printf("Enter athlete code: ");
    scanf("%d", &code);
    while (*athlete_tbl)
    {
        if ((*athlete_tbl)->number == code)
        {
            temp = *athlete_tbl;
            *athlete_tbl = (*athlete_tbl)->next;
            free(temp);
            printf("deleted!\n");
            return;
        }
        athlete_tbl = &(*athlete_tbl)->next;
    }
    printf("Not found\n");
}

