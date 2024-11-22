package project.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.dto.ImageDto;
import project.interface1.Iimage;
import project.utils.Response;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

@Autowired
   private Iimage  iimage;

@PostMapping("//")
public ResponseEntity<Response> createImage(@RequestPart String imageDto1, @RequestPart List<MultipartFile> imagemultipart) {
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        ImageDto imageDto = objectMapper.readValue(imageDto1, ImageDto.class);

        ImageDto imageDtos = iimage.createImage(imageDto, imagemultipart);
        Response response = new Response("Property Added Successfully", imageDtos, false);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    catch (Exception e) {
        Response errorResponse = new Response("Failed to add a property", e.getMessage(), true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}


 @GetMapping("/get")
    public ResponseEntity<Response> getAll(){
    try{
        List<ImageDto>  dto=iimage.getAll();
        Response response=new Response("get All Successfully",dto,false);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    catch (Exception e){
        Response err=new Response("get Not successfully",e.getMessage(),true);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
 }


}
