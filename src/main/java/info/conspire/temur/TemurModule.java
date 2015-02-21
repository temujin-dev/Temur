package info.conspire.temur;

import com.google.inject.AbstractModule;
import info.conspire.temur.game.sessions.ISessionMap;
import info.conspire.temur.game.sessions.SessionMap;

/**
 * Project Temur
 * @author Temujin
 */
public class TemurModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ISessionMap.class).to(SessionMap.class);
    }
}
