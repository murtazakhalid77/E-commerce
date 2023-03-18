package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ImageService {
    byte[]  getImageByImageName(String imageName);
    byte[]  addImage(MultipartFile file) throws IOException;
    ImageDto deleteImageByImageName(Long id);
}
