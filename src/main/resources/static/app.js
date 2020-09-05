var stompClient = null;

function setSocketConnected(socketConnected) {
	$("#socketConnectButton").prop("disabled", socketConnected);
	$("#socketDisconnectButton").prop("disabled", !socketConnected);

	if (socketConnected) {
		$("#conversationTable").show();
	} else {
		$("#conversationTable").hide();
	}

	$("#messages").html("");
}

function connect() {
	var socket = new SockJS("/simple-stomp-websocket");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function (frame) {
		setSocketConnected(true);
		console.log("Connected: " + frame);

		stompClient.subscribe("/topic/conversation", function (messageResponse) {
			console.log("subscribed /topic/conversation");

			showMessageResponse(JSON.parse(messageResponse.body).content);
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}

	setSocketConnected(false);
	console.log("Disconnected");
}

function sendName() {
	stompClient.send("/app/message", {}, JSON.stringify({'name': $("#name").val()}));
}

function showMessageResponse(responseMessage) {
	console.log("showMessageResponse :: " + responseMessage);
	$("#messages").append("<tr><td>" + responseMessage + "</td></tr>");
}

$(function () {
	$("form").on("submit", function (e) {
		e.preventDefault();
	});

	$("#socketConnectButton").click(function () {
		connect();
	});

	$("#socketDisconnectButton").click(function () {
		disconnect();
	});

	$("#sendButton").click(function () {
		sendName();
	});
});