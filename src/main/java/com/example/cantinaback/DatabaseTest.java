package com.example.cantinaback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTest implements CommandLineRunner {

    private final MenuItemRepository menuItemRepository;

    public DatabaseTest(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        MenuItem menuItem = new MenuItem();
        menuItem.setName("Test Item");
        menuItem.setDescription("This is a test menu item.");
        menuItem.setPrice(9.99);
        menuItemRepository.save(menuItem);

        System.out.println(menuItemRepository.findAll());
    }
}