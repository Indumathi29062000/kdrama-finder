package com.cicd.kdramafinder.service;

import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cicd.kdramafinder.entity.KdramaEntity;
import com.cicd.kdramafinder.repository.KdramaRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service

public class DataFetcherService {

	private final KdramaRepository kdramaRepository;

    private final String tmdbApiUrl = "https://api.themoviedb.org/3/tv/popular";
    private final String apiKey = "5e77628056943f5e32e2c81466985887";

    public DataFetcherService(KdramaRepository kdramaRepository) {
        this.kdramaRepository = kdramaRepository;
    }
    public void fetchAndSaveLatestKdramas() {
        // Build the TMDB API URL with query parameters
        String fullUrl = tmdbApiUrl + "?api_key=" + apiKey;

        // Use RestTemplate to make a GET request to the TMDB API
        RestTemplate restTemplate = new RestTemplate();
        String responseJson = restTemplate.getForObject(fullUrl, String.class);

        // Parse the JSON response using Jackson ObjectMapper with the configuration
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            // Convert JSON response to KdramaDto (assuming KdramaDto represents the response structure)
            KdramaDto kdramaDto = objectMapper.readValue(responseJson, KdramaDto.class);

            // Save the latest Kdramas to the database
            List<KdramaEntity> kdramas = KdramaConverter.convertToEntityList(kdramaDto);
            kdramaRepository.saveAll(kdramas);
        } catch (Exception e) {
            // Handle exceptions if any
            e.printStackTrace();
        }
    }
}
	

