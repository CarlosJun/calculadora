import requests

ploads = {'oper1':2,'oper2':25,'operacao':3}

r = requests.get('http://0.0.0.0:8080/', params=ploads)

print("Server response:",r.text)
print(r.url)