package com.cicd.kdramafinder.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KdramaDto {
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

    // Add other fields as needed


    // Default constructor
    public KdramaDto() {
    }
}
