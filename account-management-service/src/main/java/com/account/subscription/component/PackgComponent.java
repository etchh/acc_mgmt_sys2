package com.account.subscription.component;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.subscription.entity.Packg;
import com.account.subscription.repository.PackgRepository;

@Component
public class PackgComponent {
	private static final Logger logger = LoggerFactory.getLogger(PackgComponent.class);

//	@Autowired
	PackgRepository packgRepository;

	public PackgComponent() {
		System.out.println("*******Component***********");
	}

	@Autowired
	PackgComponent(PackgRepository packgRepository) {
		this.packgRepository = packgRepository;
	}

	public PackgRepository getPackgRepository() {
		return packgRepository;
	}

	@Autowired
	public void setPackgRepository(PackgRepository packgRepository) {
		this.packgRepository = packgRepository;
	}

	/**
	 * Packg Sign Up (Registration)
	 */
	public String addPackg(Packg packg) {
		logger.info("Saving Packg ");
		packgRepository.save(packg);
		logger.info("Successfully saved Packg ");

		return "Saved";

	}

	/**
	 * View Packg’s profile
	 */
	public Packg getPackgRecordByID(long id) {
		Optional<Packg> packgObject = packgRepository.findById(id);
		return packgObject.get();
	}

	/**
	 * get all packg
	 */
	public Iterable<Packg> getAllPackgs() {
		// This returns a JSON or XML with the packg
		return packgRepository.findAll();
	}

	// Edit packg data
	public String updatePackgData(Packg packg) {
		logger.info("Packg to be updated ..."+ packg.getName());
		
		packgRepository.save(packg);
		logger.info("Successfully Updated the Packg ");

		return "Updated";

	}

}
