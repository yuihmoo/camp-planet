package com.camp.planet.file.controller;

import com.camp.planet.file.controller.handler.MinioNotifyHandler;
import com.camp.planet.file.service.MinioBucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/bucket")
@RequiredArgsConstructor
public class MinioBucketRestController {
    private final MinioBucketService minioBucketService;
    private final MinioNotifyHandler minioNotifyHandler;

    /**
     * Minio Bucket 생성
     * @param domainName : minio bucket name
     */
    @PostMapping()
    public ResponseEntity<Object> registerDomain(@RequestParam("domain_name") String domainName) {
        minioBucketService.createBucket(domainName);
        return ResponseEntity.ok().body("버켓 생성에 성공하였습니다.");
    }
    @DeleteMapping()
    public ResponseEntity<Object> deleteBucket(@RequestParam("bucket_name") String bucketName) {
        minioBucketService.deleteBucket(bucketName);
        return ResponseEntity.ok().body("버켓 삭제에 성공하였습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getBucketList() {
        return ResponseEntity.ok().body(minioBucketService.getBucketList());
    }

    @PatchMapping("/encrypt")
    public ResponseEntity<Object> setBucketEncrypt(@RequestParam("bucket_name") String bucketName) {
        minioBucketService.setBucketEncryption(bucketName);
        return ResponseEntity.ok().body("버켓 암호화 설정에 성공하였습니다.");
    }

    /**
     * Minio Notification : 파일 상태 관리 알림 EndPoint
     * @param events : minio event
     */
    @PostMapping("/notify")
    public void fileNotify(@RequestBody LinkedHashMap<String, Object> events) {
        System.out.println(events);
        minioNotifyHandler.handleByEventName(events);
    }
}
