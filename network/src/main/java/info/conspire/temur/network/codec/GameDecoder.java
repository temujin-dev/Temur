package info.conspire.temur.network.codec;

import info.conspire.temur.network.protocol.ClientMessage;
import info.conspire.temur.util.Base64Encoding;
import info.conspire.temur.util.FlashPolicy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Project Temur
 * @author Temujin
 */
public class GameDecoder extends MessageToMessageDecoder<Object> {
    private final static Logger logger = LogManager.getLogger(GameDecoder.class);
    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte delim = buf.readByte();
        
        if(delim == 60) {
            logger.info("Policy");
            ctx.channel().writeAndFlush(Unpooled.copiedBuffer(FlashPolicy.XML_POLICY.getBytes()));
            
        } else {
            int msgLen = Base64Encoding.PopInt(new byte[]{delim, buf.readByte(), buf.readByte()});
            int msgId = Base64Encoding.PopInt(buf.readBytes(2).array());
            ClientMessage clientMessage = new ClientMessage(msgId, (msgLen-2), buf.readBytes(msgLen-2));
            out.add(clientMessage);
        }
    }
}
