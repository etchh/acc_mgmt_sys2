package com.account.subscription.component;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.subscription.entity.Feature;
import com.account.subscription.repository.FeatureRepository;

@Component
public class FeatureComponent {
	private static final Logger logger = LoggerFactory.getLogger(FeatureComponent.class);

//	@Autowired
	FeatureRepository featureRepository;

	public FeatureComponent() {
		System.out.println("*******Component***********");
	}

	@Autowired
	FeatureComponent(FeatureRepository featureRepository) {
		this.featureRepository = featureRepository;
	}

	public FeatureRepository getFeatureRepository() {
		return featureRepository;
	}

	@Autowired
	public void setFeatureRepository(FeatureRepository featureRepository) {
		this.featureRepository = featureRepository;
	}

	/**
	 * Feature Sign Up (Registration)
	 */
	public String addFeature(Feature feature) {
		logger.info("Saving Feature ");
		featureRepository.save(feature);
		logger.info("Successfully saved Feature ");

		return "Saved";

	}

	/**
	 * View Feature’s profile
	 */
	public Feature getFeatureRecordByID(long id) {
		Optional<Feature> featureObject = featureRepository.findById(id);
		return featureObject.get();
	}

	/**
	 * get all feature
	 */
	public Iterable<Feature> getAllFeatures() {
		// This returns a JSON or XML with the feature
		return featureRepository.findAll();
	}

	// Edit feature data
	public String updateFeatureData(Feature feature) {
		logger.info("Feature to be updated ..."+ feature.getName());
		
		featureRepository.save(feature);
		logger.info("Successfully Updated the Feature ");

		return "Updated";

	}

}
