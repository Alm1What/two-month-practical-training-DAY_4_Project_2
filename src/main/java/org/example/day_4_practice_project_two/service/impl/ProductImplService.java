package org.example.day_4_practice_project_two.service.impl;

import jakarta.transaction.Transactional;
import org.example.day_4_practice_project_two.dto.ProductDto;
import org.example.day_4_practice_project_two.dto.SupplierDto;
import org.example.day_4_practice_project_two.entity.Product;
import org.example.day_4_practice_project_two.entity.Supplier;
import org.example.day_4_practice_project_two.mapper.ProductMapper;
import org.example.day_4_practice_project_two.mapper.SupplierMapper;
import org.example.day_4_practice_project_two.repository.ProductRepository;
import org.example.day_4_practice_project_two.repository.SupplierRepository;
import org.example.day_4_practice_project_two.service.interfaceService.ProductServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImplService implements ProductServiceInterface {

    private ProductMapper productMapper;
    private ProductRepository productRepository;
    private SupplierRepository supplierRepository;
    private SupplierMapper supplierMapper;


    public ProductImplService(ProductRepository productRepository,
                              ProductMapper productMapper,
                              SupplierRepository supplierRepository,
                              SupplierMapper supplierMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        // Валідація вхідних даних
        if (productDto == null) {
            throw new IllegalArgumentException("ProductDto cannot be null");
        }

        SupplierDto supplierDto = productDto.getSupplierDto();
        if (supplierDto == null) {
            throw new IllegalArgumentException("Supplier must be provided");
        }

        // Перевіряємо чи існує постачальник, якщо ні - створюємо нового
        Supplier supplier = supplierRepository.findByName(supplierDto.getName())
                .orElseGet(() -> {
                    Supplier newSupplier = supplierMapper.toEntity(supplierDto);
                    return supplierRepository.save(newSupplier);
                });

        // Конвертуємо ProductDto в Product і встановлюємо постачальника
        Product product = productMapper.toEntity(productDto);
        product.setSupplier(supplier);

        // Зберігаємо продукт
        Product savedProduct = productRepository.save(product);

        // Конвертуємо назад у DTO для відповіді
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto update(ProductDto productDto, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        if (productDto == null) {
            throw new IllegalArgumentException("ProductDto cannot be null");
        }


        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setStockQuantity(productDto.getStockQuantity());
        Supplier supplier = supplierRepository.findByName(productDto.getSupplierDto().getName())
                .orElseGet(() -> {
                    Supplier newSupplier = supplierMapper.toEntity(productDto.getSupplierDto());
                    return supplierRepository.save(newSupplier);
                });

        product.setSupplier(supplier);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);

    }

    @Override
    public ProductDto delete(Long id) {
        if (productRepository.existsById(id)) {
            Product product = productRepository.findById(id).get();
            productRepository.delete(product);
            return productMapper.toDto(product);
        } else {
            throw new IllegalArgumentException("product not exist");
        }
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        if (productRepository.existsById(id)) {
            return productMapper.toDto(productRepository.findById(id).get());
        } else {
            throw new IllegalArgumentException("product not exist");
        }
    }
}
