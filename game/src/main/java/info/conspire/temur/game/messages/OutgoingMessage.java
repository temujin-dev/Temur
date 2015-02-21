package info.conspire.temur.game.messages;

import info.conspire.temur.game.sessions.TemurSession;
import info.conspire.temur.network.protocol.ClientMessage;

/**
 * Project Temur
 * @author Temujin
 */
// To implement Runnable, or not to implement Runnable, that is the question at hand.
public abstract class OutgoingMessage {

    protected TemurSession session;
    protected ClientMessage clientMessage;
    
    public OutgoingMessage(TemurSession session, ClientMessage clientMessage) {
        this.session = session;
        this.clientMessage = clientMessage;
    }
    
    public abstract void execute();
}
