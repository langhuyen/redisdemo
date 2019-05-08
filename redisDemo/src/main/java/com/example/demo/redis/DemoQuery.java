package com.example.demo.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class DemoQuery{

	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@Autowired
	StringRedisTemplate redisString;
	public void test() {

		List<String> key= new ArrayList<>();
		key.add("Hueyn1");
		key.add("nam");
		List<Object> keys=new ArrayList<Object>();
		long x=0;
		try {
	
			x=redisTemplate.opsForList().rightPushAll("key", key);
		keys=redisTemplate.opsForList().range("key", 0, 5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 ValueOperations<String, String> values = redisString.opsForValue();
         values.set("01", "Joe");
         values.set("02", "John");
	}
}
