import requests
import json
import postfix

# Math expression to process
exp = "5 - 3 / 8 + 5 * 9"

exp_postfix = postfix.infixToPostfix(exp)

dic = {'operators':list(exp_postfix.replace(' ', ''))}
json_msg = json.dumps(dic)

print("JSON msg sent to the server:", json_msg)

r = requests.post('http://0.0.0.0:8080/', data=json_msg)

print("Server response:",r.text)
print(r.url)