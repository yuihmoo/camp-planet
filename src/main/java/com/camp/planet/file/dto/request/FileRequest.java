package com.camp.planet.file.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 232836038145089522L;
    @SuppressWarnings("java:S1948")
    private MultipartFile file;
    private String bucketName;
}
