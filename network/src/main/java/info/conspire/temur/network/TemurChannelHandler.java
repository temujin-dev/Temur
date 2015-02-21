package info.conspire.temur.network;


import com.google.inject.Inject;
import info.conspire.temur.game.HabboHotel;
import info.conspire.temur.game.messages.MessageHandler;
import info.conspire.temur.game.sessions.ISessionMap;
import info.conspire.temur.network.protocol.ClientMessage;
import info.conspire.temur.game.sessions.TemurSession;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

/**
 * Project Temur
 * @author Temujin
 */
public class TemurChannelHandler extends ChannelInboundHandlerAdapter {

    private ISessionMap<TemurSession> sessionMap;
    private static final Logger logger = LogManager.getLogger(TemurChannelHandler.class);
    
    @Inject
    public TemurChannelHandler(ISessionMap map) {
        this.sessionMap = map;
        
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        
        if (msg instanceof ClientMessage) {
            ClientMessage clientMessage = (ClientMessage)msg;
            TemurSession session = sessionMap.getByChannel(ctx.channel());
            session.handleMessage(clientMessage);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("Channel active");
        sessionMap.addSession(new TemurSession(ctx.channel(), new SecureRandom().nextLong()));
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        logger.info("Channel disconnected");
        sessionMap.removeSession(ctx.channel());
        
    }
}
