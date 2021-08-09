#!/usr/bin/python

# Given some arbitrary text file, display the frequency in which all words are used.
# The text used can be found here: https://www.cs.cmu.edu/~rgs/oz-1.html 

import re
from urllib.request import urlopen

def wordcount_localfile(file):
    f = open(file, "r")
    wordcount(f.read())

def wordcount_url(url):
    body = urlopen(url).read().decode("utf8")
    text = re.sub(r'<.*?>', '', re.findall(r'<body>((.|\s)*)<\/body>', body, re.IGNORECASE)[0][0], 0, re.IGNORECASE)
    wordcount(text)

def wordcount(text):
    """
    Counts the words of a text
    """
    strIs = "is"
    matches = re.findall(r"([A-Za-z]+(\'s)?)", text)

    wordcount = {}

    for match in matches:
        word = match[0].lower() # we don't care about the capitalization, it still is the same word
        # in case 's represents an "is" then count it as such
        # otherwise we assume it shows possession and ignore 's e.g. "Dorothy's" will count as "Dorothy"
        if re.match(r"(there|it|where)\'s", word):
            if wordcount.get(strIs):
                wordcount[strIs] = wordcount[strIs]+1
            else:
                wordcount[strIs] = 1
        word = word.replace("'s", "")
        if wordcount.get(word):
            wordcount[word] = wordcount[word]+1
        else:
            wordcount[word] = 1

    wordcount = {key: value for key, value in sorted(wordcount.items(), key=lambda item: item[0])}
    for key, value in wordcount.items():
        print("{:<15}: {:<4}".format(key, value))


# I assume the file is locally stored
filename = "./resources/the-cyclone.txt"
wordcount_localfile(filename)

url = "https://www.cs.cmu.edu/~rgs/oz-1.html"
wordcount_url(url)