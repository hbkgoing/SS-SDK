package com.bee.sssdk.send;

/**
 * 发送场景枚举
 * 定义了消息发送的不同场景类型
 *
 * @author hbk
 * @since 2025-7-31
 */

public enum SendSceneEnum {
    IMMEDIATE,    // 立即发送
    DELAYED,      // 延迟发送（延迟一段时间后发送）
    SCHEDULED     // 定时发送（在指定时间点发送）
}