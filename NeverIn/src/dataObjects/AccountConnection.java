package dataObjects;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Date;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import utils.AccountManager;
import utils.MessagesService;

public class AccountConnection extends MessageInbound implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
    private final String uniqueId;
	
    /**
     * class constructor
     */
    public AccountConnection(String uniqueId) {
	this.uniqueId = uniqueId;
    }

    @Override
    protected void onOpen(WsOutbound outbound) {
        System.out.println(new Date() + " account " + this.uniqueId + " is now online.");
    }
	
    @Override
    protected void onClose(int status) {
	// remove from accounts
	AccountManager.instance().removeOnlineAccount(this.uniqueId);
		
	System.out.println(new Date() + " account " + this.uniqueId + " is now offline.");
    }
	
    @Override
    protected void onBinaryMessage(ByteBuffer message) throws IOException {
	throw new UnsupportedOperationException("Binary message not supported.");
    }

    @Override
    protected void onTextMessage(CharBuffer message) throws IOException {
	MessagesService.instance().parseClientMessage(message.toString());
    }
	
    /**
     * send a message to the account
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
}