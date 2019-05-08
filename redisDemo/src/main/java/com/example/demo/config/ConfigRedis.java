package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ConfigRedis {

	@Bean
	  public JedisConnectionFactory redisConnectionFactory() {

	    RedisStandaloneConfiguration config=new RedisStandaloneConfiguration("localhost", 6379);
	    JedisConnectionFactory connect=new JedisConnectionFactory(config);
	    return connect;

	  }

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
				RedisTemplate<String, Object> template = new RedisTemplate<>();
				template.setConnectionFactory(redisConnectionFactory());
				return template;
	}
	@Bean
	public StringRedisTemplate redisStringTemplate() {
		StringRedisTemplate  stringTemplate=new StringRedisTemplate();
		stringTemplate.setConnectionFactory(redisConnectionFactory());
		return stringTemplate;
	}
}
