package com.cicd.kdramafinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;


import com.cicd.kdramafinder.entity.KdramaEntity;
import com.cicd.kdramafinder.service.KdramaService;

@RestController
@RequestMapping("/api/kdramas")
public class KdramaController {
	private final KdramaService kdramaService;

    @Autowired
    public KdramaController(KdramaService kdramaService) {
        this.kdramaService = kdramaService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<KdramaEntity>> getAllKdramasFromDatabase() {
        List<KdramaEntity> kdramas = kdramaService.getAllKdramas();
        return new ResponseEntity<>(kdramas, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<KdramaEntity>> getAllKdramas() {
        List<KdramaEntity> kdramas = kdramaService.getAllKdramas();
        return new ResponseEntity<>(kdramas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KdramaEntity> getKdramaById(@PathVariable Long id) {
        Optional<KdramaEntity> kdrama = kdramaService.getKdramaById(id);
        return kdrama.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<KdramaEntity> getKdramaByTitle(@PathVariable String title) {
        Optional<KdramaEntity> kdrama = kdramaService.getKdramaByTitle(title);
        return kdrama.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<KdramaEntity> addKdrama(@RequestBody KdramaEntity kdrama) {
    	KdramaEntity newKdrama = kdramaService.saveOrUpdateKdrama(kdrama);
        return new ResponseEntity<>(newKdrama, HttpStatus.CREATED);
    }

    /**@GetMapping("/search")
    public ResponseEntity<List<KdramaEntity>> searchKdramasByTitle(@RequestParam String query) {
        List<KdramaEntity> kdramas = kdramaService.searchKdramasByTitle(query);
        return new ResponseEntity<>(kdramas, HttpStatus.OK); }**/
    

}
