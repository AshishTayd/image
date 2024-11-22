package project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.dto.ImageDto;
import project.entity.Image;
import project.interface1.Iimage;
import project.repository.ImageRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService implements Iimage {

    @Autowired
   private ImageRepository imageRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ImageDto createImage(ImageDto imageDto, List<MultipartFile> imagemultipart) throws IOException {
    List<byte[]> images=new ArrayList<>();
    for(MultipartFile multipartFile:imagemultipart) {
        images.add(multipartFile.getBytes());
        }
        imageDto.setImages(images);
     Image img =mapper.map(imageDto, Image.class);
      imageRepository.save(img);
      return mapper.map(img, ImageDto.class);

    }

    @Override
    public List<ImageDto> getAll() {
        List<Image> images=imageRepository.findAll();
        List<ImageDto> dtos=new ArrayList<>();
        for (Image image: images){

            ImageDto dto=mapper.map(image,ImageDto.class);
            if (image.getImages() != null) {
                List<String> base64Images = new ArrayList<>();
                for (byte[] image1 : image.getImages()) {
                    if (image1 != null) {
                        String base64Image = Base64.getEncoder().encodeToString(image1);
                        base64Images.add(base64Image);
                    }
                }
                dto.setBase64Images(base64Images);
        }
            dtos.add(dto);
    }
        return dtos;}
}
