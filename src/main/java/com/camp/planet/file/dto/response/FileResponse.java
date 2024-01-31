package com.camp.planet.file.dto.response;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {
    private String bucketName;
    private String fileName;
    private HashMap<String, String> fileInfo;
}
