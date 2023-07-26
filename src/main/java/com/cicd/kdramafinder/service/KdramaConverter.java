package com.cicd.kdramafinder.service;

import java.util.ArrayList;
import java.util.List;

import com.cicd.kdramafinder.entity.KdramaEntity;

public class KdramaConverter {
	public static List<KdramaEntity> convertToEntityList(KdramaDto kdramaDto) {
        List<KdramaEntity> kdramaEntities = new ArrayList<>();

        // Assuming KdramaEntity class is a JPA entity representing the database table
        KdramaEntity kdramaEntity = new KdramaEntity();
        kdramaEntity.setId(kdramaDto.getId());
        kdramaEntity.setTitle(kdramaDto.getTitle());
        kdramaEntity.setDescription(kdramaDto.getDescription());
        // Set other fields as needed

        kdramaEntities.add(kdramaEntity);

        return kdramaEntities;
    }
}
