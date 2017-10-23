var serverIp = '{127.0.0.1}';
var serverPort = '{3336}';
var serverAddress = 'ws://'+serverIp+':'+serverPort+'/app/MessagesWebSocketServer';

var _ = {};

$.msgConn = _;

var socket = new WebSocket(serverAddress); 

socket.onmessage = onMessageRecieved;
 _.closeConnection = function() {
    // disable onclose handler first
    socket.onclose = function () {}; 
    socket.close();
 };

// send messages to server
function sendMessage(msg) {     
    socket.send(JSON.stringify(msg));  
};

// when a message recieved from server 
function onMessageRecieved(evt) {
     var msg = JSON.parse(evt.data);
     console.log("RECIEVED MSG: " + msg.type);
}