package com.camp.planet.file.controller;

import com.camp.planet.file.dto.request.FileRequest;
import com.camp.planet.file.service.MinioFileService;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class MinioFileRestController {
    private final MinioFileService minioFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute FileRequest fileRequest) {
        String preSignedUrl = minioFileService.getPreSignedUrl(fileRequest, Method.PUT);
        return ResponseEntity.status(HttpStatus.OK).body(preSignedUrl);
    }
}
