package info.conspire.temur.network.codec;

import info.conspire.temur.util.FlashPolicy;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Project Temur
 * @author Temujin
 */
public class PolicyDecoder extends ByteToMessageDecoder {
    private static final Logger logger = LogManager.getLogger(PolicyDecoder.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        in.resetReaderIndex();
        // Policy byte
        if(in.readByte() == 0x3C) {
            in.discardReadBytes();
            logger.info("Policy request");
            ctx.write(FlashPolicy.XML_POLICY);

        } else {
            ctx.pipeline().remove(this);
            in.resetReaderIndex();
           // out.add(in.readBytes(in.readableBytes()));
        }
    }
}
