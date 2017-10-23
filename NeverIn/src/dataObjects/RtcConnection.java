package dataObjects;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Date;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import utils.MessagesService;
import utils.RoomsManager;

public class RtcConnection extends MessageInbound {
	
    private final String uniqueId;
    private int roomId = -1;

    /**
         * class c'tor
         * @param player - the player who opened this connection
         * @param roomId - the room id which this connection is inside
         */
    public RtcConnection(String uniqueId, int roomId) {
    	this.roomId = roomId;
    	this.uniqueId = uniqueId;
    }

    @Override
    protected void onOpen(WsOutbound outbound) {
        System.out.println(new Date() + " " + this.uniqueId + " has joined.");
    }

    @Override
    protected void onClose(int status) {
    	// remove the connection from the room
    	Room room = RoomsManager.instance().getRoom(roomId);
    	
    	if(room != null) {
	    room.removePlayer(this.uniqueId);
	    	
	    if(room.getRoomLength() == 0) {
	    	RoomsManager.instance().deleteRoom(roomId);
	    }
	    	
	    System.out.println(new Date() + " " + this.uniqueId + " has disconnected.");
	        
	    // sending bye message to all clients
	    String message = "{'type':'bye','uniqueId':"+this.uniqueId+"}";
	        
	    MessagesService.instance().broadcastMsgToAllRoomPlayers(this.uniqueId, this.roomId, message);
    	}
    	this.roomId = -1;
    }

    @Override
    protected void onBinaryMessage(ByteBuffer message) throws IOException {
        throw new UnsupportedOperationException("Binary message not supported.");
    }

    @Override
    protected void onTextMessage(CharBuffer message) throws IOException {
    	MessagesService.instance().parseRtcMessage(this.uniqueId, this.roomId, message.toString());
    }
    
    /**
         * send a message to the player (rtc messages)
         * @param message - the message to send
         * @return true if sent, false if failed
         */
    public boolean sendMessage(String message) {
	CharBuffer buffer = CharBuffer.wrap(message);
        try {
	    this.getWsOutbound().writeTextMessage(buffer);
	    return true;
	} catch (IOException e) {
	    e.printStackTrace();
	    return false;
	}
    }
    
    @Override
    public boolean equals(Object obj) {
    	RtcConnection con = (RtcConnection)obj;
    	return this.uniqueId.equals(con.getUniqueId());
    }

    public String getUniqueId() {
	return this.uniqueId;
    }
}