package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Dto.ImageDto;
import com.Eshop.eshop.Service.ImageService;
import com.Eshop.eshop.domain.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class ImageController {
//    ImageService imageService;
//
//    public ImageController(ImageService imageService) {
//        this.imageService = imageService;
//    }
//
//    @PostMapping("/image")
//    private ResponseEntity<?> addImage(@RequestParam("image") MultipartFile file) throws IOException {
//        byte [] imageData =imageService.addImage(file);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//             }
//
//    @GetMapping("/image/{imageName}")
//    private ResponseEntity<?> getImageByName(@PathVariable String imageName) {
//        byte [] imageData =imageService.getImageByImageName(imageName);
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
//
//    }
}
