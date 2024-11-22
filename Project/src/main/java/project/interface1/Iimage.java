package project.interface1;

import org.springframework.web.multipart.MultipartFile;
import project.dto.ImageDto;

import java.io.IOException;
import java.util.List;

public interface Iimage {
    ImageDto createImage(ImageDto imageDto, List<MultipartFile> imagemultipart)throws IOException;

   List<ImageDto> getAll();
}
