package com.jstar.config;

import com.jstar.Repository.UserInfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author Jayson
 * @version 1.0
 * @date 2023/12/23 22:11
 */

@Configuration
public class RepositoryConfig {

    @Bean
    public UserInfoRepository UserRepositoryBean() {
        return new UserInfoRepository();
    }
}
