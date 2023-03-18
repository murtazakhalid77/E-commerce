package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ImageDto;
import com.Eshop.eshop.Service.ImageService;
import com.Eshop.eshop.domain.Image;
import com.Eshop.eshop.repositories.ImageRepository;
import org.modelmapper.ModelMapper;
import com.Eshop.eshop.ImageUtil.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServieImpl implements ImageService {
    ImageRepository imageRepository;
    ModelMapper modelMapper;

    public ImageServieImpl(ImageRepository imageRepository, ModelMapper modelMapper) {
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public byte[] getImageByImageName(String imageName) {
        Optional<Image> image = imageRepository.findImageByImageName(imageName);
      return   ImageUtil.decompressImage(image.get().getImageData());

    }

    @Override
    public byte[] addImage(MultipartFile file) throws IOException {
      Image image =imageRepository.save(Image.builder()
                      .imageName(file.getOriginalFilename())
                      .type(file.getContentType())
                      .imageData(ImageUtil.compressImage(file. getBytes()))
              .build());
      if (image!=null){
          return ImageUtil.decompressImage(image.getImageData());
      }
      throw  new FileNotFoundException(String.format("Image not uploaded =>%s",file));

    }

    @Override
    public ImageDto deleteImageByImageName(Long id) {
        return null;
    }

    ImageDto toDto(Image image){
        return modelMapper.map(image,ImageDto.class);
    }
    Image toDomain(ImageDto imageDto){
        return modelMapper.map(imageDto,Image.class);
    }
}
