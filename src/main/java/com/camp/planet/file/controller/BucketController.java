package com.camp.planet.file.controller;

import com.camp.planet.file.controller.handler.NotifyHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/bucket")
@RequiredArgsConstructor
public class BucketController {
    private final NotifyHandler notifyHandler;

    /**
     * Minio Notification : 파일 상태 관리 알림 EndPoint
     * @param events : minio event
     */
    @PostMapping("/notify")
    public void fileNotify(@RequestBody LinkedHashMap<String, Object> events) {
        System.out.println(events);
        notifyHandler.handleByEventName(events);
    }
}
