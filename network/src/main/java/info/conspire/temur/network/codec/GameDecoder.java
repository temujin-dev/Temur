package info.conspire.temur.network.codec;

import info.conspire.temur.util.Base64Encoding;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Project Temur
 * @author Temujin
 */
public class GameDecoder extends ByteToMessageDecoder {
    private final static Logger logger = LogManager.getLogger(GameDecoder.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() < 6) {
            logger.warn("Unreadable message received");
        } else {
            logger.info(Arrays.toString(in.readBytes(in.readableBytes()).array()));
        }
    }
}
