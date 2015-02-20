package info.conspire.temur.network;


import info.conspire.temur.game.messages.MessageHandler;
import info.conspire.temur.network.protocol.ClientMessage;
import info.conspire.temur.game.sessions.TemurSession;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Project Temur
 * @author Temujin
 */
public class TemurChannelHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LogManager.getLogger(TemurChannelHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        
        if (msg instanceof ClientMessage) {
            ClientMessage clientMessage = (ClientMessage)msg;
            logger.info(clientMessage.getHeader());
            MessageHandler.handle(new TemurSession(ctx.channel(), 0L), clientMessage);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("Channel active");

    }
}
