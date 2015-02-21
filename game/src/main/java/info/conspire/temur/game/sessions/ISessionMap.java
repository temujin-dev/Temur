package info.conspire.temur.game.sessions;

import io.netty.channel.Channel;

/**
 * Project Temur
 * @author Temujin
 */
public interface ISessionMap<T> {
    public T getByChannel(Channel channel);
    public void addSession(T session);
    public void removeSession(Channel channel);
}
