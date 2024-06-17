package com.example.checkpoint_back.util;

import com.example.checkpoint_back.domain.category.Category;
import com.example.checkpoint_back.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

            this.createCategories();
    }

    private void createCategories() {
        Map<String, String> categories = new HashMap<>();
        categories.put("Chaise", "https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3BvcnR8ZW58MHx8MHx8fDA%3D");
        categories.put("Table Basse", "https://images.unsplash.com/photo-1604061986761-d9d0cc41b0d1?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8VGFibGUlMjBCYXNzZXxlbnwwfHwwfHx8MA%3D%3D");
        categories.put("Canapé", "https://plus.unsplash.com/premium_photo-1661407582641-9ce38a3c8402?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Q2FuYXAlQzMlQTl8ZW58MHx8MHx8fDA%3D");
        categories.put("Bureau", "https://plus.unsplash.com/premium_photo-1684711741945-3f75f80db991?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fEJ1cmVhdXxlbnwwfHwwfHx8MA%3D%3D");
        categories.put("Armoire", "https://images.unsplash.com/photo-1595428774223-ef52624120d2?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8QXJtb2lyZXxlbnwwfHwwfHx8MA%3D%3D");
        categories.put("Étagère", "https://images.unsplash.com/photo-1572734389279-e4fa423ca9db?q=80&w=3684&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        categories.put("Lampe de bureau", "https://images.unsplash.com/photo-1526040652367-ac003a0475fe?q=80&w=3870&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        categories.put("Tapis de sol", "https://images.unsplash.com/photo-1522790478022-8eb1742bf506?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fFRhcGlzJTIwZGUlMjBTb2x8ZW58MHx8MHx8fDA%3D");
        categories.put("Eclairage led", "https://images.unsplash.com/photo-1586753513812-462ed2a82584?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fCVDMyVBOWNsYWlyYWdlJTIwbGVkfGVufDB8fDB8fHww");

        for (Map.Entry<String, String> entry : categories.entrySet()) {
            Category category = Category.builder()
                    .name(entry.getKey())
                    .imgUrl(entry.getValue())
                    .build();

            this.categoryRepository.save(category);
        }
    }
}
