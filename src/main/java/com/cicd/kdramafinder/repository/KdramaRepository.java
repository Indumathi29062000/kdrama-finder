package com.cicd.kdramafinder.repository;
import com.cicd.kdramafinder.entity.KdramaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KdramaRepository extends JpaRepository<KdramaEntity, Long> {
	
    Optional<KdramaEntity> findByTitle(String title);

}


