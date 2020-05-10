import http.server
import socketserver
import json
import operator_pb2 as proto_operator
import postfix
from urllib.parse import urlparse
from urllib.parse import parse_qs

# Simple calculator
def calculator(oper1, oper2, operacao):

	if operacao == 1:
		return oper1 + oper2
	elif operacao == 2:
		return oper1 - oper2
	elif operacao == 3:
		return oper1 * oper2
	elif operacao == 4:
		return oper1 / oper2
	else:
		return "operacaoo inexistente"

class MyHttpRequestHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        # Sending an '200 OK' response
        self.send_response(200)

        # Setting the header
        self.send_header("Content-type", "text/html")

        # Whenever using 'send_header', you also have to call 'end_headers'
        self.end_headers()

        query_components = parse_qs(urlparse(self.path).query)

        oper1 = 0
        oper2 = 0
        operacao = 1

        if 'oper1' in query_components:
            oper1 = float(query_components["oper1"][0])
            print(oper1)
        if 'oper2' in query_components:
            oper2 = float(query_components["oper2"][0])
            print(oper2)
        if 'operacao' in query_components:
            operacao = int(query_components["operacao"][0])
            print(operacao)

        # Take the result from simple calculator
        resultado = calculator(oper1, oper2, operacao)
        
        # Write result as html
        html = f"{resultado}"

        # Writing the HTML contents with UTF-8
        self.wfile.write(bytes(html, "utf8"))

        return

    def do_POST(self):
    	# Sending an '200 OK' response
        self.send_response(200)

        # Setting the header
        self.send_header("Content-type", "text/html")

        # Whenever using 'send_header', you also have to call 'end_headers'
        self.end_headers()

        # Gets the size of data
        content_length = int(self.headers['Content-Length']) 
        # Gets the data itself
        post_data = self.rfile.read(content_length)
        
        print("Data received from client:", post_data)

        # Try load the message as json object
        try:
        	response = json.loads(post_data)
        	operators = response['operators']
        # Else, deserialize the message as protobuf
        except ValueError as e:
        	msg = proto_operator.msg()
        	msg.ParseFromString(post_data)
        	operators = msg.operators

        # Transform chars of the msg as one string
        exp = ''.join(operators)
        # Evaluate the expression
        resultado = postfix.postfixEval(exp)

    	# Write result as html
        html = f"{resultado}"

        # Writing the HTML contents with UTF-8
        self.wfile.write(bytes(html, "utf8"))

        return


# Create an object of the above class
handler_object = MyHttpRequestHandler

PORT = 8080

try:
   my_server = socketserver.TCPServer(("", PORT), handler_object)
   print("Starting server...")
   # Star the server
   my_server.serve_forever()

except KeyboardInterrupt:
   print("You pressed ^C, finalizing...")
   my_server.socket.close()