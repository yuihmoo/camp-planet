package com.camp.planet.file.controller;

import com.camp.planet.file.dto.request.FileRequest;
import com.camp.planet.file.dto.response.UploadFileResponse;
import com.camp.planet.file.service.MinioFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class MinioFileController {
    private final MinioFileService minioFileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@ModelAttribute FileRequest fileRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new UploadFileResponse(minioFileService.uploadObject(fileRequest)));
    }
}
