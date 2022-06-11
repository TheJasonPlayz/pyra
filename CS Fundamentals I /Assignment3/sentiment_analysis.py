# Grace Gong
#This is the sentiment_analysis module while will be imported to the main.py area for the calculations to work and then be displayed
# For sentiment analysis, this file will have the function compute_tweets which gets the tweet file and analyzes it
# For this module the tweets to a key word file are used to deduce  the sentiment score
# after that, the function  will sort the sentiment score based on location of the tweet
# this file also imports punctuation which is  used later on

from string import punctuation
#below line the function compute_tweets whcih contains the parameters(tweets, keywords) is used to define the elements inside of it, which include the various lists which will be used to store the tuples of the data containing the keywords, tweet and average
def compute_tweets(tweets, keywords):
# defines some variables used later on
#each list is used to seperate the regions, have the total, and the score and the region aligns with the region named in the list. for example, easternKeyTotal describes the total of the keywords in the eastern region
#the list is done for each region because the values for each region need to be calculated individually, and then displayed in the main.py
    blankList = [(0, 0, 0), (0, 0, 0), (0, 0, 0), (0, 0, 0)]
    keyList = []
    easternTotal = 0
    centralTotal = 0
    mountainTotal = 0
    pacificTotal = 0
    easternKeyTotal = 0
    centralKeyTotal = 0
    mountainKeyTotal = 0
    pacificKeyTotal = 0
    easternScore = 0
    centralScore = 0
    mountainScore = 0
    pacificScore = 0

# the line below is a try loop which is used to ensure a correct entry is given, and the encoding is used in case of the presence of errors that the program may encounter, this will ensure that the program executes smoothly.( by avoiding the encoding errors)
    try:
        tweetFile = open(tweets, "r", encoding="utf-8")
        keywordFile = open(keywords, "r", encoding="utf-8")

# the line below outlines how it processes the selected keyword file and turns it to a list, by appending the element into the list
        for line in keywordFile:
            for element in processKeyFile(line):
                keyList.append(element)

# the line below shows the large loop for processing the entire tweet file, and it will continue processing until the end of the file
        for line in tweetFile:
# if there is an empty line it will skip the line
            if line == "" or line == "\n":
                continue

# the line below returns a list comprised of one single tweet
            tweetList = formatLine(line)

# the line below finds the region the tweet is located in (based on the coordinates which are displayed in the next section with the corresponding points) and returns the region name, for example, if its in eastern it will return eastern (see calculation below)
            region = findLocation(tweetList)

# sections below are divised for each region, and they are used to calculate the score of a single tweet based on the keyList given, for each region the total is calculated, by doing so until the end of the file is calculated
# the totals the tweets of a region, as well as the  key tweets of a region, and the score of a region are displayed (score as in the average happiness score as defined as the number between 1-10 averaged in each region )
# if the score of the line is not zero, it will add '1' to the key tweet total
#fianlly, the score will be calculated by adding up the averaged scores of the tweets that meet the keywords and their respective scores divided by the total later in the next section
            if region == "Eastern":
                easternTotal = easternTotal + 1
                if calculateAverage(tweetList, keyList) != 0:
                    easternKeyTotal = easternKeyTotal + 1
                    easternScore = easternScore + calculateAverage(tweetList, keyList)

            elif region == "Central":
                centralTotal = centralTotal + 1
                if calculateAverage(tweetList, keyList) != 0:
                    centralKeyTotal = centralKeyTotal + 1
                    centralScore = centralScore + calculateAverage(tweetList, keyList)

            elif region == "Mountain":
                mountainTotal = mountainTotal + 1
                if calculateAverage(tweetList, keyList) != 0:
                    mountainKeyTotal = mountainKeyTotal + 1
                    mountainScore = mountainScore + calculateAverage(tweetList, keyList)

            elif region == "Pacific":
                pacificTotal = pacificTotal + 1
                if calculateAverage(tweetList, keyList) != 0:
                    pacificKeyTotal = pacificKeyTotal + 1
                    pacificScore = pacificScore + calculateAverage(tweetList, keyList)

            # avoids a division by zero error if the tweet file has no key tweets for that region
            # calculates each region's score, by dividing the score (average of happiness values ) by the total number of words that had a keyword in it
        if easternKeyTotal != 0:
            easternScore = easternScore / easternKeyTotal
        if centralKeyTotal != 0:
            centralScore = centralScore / centralKeyTotal
        if mountainKeyTotal != 0:
            mountainScore = mountainScore / mountainKeyTotal
        if pacificKeyTotal != 0:
            pacificScore = pacificScore / pacificKeyTotal

            # returns all values calculated in a list that can be used when the function is called
        totalValues = [(easternScore, easternKeyTotal, easternTotal),
            (centralScore, centralKeyTotal, centralTotal),
            (mountainScore, mountainKeyTotal, mountainTotal),
            (pacificScore, pacificKeyTotal, pacificTotal)]

# the line below closes the tweet file which was opened earlier to compute the values for the average score and added up to calculate the total
        tweetFile.close()
            # the line below closes the keyword file which was opened earlier to compute the values  for the average score and added up to calculate the total
        keywordFile.close()
#the values are returned
        return totalValues

        # the line below shows how the program handles the error of an invalid file name, by returning a blank list which was shown in the above section with (0) in it
    except IOError:
        print("\nError: File not found.")
        return blankList

        # the line below shows how the program handles the error of an unreadable file, by returning a blank list which was shown in the above section with (0) in it
    except ValueError:
        print("\nError: Invalid file or format not correct.")
        return blankList

        #the line below shows how the program  handles the error of an unreadable file, by returning a blank list which was shown in the above section with (0) in it
    except IndexError:
        print("\nError: Invalid file or format not correct.")
        return blankList
  #the line below shows how the program  handles the error of an unreadable file, by returning a blank list which was shown in the above section with (0) in it
    except RuntimeError as error:
        print("\nError:", str(error))
        return blankList
#the line below is used to strip the key from the scores which are speerated by the comma, the key file speperates the key which is the word that has the specifc score, and its score, so it can ba atrributed to the word and then added up later
def processKeyFile(line):
    line = line.strip()
    tempList = line.split(",")
    return tempList
#the line is formatted and split by each space
def formatLine(line):
    tweetList = line.split()

# the line below removes punctuation from coordinates and converts them to floats for calculation purposes
    for i in range(0, 2):
        tweetList[i] = tweetList[i].strip("[],")
    tweetList[0] = float(tweetList[0])
    tweetList[1] = float(tweetList[1])

# the line below removes the punctuation that is in front and behind the word and puts all words in lower case
    for i in range(2, len(tweetList)):
        tweetList[i] = tweetList[i].lower().strip(punctuation)
    return tweetList
#the function named def findLocation(tweetList): is used to locate the region and seperates it by the uppermost boundaries of the corners of each region, the points are first listed below
def findLocation(tweetList):
# coordinate value constants
    P1 = [49.189787, -67.444574]
    P2 = [24.660845, -67.444574]
    P3 = [49.189787, -87.518395]
    P5 = [49.189787, -101.998892]
    P7 = [49.189787, -115.236428]
    P9 = [49.189787, -125.242264]
    P10 = [24.660845, -125.242264]

# the line below defines variable region, which is going to be used in the function to speerate the coordinate values into its correct region based on the next section
    region = ""
#the region is first initialized with the space, before it is called and assigned later in the next section, just so it an be recognized later
#  the line below finds the region that the tweet is located in, based on the points on the uppermost boundaries of the divisors (as seen in the original assignment file) and then labelled for the region
    #the points tat are chosen are based on the boundaries, the points are in the borderline, which divides the one region from the other neighboring region and thats why 2 points are used
    if P1[0] >= tweetList[0] >= P2[0] and P1[1] >= tweetList[1] >= P10[1]:
        if P1[1] >= tweetList[1] > P3[1]:
            region = "Eastern"
        elif P3[1] > tweetList[1] > P5[1]:
            region = "Central"
        elif P5[1] > tweetList[1] > P7[1]:
            region = "Mountain"
        elif P7[1] > tweetList[1] >= P9[1]:
            region = "Pacific"
    return region
# the line below shows the function named calculateAverage with the parameters (tweetList, keyList): that is used to first initialize the score and count starting with 0, and then the loop below will start analysing
def calculateAverage(tweetList, keyList):
# defines variables that are used in the calculation
    score = 0
    count = 0

# in the line below the loop starts at the very first element that is a word from the tweet
    for i in range(5, len(tweetList)):

# in the line below, it checks to see if the element is all letters or else it may match to a number in keyList
        if tweetList[i].isalpha() and tweetList[i] in keyList:
            position = keyList.index(tweetList[i])
            score = score + int(keyList[position + 1])
            count = count + 1

    # in the line below, the if statement is used to avoid a division by zero error if the line has no key words.
    if score != 0:
        return score / count
    else:
        return score
