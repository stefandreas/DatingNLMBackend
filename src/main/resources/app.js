var socket = new WebSocket("ws://localhost:8080/ws");
var stompClient = Stomp.over(socket);

var headers = {
    "Upgrade": "WebSocket",
    "Connection": "Upgrade"
};

socket.onopen = function (event) {
    console.log("Websocket Connection opened: ", event);

    stompClient.connect(headers, function (frame){
        console.log("STOMP connected: ", frame);
    })
}

socket.onmessage = function (event) {
    console.log("WebSocket message received: ", event);
};

socket.onclose = function (event) {
    console.log("WebSocket connection closed: ", event);
};

socket.onerror = function (error) {
    console.error("WebSocket error: ", error);
};

socket.headers = headers;