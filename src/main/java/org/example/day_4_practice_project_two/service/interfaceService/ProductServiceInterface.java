package org.example.day_4_practice_project_two.service.interfaceService;

import org.example.day_4_practice_project_two.dto.ProductDto;

import java.util.List;

public interface ProductServiceInterface {

    ProductDto create(ProductDto productDto);
    ProductDto update(ProductDto productDto, Long productId);
    ProductDto delete(Long id);
    List<ProductDto> findAll();
    ProductDto findById(Long id);

}
