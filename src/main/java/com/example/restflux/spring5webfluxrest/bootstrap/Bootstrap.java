package com.example.restflux.spring5webfluxrest.bootstrap;

import com.example.restflux.spring5webfluxrest.domain.Category;
import com.example.restflux.spring5webfluxrest.domain.Vendor;
import com.example.restflux.spring5webfluxrest.repositories.CategoryRepository;
import com.example.restflux.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0) {
            // load seed data
            System.out.println("### Seeding data ###");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("### Seeded " + categoryRepository.count().block() + " categories");

            vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Michael").lastName("Weston").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Waters").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Buffett").build()).block();

            System.out.println("### Seeded " + vendorRepository.count().block() + " vendors");
        }
    }
}
