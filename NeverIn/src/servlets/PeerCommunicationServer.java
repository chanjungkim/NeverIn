package servlets;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import persistance.entities.Account;
import utils.AccountManager;
import utils.RoomsManager;
import dataObjects.RtcConnection;
import dataObjects.Player;
import dataObjects.Room;

/**
 * Servlet implementation class NCServer
 */
@WebServlet(urlPatterns="/PeerCommunicationServer/*")
public class PeerCommunicationServer extends WebSocketServlet {
	
    private static final long serialVersionUID = 1L;
	
    /**
         * @see HttpServlet#HttpServlet()
         */
    public PeerCommunicationServer() {
        super();
    }

    @Override
    protected boolean verifyOrigin(String origin) {
        System.out.println(new Date() + " Connection from origin: " + origin);
        return true;
    }
	
    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
       try {
    	    // get the room id from the URI
	    String roomId = request.getRequestURI().replace("/pc/PeerCommunicationServer/", "");
	    // get the room instance
	    Room room = RoomsManager.instance().getRoom(Integer.parseInt(roomId));
	    // get the current logged in account
	    Account account = // get account instance
	    	
	    // only in case someone is logged in
	    if(account != null) {
	    	if(room != null) {
		    	Player player = room.getRoomPlayers().get(account.getUniqueId());
		    	RtcConnection connection = new RtcConnection(account.getUniqueId(), Integer.parseInt(roomId));
		    	player.setConnection(connection);
		    		
		    	return connection;
	    	}
	    }
	    	
	    System.out.println("CRITICAL ERROR: MUST CHECK");
	    return null;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}