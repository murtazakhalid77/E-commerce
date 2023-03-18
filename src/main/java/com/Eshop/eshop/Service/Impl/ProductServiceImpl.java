package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ImageDto;
import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.IProductService;
import com.Eshop.eshop.domain.Image;
import com.Eshop.eshop.domain.Model;
import com.Eshop.eshop.domain.Product;
import com.Eshop.eshop.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements IProductService {
    ProductRepository productRepository;
    ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllByIsActive(true).stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO)  {
    Product dublicateProduct =productRepository.findByProductNameAndModel(productDTO.getProductName(),productDTO.getModel());
        if (dublicateProduct!=null){
            if (!dublicateProduct.getIsActive()){
                dublicateProduct.setIsActive(true);
                return toDto(dublicateProduct);
            }
            throw new RecordAlreadyExistException(String.format("Product Already exist by this name and model %s",dublicateProduct));
        }
//        ImageDto imageDto  =toImageDto((imageRepository.save(Image.builder()
//                .imageName(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtil.compressImage(file. getBytes()))
//                .build())));
//        productDTO.setImage(toImageDomain(imageDto));
        //productDTO.setImage();
        productDTO.setIsActive(true);
       return toDto(productRepository.save(toDomain(productDTO)));
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return toDto(product.get());
        }

        throw new RecordNotFoundException(String.format("Product Not Found On this Id => %d",id));
    }


    @Override
    public ProductDTO updateProductrById(Long id, Map<String, Object> fields) {
        Product product = productRepository.findById(id).get();
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Model.class,key);

            field.setAccessible(Boolean.TRUE);
            ReflectionUtils.setField(field,product,value);
        });
        return toDto(productRepository.save(product));
    }

    @Override
    public ProductDTO deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            product.get().setIsActive(false);
            return toDto(productRepository.save(product.get()));
        }
        throw new RecordNotFoundException(String.format("product Not Found On this Id => %d",id));

    }
    public Product toDomain(ProductDTO productDTO){
        return modelMapper.map(productDTO,Product.class);
    }
    public  ProductDTO toDto(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }
    ImageDto toImageDto(Image image){
        return modelMapper.map(image,ImageDto.class);
    }
    Image toImageDomain(ImageDto imageDto){
        return modelMapper.map(imageDto,Image.class);
    }
}
