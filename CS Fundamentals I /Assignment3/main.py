#Grace Gong
#studentnumber251151854
#Program is aimed at providing an analysis of sentiment for the twitter keywords based on the .txt file
#The keywords are providing a score from 1-10, which is then added and averaged out amongst the tweets that contain those keywords and is sorted based on location
#There are numerous regions, and based on the coordinates the tweets are then sorted into that region they are located in
#the program then analyses the average of the happiness score based on the average of the keywords that were in the tweets in that given location
# imports all functions that are used within the main function
from sentiment_analysis import compute_tweets
#the import is done so the module named sentiment_analysis and its function compute_tweets are recognized in the main.py portion
from os import path
#the os import is done to ensure that the file that is invalid can then be recognised and return 0 (or the empty list, basically nothing is shown as output if its invalid)
def main():
    # The 2 prompts below in this def main function ask the user for the files that they would like to analyze for the sentiment average and location data
    tweetFile = input("Please enter the name of the tweet file you wish to process: ")
    keyFile = input("Please enter the name of the keyword file you wish to use: ")
    # This line below checks to see if the file name is valid and if its not, then the output will be nothing.
    if not path.exists(tweetFile) or not path.exists(keyFile):
        return()
    #The line below takes the files and uses the function compute_tweets to return a list of values from the parameters tweetFile, keyFile
    values = compute_tweets(tweetFile, keyFile)
    # The line below takes the list of values and prints them in a readable fashion, with the average, number of keyword tweets and total number of tweets displayed
    #The analysis is repeated numerous times for each region, which is formatted to be displayed visually. This sectoin below is for the eastern region.
    print("\nEastern Region Analysis ")
    print("%-35s" % "Average:", values[0][0],
    "\n%-35s" % "Number of keyword tweets:", values[0][1],
    "\n%-35s" % "Total number of tweets:", values[0][2])
#The analysis is repeated numerous times for each region, which is formatted to be displayed visually. This sectoin below is for the central region.
    print("\nCentral Region Analysis")
    print("%-35s" % "Average:", values[1][0],
    "\n%-35s" % "Number of keyword tweets:", values[1][1],
    "\n%-35s" % "Total number of tweets:", values[1][2])
#The analysis is repeated numerous times for each region, which is formatted to be displayed visually. This sectoin below is for the mountain region.
    print("\nMountain Region Analysis")
    print("%-35s" % "Average:", values[2][0],
    "\n%-35s" % "Number of keyword tweets:", values[2][1],
    "\n%-35s" % "Total number of tweets:", values[2][2])
#The analysis is repeated numerous times for each region, which is formatted to be displayed visually. This sectoin below is for the pacific region.
    print("\nPacific Region Analysis")
    print("%-35s" % "Average:", values[3][0],
    "\n%-35s" % "Number of keyword tweets:", values[3][1],
    "\n%-35s" % "Total number of tweets:", values[3][2])
#each section prints the section of the region, the number of keyword tweets in that region, the total number of tweets, and then the values, as they correpond to that specific region coordinates
#The formatting is done with the % symbol and the new line spacing provides the linear appearance of the display below
# calls the main function, which will allow it to execute and be recognized
main()
