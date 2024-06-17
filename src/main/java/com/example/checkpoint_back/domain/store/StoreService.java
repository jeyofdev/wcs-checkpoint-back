package com.example.checkpoint_back.domain.store;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store findById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Store with id " + id + " not found. 😤☹️")
                );
    }

    public Store add(Store store) {
        return storeRepository.save(store);
    }

    public String deleteById(Long id) {
        Store storeToDeleted = findById(id);
        storeRepository.deleteById(id);

        return "Store " + storeToDeleted.getName() + " has been deleted successfully.";
    }

    public Store updateById(Store store, Long id) {
        Store storeToUpdated = findById(id);

        storeToUpdated.setName(store.getName());
        storeToUpdated.setAddress(store.getAddress());
        storeToUpdated.setDescription(store.getDescription());
        storeToUpdated.setImgUrl(store.getImgUrl());
        storeToUpdated.setProductList(store.getProductList());

        return storeRepository.save(storeToUpdated);
    }
}
