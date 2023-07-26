package com.cicd.kdramafinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicd.kdramafinder.repository.KdramaRepository;
import com.cicd.kdramafinder.entity.*;
@Service
public class KdramaService {
    private final KdramaRepository kdramaRepository;

	@Autowired
    public KdramaService(KdramaRepository kdramaRepository) {
        this.kdramaRepository = kdramaRepository;
    }
	
    public List<KdramaEntity> getAllKdramas() {
        return kdramaRepository.findAll();
    }

    public Optional<KdramaEntity> getKdramaById(Long id) {
        return kdramaRepository.findById(id);
    }
    public Optional<KdramaEntity> getKdramaByTitle(String title) {
    	Optional<KdramaEntity> optionalKdrama = kdramaRepository.findByTitle(title);

        // Handle the optional correctly
        return Optional.ofNullable(optionalKdrama.orElse(null));
    }
    
   
    public KdramaEntity saveOrUpdateKdrama(KdramaEntity kdramaEntity) {
        return kdramaRepository.save(kdramaEntity);
    }
}
