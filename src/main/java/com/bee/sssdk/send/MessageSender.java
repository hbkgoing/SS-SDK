package com.bee.sssdk.send;

import org.apache.logging.log4j.message.Message;

/**
 * 消息发送接口
 *
 * @author hbk
 * @since 2025-7-31
 */
public interface MessageSender {

    void send(SmsSendRequest smsSendRequest);

}
