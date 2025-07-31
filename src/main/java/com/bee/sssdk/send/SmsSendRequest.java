package com.bee.sssdk.send;

import java.util.Map;

/**
 * 短信发送请求参数
 *
 * @author hbk
 * @since 2025-7-31
 */
public class SmsSendRequest {
    /** 接收人（手机号、邮箱、用户ID等） */
    private String receiver;

    /** 短信内容 */
    private String content;

    /** 消息渠道 */
    private MessageChannelEnum channel;

    /** 发送场景 */
    private SendSceneEnum scene;

    /** 扩展参数（如模板参数等） */
    private Map<String, Object> extraParams;

    // Getter 和 Setter 方法


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(MessageChannelEnum channel) {
        this.channel = channel;
    }

    public SendSceneEnum getScene() {
        return scene;
    }

    public void setScene(SendSceneEnum scene) {
        this.scene = scene;
    }

    public Map<String, Object> getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(Map<String, Object> extraParams) {
        this.extraParams = extraParams;
    }
}