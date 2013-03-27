package com.bm.jeu.common.net;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.bm.jeu.common.ef.Component;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONEncoder extends OneToOneEncoder {

	public static EncodedString encodeMessage(Component message) throws IllegalArgumentException {
		Gson gson = new GsonBuilder().setExclusionStrategies(new JSONExclusionStrategy()).create();
		EncodedString output = new EncodedString(gson.toJson(message));
		return output;
	}
	
	//maybe ALL the data should be encoded in this way?

	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
		if (msg instanceof Component) {
            return encodeMessage((Component) msg);
        } else {
            return msg;
        }
	}

}
