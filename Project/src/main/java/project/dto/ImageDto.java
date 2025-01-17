package project.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ImageDto {
    private UUID id;

    private List<byte []> images;

    private List<String> base64Images;
}
