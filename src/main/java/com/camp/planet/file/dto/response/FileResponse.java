package com.camp.planet.file.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 232836038145089523L;
    @SuppressWarnings("java:S1948")
    private MultipartFile file;
    private String bucketName;
    private String fileName;
    private HashMap<String, String> fileInfo;
}
