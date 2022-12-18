#Multi client Single server Chat Application

This application facilitates multiple clients (upto 10 at a single time) to interact each other 
using predefined commands.

#Entry Point

The application will kickstart from ServerEntryPoint class and ClientEntryPoint class. 
Run the class using small triangle option 
beside main method of both EntryPoint class in IntelliJ(first start ServerEntryPoint and then ClientEntryPoint)
, then application will start loading and wait for user input( such as hostname, port number and username)

#Project Description

The approach for this project is that a single server connects with upto 10 client at a same time and
lets them interact using private & public messages.

1. ChatServer class : This class will open server socket for clients to connect 
and also will be open for new connections.

2. Client Class : ChatServer will create this Client for each connected users.

3. Sender & Receiver Classes : Client class start two threads that will keep listening client socket 
input stream and client socket output stream for sending and receiving messages.

4. ServerHandler Class : This is a single thread for whole application that will hold common logic for all clients.
Such as, who all are connected, how to handle message in case of broadcast & user specific commands

5. ChatClient Class : This is a chatclient which will need host and portnumber to start.

6. ServerResponseHandler Class : This is a thread which will send Connect message to client through client socket
to server handler, once its success, it creates a new thread which is UserInputListener.

7. UserInputListener Class : This is a thread which will keep taking input from System.in (keyboard) from user
and send it to client socket.

#Assumptions

For this project, assumption is that each user can send direct messages to themselves without any blocking.

#Build Status

The project is building correctly.

#Tech/Framework used

Java 8 and Gradle.

#How to run

### Server

To run server, run class ServerEntryPoint.class. This will by default start the chat server on port 2050. To chage the port, change LISTENING_ON_PORT const.

### Client

To run client, run class ClientEntryPoint.class. Client will ask for port and host name(mostly "localhost"). Once the socket connection is established, client will ask for the username.


#Steps to ensure correctness

For correct behaviour of this application, any messages (with unrecognized commands) are defined as wrong
commands and help command is provided to user for his knowledge.
