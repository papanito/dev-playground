#!/usr/bin/python
team_name=json.dumps({ 'Maja':
                        {'date':'2019-11-12',
                        '1RM squat(kg)':50},
                        'Sofia':
                        {'date':'2019-11-12',
                        '1RM squat(kg)':55},
                        'David':
                        {'date':'2019-11-17',
                        '1RM squat(kg)':90},
                        'Martin':
                        {'date':'2019-11-10',
                        '1RM squat(kg)': 100},
                        'Hanna':
                        {'date':'2019-10-20',
                        '1RM squat(kg)':120}})

y=json.loads(team_name)
#creates data frame to get an output easier to read
df=pd.DataFrame(y)
print (df)