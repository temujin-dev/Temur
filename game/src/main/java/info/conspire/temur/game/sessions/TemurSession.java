package info.conspire.temur.game.sessions;

import info.conspire.temur.game.messages.MessageHandler;
import info.conspire.temur.network.protocol.ClientMessage;
import io.netty.channel.Channel;

/**
 * Project Temur
 * @author Temujin
 */
public class TemurSession {
    
    private Channel channel;
    private long id;

    public TemurSession(Channel channel, long id) {
        this.channel = channel;
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }
    
    public void setChannel(Channel channel) {
        this.channel = channel;
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void handleMessage(ClientMessage clientMessage) {
        MessageHandler.handle(this, clientMessage);
    }
    //private Habbo habbo; 
}
