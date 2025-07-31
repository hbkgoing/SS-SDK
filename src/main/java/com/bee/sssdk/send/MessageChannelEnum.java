package com.bee.sssdk.send;

/**
 * 消息渠道类型枚举
 * 定义了不同的消息发送渠道类型
 *
 * @author hbk
 * @since 2025-7-31
 */
public enum MessageChannelEnum {
    SMS,        // 短信
    EMAIL,      // 邮件
    DINGTALK,   // 钉钉消息
    WECHAT,     // 微信公众号/小程序消息
    PUSH,       // App 推送通知
    // 以后还可以扩展，比如企业微信、短信回执等
}