package org.example.day_4_practice_project_two.mapper;

import org.example.day_4_practice_project_two.dto.ProductDto;
import org.example.day_4_practice_project_two.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mapping(target = "supplierDto", source = "supplier")
    ProductDto toDto(Product product);

    @Mapping(target= "id", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    Product toEntity(ProductDto productDto);
}
