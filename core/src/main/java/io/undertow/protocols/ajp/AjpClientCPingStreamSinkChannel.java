package io.undertow.protocols.ajp;

import java.nio.ByteBuffer;

import io.undertow.xnio.protocols.framed.SendFrameHeader;
import io.undertow.util.ImmediatePooledByteBuffer;

/**
 * @author Stuart Douglas
 */
public class AjpClientCPingStreamSinkChannel extends AbstractAjpClientStreamSinkChannel {


    private static final byte[] CPING = {0x12, 0x34, 0, 1, 10}; //CPONG response data

    protected AjpClientCPingStreamSinkChannel(AjpClientChannel channel) {
        super(channel);
    }

    @Override
    protected final SendFrameHeader createFrameHeader() {
        return new SendFrameHeader(new ImmediatePooledByteBuffer(ByteBuffer.wrap(CPING)));
    }
}
