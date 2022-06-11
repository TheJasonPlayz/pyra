CC=gcc
CFLAGS=-Wall -Wpedantic -Wextra -std=c99

default:
	make all

clean:
	rm -f *.o sport_events sport_athlete sport_db

# To be implemented

all: assignment5 sport_events.o sport_athlete.o sport_db.o

assignment5: sport_events  sport_athlete sport_db
	gcc -o assignment5  sport_events.o sport_athlete.o sport_db.o

sport_events: sport_events.c
	gcc -c sport_events.c

sport_athlete: sport_athlete.c
	gcc -c sport_athlete.c

sport_db: sport_db.c
	gcc -c sport_db.c
