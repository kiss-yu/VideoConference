package com.nix.share.message;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author 11723
 */
public final class MessageContainer {
    /**
     * 消息队列
     * */
    private final static LinkedBlockingQueue<ImageMessage> MESSAGES = new LinkedBlockingQueue<>(100000);
    /**
     * 生产者添加消息
     * */
    public static void addMessage(ImageMessage message) {
        try {
            //添加消息被阻塞1秒后丢弃添加
            MESSAGES.offer(message,1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 消费者获取消息
     * */
    public static ImageMessage getMessage() {
        try {
            return MESSAGES.poll(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}