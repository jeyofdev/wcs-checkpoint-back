package com.example.checkpoint_back.domain.store;

import com.example.checkpoint_back.domain.store.Store;
import com.example.checkpoint_back.domain.store.StoreDTO;
import com.example.checkpoint_back.domain.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/")
    public ResponseEntity<StoreDTO> add(@RequestBody Store store) {
        Store newStore = storeService.add(store);
        StoreDTO storeDTO = StoreDTO.mapFromEntity(newStore);

        return new ResponseEntity<>(storeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<StoreDTO>> findAll() {
        List<Store> storeList = storeService.findAll();
        List<StoreDTO> productDTOList = storeList.stream().map(StoreDTO::mapFromEntity).toList();

        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<StoreDTO> findById(@PathVariable Long storeId) {
        Store store = storeService.findById(storeId);
        StoreDTO storeDTO = StoreDTO.mapFromEntity(store);

        return new ResponseEntity<>(storeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<String> delete(@PathVariable Long storeId) {
        String result = storeService.deleteById(storeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<StoreDTO> updateById(@RequestBody Store store, @PathVariable Long storeId) {
        Store storeToUpdated = storeService.updateById(store, storeId);
        StoreDTO storeDTO = StoreDTO.mapFromEntity(storeToUpdated);

        return new ResponseEntity<>(storeDTO, HttpStatus.OK);
    }
}
