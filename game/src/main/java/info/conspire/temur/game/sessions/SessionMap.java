package info.conspire.temur.game.sessions;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Temur
 *
 * @author Temujin
 */

public class SessionMap implements ISessionMap<TemurSession> {
    
    private Map<Channel, TemurSession> sessions = new HashMap<>();

    private Map<Channel, TemurSession> getSessions() {
        return sessions;
    }
    
    public TemurSession getByChannel(Channel channel) {
        return getSessions().get(channel);
        
    }
    
    public void addSession(TemurSession session) {
        this.sessions.put(session.getChannel(), session);
        
    }
    
    public void removeSession(Channel channel) {
        this.sessions.remove(channel);
        
    }
    
}
