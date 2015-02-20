package info.conspire.temur.game.messages;

import info.conspire.temur.game.sessions.TemurSession;
import info.conspire.temur.network.protocol.ClientMessage;

/**
 * Project Temur
 * @author Temujin
 */
public interface IncomingMessage {
    public void handle(TemurSession temurSession, ClientMessage clientMessage);
}
