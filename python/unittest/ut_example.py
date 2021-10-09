#!/usr/bin/python
def doThis(x,y):
    return "do this"

def doThat(x,y):
    return "do that"


def simpleFunction(x,y):
    if  (5 <= x or y < 10):
        return doThis(x,y)
    else:
        return doThat(x,y)