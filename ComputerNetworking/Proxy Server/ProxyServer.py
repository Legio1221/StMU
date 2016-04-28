# --------------------------------------------------------
# @author: Oscar Guillermo Castro
# --------------------------------------------------------

from socket import import *
import sys
from _socket import SOCK_STREAM, AF_INET

if len(sys.argc) <= 1:
        print"Usage : python ProxyServer.py server_ip'\n[server_ip : It is the IP address of the proxy server"
sys.exit(2)

# Create a server socket, bind it to a port and start listening
tcpSerSock = socket(AF_INET, SOCK_STREAM)
#fill
tcpSerPort = 8888
tcpSerSock.bind(("",tcpSerPort))
tcpSerSock.listen(5)
#END

while 1:
    # Start receiving data from the client
    print "ready to serve..."
    tcpCliSock, addr = tcpSerSock.accept()
    print "Received a connection from: ", addr
    message = tcpCliSock.recv(1024)#fill / end
    print message
    # extract the filename from the given message
    print message.split()[1]
    filename = message.split()[1].partition("/")[2]
    print filename
    fileExist = "false"
    filetouse = "/" + filename
    print filetouse
    try:
        # Check whether the file exists in the Cache
        f = open(filetouse[1:],"r")
        outputdata = f.readlines()
        fileExist = "true"
        # ProxyServer finds a cache hit and generates a response message
        tcpCliSock.send("HTTP/1.0 200 OK\r\n")
        tcpCliSock.send("Content-Type:text/html\r\n")
        #fill
        for i in range(0,len(outputdata)):
            tcpCliSock.send(outputdata[i])
        #END
            print "read from cache"
        # Error handling for file not found in Cache
        except IOError:
            if fileExist == "false":
                #Create a socket on the proxy server
                c = socket(AF_INET, SOCK_STREAM)#fill / end
                hostn = filename.replace("www.","",1)
                print(hostn)
            try:
                # Connect to the socket to port 80
                #fill
                c.connect(hostn,80)
                #end
                #Create temp file on this socket and ask port 80
                fileobj = c.makefile('r',0)
                fileobj.write("GET " + "http://" + filename + "HTTP/1.0\n\n")
                # read response into buffer
                #fill
                #end
                #create a new file in the cache for requested file.
                # send response in buffer to client socket
                tmpFile = open("./" + filename, "wb")
                # Fill in start
                for i in range(0,len(buff)):
                    tmpFile.write(buff[i])
                tcpCliSock.send(buff[i])
                # End
            except:
                print "Illegal request"
        else:
                # HTTP response message for file not found.
                # fill
                print "Error 404, file not found!"
                # end
    # Close the client and the server sockets
    tcpCliSock.close()
#fill
if __name__ == '__main__':
    main()
#end