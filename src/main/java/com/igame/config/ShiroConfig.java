package com.igame.config;

import com.igame.realms.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-06 15:14
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        UserRealm userRealm = new UserRealm();

        userRealm.setCachingEnabled(true);
        return userRealm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/user/**", "authc");
        map.put("/logout", "logout");
        map.put("/testController/*", "anon");
        map.put("/**", "anon");
        chainDefinition.addPathDefinitions(map);

        return chainDefinition;
    }

    @ModelAttribute(name = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
