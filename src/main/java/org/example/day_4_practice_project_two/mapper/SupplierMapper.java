package org.example.day_4_practice_project_two.mapper;

import org.example.day_4_practice_project_two.dto.SupplierDto;
import org.example.day_4_practice_project_two.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDto toDto(Supplier supplier);
    @Mapping(target = "id", ignore = true)
    Supplier toEntity(SupplierDto supplierDto);
}
