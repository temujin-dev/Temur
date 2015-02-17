package info.conspire.temur.network;


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
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("Channel active");
    }
}
