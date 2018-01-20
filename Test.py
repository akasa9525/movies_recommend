import csv
f1=file('bollywood\genre.csv','r')
for row in csv.reader(f1):
    print row
