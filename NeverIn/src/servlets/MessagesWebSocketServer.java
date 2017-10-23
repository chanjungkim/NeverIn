package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * Servlet implementation class MessagesWebSocketServlet
 */
@WebServlet("/MessagesWebSocketServer")
public class MessagesWebSocketServer extends WebSocketServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see WebSocketServlet#WebSocketServlet()
     */
    public MessagesWebSocketServer() {
        super();
    }

    @Override
    protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest request) {
	try {
	    // get current account
	    Account account = // get Account instance here
			
	    if (account != null) {
		// creating connection 
		AccountConnection ac = new AccountConnection(account.getUniqueId());
				
		// set the connection for account
		account.setAccountConnection(ac);
				
		// add account to the online connections
		AccountManager.instance().addOnlineAccount(account);
				
		return ac;
	    }
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

}