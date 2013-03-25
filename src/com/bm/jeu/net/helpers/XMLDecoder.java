package com.bm.jeu.net.helpers;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XMLDecoder extends OneToOneDecoder {

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
		if (msg instanceof EncodedString) {
			EncodedString encodedObj = (EncodedString) msg;
				XStream xstream = new XStream(new StaxDriver());
				Component message = (Component) xstream.fromXML(encodedObj.getEncodedMessage());
				return message;
		}
		return msg;
	}
}