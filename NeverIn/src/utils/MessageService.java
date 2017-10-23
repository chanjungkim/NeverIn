package utils;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;

import persistance.entities.Account;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dataObjects.AccountConnection;
import dataObjects.Player;
import dataObjects.Room;
import dataObjects.RtcConnection;

public class MessagesService {

    // singleton instance
    private static MessagesService instance;
	
    /**
         * singleton lazy method
         * @return single instance
         */
    public static MessagesService instance() {
        if(instance == null) {
	    instance = new MessagesService();
	}
	return instance;
    }
	
    /**
         * private c'tor
         */
    private MessagesService() {
		
    }
	
    /**
         * parse RTC message
         * @param fromConnectionId - the unique id of the connection who received this message
         * @param roomId - the room id that this connection is inside
         * @param message - the message to parse
         */
    public void parseRtcMessage(String fromUniqueId, int roomId, String message) {
    	System.out.println(new Date() + " Received Message: " + message);
    	
    	// parse the message to json
    	JsonParser parser = new JsonParser();
        JsonObject o = (JsonObject)parser.parse(message);
        
        // case we need to broadcast this message to all connections
        if(!o.has("broadcast") || o.get("broadcast").getAsString().equals("All")) {
        	this.broadcastMsgToAllRoomPlayers(fromUniqueId, roomId, message);
        }
        else {
            // get the unique ids we need to send to
            String[] uniqueIds = o.get("broadcast").getAsString().split(",");
            // send to each unique id in the list the message
            this.broadcastMsgToSpecificRoomPlayers(uniqueIds, roomId, message);
        }
    }
	
    /**
         * broadcast a message to all peers inside a room
         * @param fromUniqueId - the unique id of the connection who requested the broadcast (the message will not send to him)
         * @param roomId - the room id that we want to broadcast to
         * @param message - the message to send
         * @return true if the message was sent to all peers, false if there was an error
         */
    public boolean broadcastMsgToAllRoomPlayers(String fromUniqueId, int roomId, String message) {
	System.out.println(new Date() + " broadcast message: " + message);
        
	Room room = RoomsManager.instance().getRoom(roomId);
		
    	// iterate connections inside this room
        if(room != null) {
        	
            // convert to json string, so we can send it over HTTP
            message = CommonUtils.stringifyToJsonObjectString(message);
            
            // send to each player
	    Collection<Player> roomsPlayers = room.getRoomPlayers().values();
	    for (Player player: roomsPlayers) {
		// make sure we don't broadcast to us (the same unique id)
		if(!player.getAccount().getUniqueId().equalsIgnoreCase(fromUniqueId)) {
		    RtcConnection con = player.getConnection();
		    if (con != null){
			con.sendMessage(message);
		    }				    
		}
	    }
        }
        return true;
    }
	
    /**
         * Send the message to the unique id's in a room
         * @param uniqueIds - the id's to send the message to
         * @param roomId - the room id of the players
         * @param message - the message to send
         * @return the status of sending
         */
     public boolean broadcastMsgToSpecificRoomPlayers(String[] uniqueIds, int roomId, String message) {
		
	// convert to json string, so we can send it over HTTP
        message = CommonUtils.stringifyToJsonObjectString(message);
        
	// send to each unique id in the list the message
    	ConcurrentMap<String, Player> roomsPlayers = RoomsManager.instance().getRoom(roomId).getRoomPlayers();
	for(String uniqueId : uniqueIds) {
	    RtcConnection con = roomsPlayers.get(uniqueId).getConnection();
	    if (con != null){
    		con.sendMessage(message);
			}
	    }
	    return true;
	}
    }
         /**
	  * parse client messages
	 * @param message - the message to parse
	 */
        public void parseClientMessage(String message) {
                // print the message
	System.out.println(new Date() + " Received Message: " + message);
		
	// parse the message to json
    	JsonParser parser = new JsonParser();
        JsonObject o = (JsonObject)parser.parse(message);
        
	if(o.has("broadcast")) {
                     // broadcast to room players
	  if(o.get("broadcast").getAsString().equals("room")) {
            String roomId = o.get("roomId").getAsString();
            String fromUniqueId = o.get("uniqueId").getAsString();
            broadcastClientMsgToAllRoomPlayers(fromUniqueId, Integer.parseInt(roomId), message);
	  }
                     else {
                         // get the unique ids we need to send to
	    String[] uniqueIds = o.get("broadcast").getAsString().split(",");
	    this.broadcastClientMsgToAccounts(uniqueIds, message);
	  }
               }
       }
	
	/**
	 * Send client messages to account through account connection
	 * @param uniqueIds - the unique ids to broadcast the message
	 * @param message - the message to broadcast
	 * @return
	 */
        public boolean broadcastClientMsgToAccounts(String[] uniqueIds, String message){
		
        // convert to json string, so we can send it over HTTP
        message = CommonUtils.stringifyToJsonObjectString(message);
        
        for(String uniqueId : uniqueIds){
            Account account = AccountManager.instance().getOnlineAccount(uniqueId);
            if (account != null){
               account.getAccountConnection().sendMessage(message);
            }        	
        }
    
        return true;
        }
	
	/**
	 * broadcast client message to all players inside a room
	 * @param fromUniqueId - the unique id of the connection who requested the broadcast (the message will not send to him)
	 * @param roomId - the room id that we want to broadcast to
	 * @param message - the message to send
	 * @return true if the message was sent to all players, false if there was an error
	 */
        public boolean broadcastClientMsgToAllRoomPlayers(String fromUniqueId, int roomId, String message) {
	System.out.println(new Date() + " broadcast message: " + message);
        
	Room room = RoomsManager.instance().getRoom(roomId);
		
    	// iterate connections inside this room
        if(room != null) {
        	
            // convert to json string, so we can send it over HTTP
            message = CommonUtils.stringifyToJsonObjectString(message);
            
            // send to each player
	    Collection<Player> roomsPlayers = room.getRoomPlayers().values();
	    for (Player player: roomsPlayers) {
		// make sure we don't broadcast to us (the same unique id)
	        String playerUniqueId = player.getAccount().getUniqueId();
		if(!playerUniqueId.equalsIgnoreCase(fromUniqueId)) {
		    Account playerAccount = AccountManager.instance().getOnlineAccount(playerUniqueId);
		    AccountConnection con = playerAccount.getAccountConnection();
		    if (con != null){
			con.sendMessage(message);
		    }				    
		}
	    }
        }
        return true;
    }
}