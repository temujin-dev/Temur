package info.conspire.temur.game;

import info.conspire.temur.game.sessions.SessionMap;

/**
 * Project Temur
 * @author Temujin
 */
public class HabboHotel {
    
    private SessionMap sessionMap = new SessionMap();
    
    public SessionMap getSessionMap() {
        return this.sessionMap;
        
    }
    
    public static class HabboHotelFactory {
        static HabboHotel habboHotel;
        
        public static HabboHotel createHHInstance() {
            if(habboHotel == null) {
                habboHotel = new HabboHotel();
            }
            return habboHotel;
        }
        

        
    }
}
