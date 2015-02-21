package info.conspire.temur.network;

import info.conspire.temur.game.sessions.ISessionMap;
import info.conspire.temur.network.codec.GameDecoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Project Temur
 * @author Temujin
 */
public class NetworkBootstrap {


    public static void boot(String host, int port, ISessionMap map) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1000)
                    .localAddress(host, port)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    
                                    .addLast(new GameDecoder()).
                                    addLast(new TemurChannelHandler(map))
                                    ;


                        }
                    });

            ChannelFuture f = b.bind().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
