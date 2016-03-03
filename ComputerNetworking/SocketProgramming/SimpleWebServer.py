'''
Created on Mar 3, 2016
@organization: Saint Mary's University
@contact: Oscarg_1221@hotmail.com
@version: 1.0
@summary: A simple web server that takes in an HTML file and makes a connection with the server.
@attention: DOES NOT WORK WITH PYTHON 3.X
@author: Oscar Castro
'''

# Web Server Assignment

#import Socket Module
from socket import *

serverPort = 9876
serverSocket = socket(AF_INET,SOCK_STREAM)

#Prepare a server socket
serverSocket.bind(('',serverPort))
serverSocket.listen(1)
print("The web server is up on port ", serverPort)

while True:
    #Establish the connection
    print("Ready to serve")
    connectionSocket, addr = serverSocket.accept()
    
    try:
        message = connectionSocket.recv(1024)
        filename = message.split()[1]
        f = open(filename[1:])
        outputdata = f.read()
        
        #Send one HTTP header line into socket
        connectionSocket.send("HTTP/1.1 200 OK\r\n\r\n")
        #connectionSocket.send(outputdata)
        
        #Send the contents of the requested file to the Client
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i])
            
        connectionSocket.close()
    except IOError:
        #Send response message for file not Founder
        print("Eror 404: File not found.")
        connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n")
        connectionSocket.send("<html><head></head><body><h1>404 Not Found</h1></body></html>\r\n")
        #Close client socket
        connectionSocket.close()
serverSocket.close()