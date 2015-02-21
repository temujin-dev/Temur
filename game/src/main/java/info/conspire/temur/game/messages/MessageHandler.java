package info.conspire.temur.game.messages;

import info.conspire.temur.game.messages.incoming.handshake.InitCryptoMessageEvent;
import info.conspire.temur.game.sessions.TemurSession;
import info.conspire.temur.network.protocol.ClientMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Temur
 * @author Temujin
 */
public class MessageHandler {
    
    public static Map<Integer, IncomingMessage> incomingMessages = new HashMap<Integer,IncomingMessage>();
    private static final Logger logger = LogManager.getLogger(MessageHandler.class);
    
    static {
        incomingMessages.put(206, new InitCryptoMessageEvent());
    }
    
    // TODO: Change to boolean
    public static void handle(TemurSession session, ClientMessage message) {
        if(!incomingMessages.containsKey(message.getID())) {
            logger.warn("Unknown message received (ID:"+message.getID()+" Data:"+message.getBody()+")");
        } else {
            incomingMessages.get(message.getID()).handle(session,message);
        }
    }
}
