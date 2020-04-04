package com.gemini.chat.net;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 启动类
 *
 * @author xiaocuizi
 * @since 0.0.1 2020/4/3 14:57
 */
@Component
public class NetBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                HiServer.getInstance().start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
