window.am.wsm = {
    stompClient : null,
    connect : function() {
        var socket = new SockJS(am.serverUtils.getServerUrl()+'/assetManagerWEBClient');
        this.stompClient = Stomp.over(socket);
        this.stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            am.wsm.stompClient.subscribe('/topic/greetings', function (greeting) {
                $( "#WSdialog" ).text(JSON.parse(greeting.body).content);
                $( "#WSdialog" ).dialog( "open" );
                $( "[aria-describedby='WSdialog']" ).css('top','810');
                $( "[aria-describedby='WSdialog']" ).css('left','5px');
                console.log(JSON.parse(greeting.body).content);
            });
        });
    },
    
    disconnect : function () {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
    },
    
    sendName : function(name) {
        this.stompClient.send("/app/hello", {}, JSON.stringify({'name': name}));
    }
}
$(function () {
    am.wsm.connect();
    $( "#WSdialog" ).dialog({ autoOpen: false });
});