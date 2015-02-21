package info.conspire.temur.game.messages.incoming.handshake;

import info.conspire.temur.game.messages.IncomingMessage;
import info.conspire.temur.game.messages.outgoing.handshake.InitCryptoComposer;
import info.conspire.temur.game.sessions.TemurSession;
import info.conspire.temur.network.protocol.ClientMessage;

/**
 * Project Temur
 * @author Temujin
 */
public class InitCryptoMessageEvent implements IncomingMessage {
    @Override
    public void handle(TemurSession temurSession, ClientMessage clientMessage) {
        new InitCryptoComposer(temurSession, clientMessage).execute();
    }
}
