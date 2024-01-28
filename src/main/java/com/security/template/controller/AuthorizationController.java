package com.security.template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class AuthorizationController {
    private final RedisTemplate<String, String> redisTemplate;
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    }

    @PostMapping("/redis")
    public ResponseEntity<?> addRedisKey() {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set("test", "2");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/redis")
    public ResponseEntity<?> getRedisKey() {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get("test");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}
