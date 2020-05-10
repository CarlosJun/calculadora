import requests
import operator_pb2 as proto_operator
import postfix

# Math expression to process
exp = "5 - 3 / 8 + 5 * 9"

# Transform expression in postfix pattern
exp_postfix = postfix.infixToPostfix(exp)
# Remove spaces from string and tranform to dict
dic = {'operators':list(exp_postfix.replace(' ', ''))}

# Build the proptobuf message, appeding each operator
msg = proto_operator.msg()
for operator in dic['operators']:
	msg.operators.append(operator)
# Serialize the message to be sent
data = msg.SerializeToString()

print("Msg sent to the server:", data)

# Sent the message to the server
r = requests.post('http://0.0.0.0:8080/', data=data)
# Print the server response
print("Server response:",r.text)
print(r.url)