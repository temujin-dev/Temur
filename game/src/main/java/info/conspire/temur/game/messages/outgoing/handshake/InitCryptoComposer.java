package info.conspire.temur.game.messages.outgoing.handshake;

import info.conspire.temur.game.messages.OutgoingMessage;
import info.conspire.temur.game.sessions.TemurSession;
import info.conspire.temur.network.protocol.ClientMessage;
import info.conspire.temur.network.protocol.ServerMessage;

/**
 * Project Temur
 * @author Temujin
 */
public class InitCryptoComposer extends OutgoingMessage {
    public InitCryptoComposer(TemurSession session, ClientMessage clientMessage) {
        super(session, clientMessage);
    }

    @Override
    public void execute() {
        this.session.getChannel().writeAndFlush(new ServerMessage(277).append("576b145a0c17f8a385971e0b6324a4bc").getBytes());

    }
}
