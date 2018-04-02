package com.account.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.subscription.component.FeatureComponent;
import com.account.subscription.entity.Feature;

@RestController
@RequestMapping("/features")
public class FeatureController {

	FeatureComponent featureComponent;

	@Autowired
	FeatureController(FeatureComponent featureComponent) {
		this.featureComponent = featureComponent;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String createParnter(@RequestBody Feature featureRecord) {
		System.out.println("-----------Adding New Feature--------");
		return featureComponent.addFeature(featureRecord);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Feature> getAllFeatures() {
		// This returns a JSON or XML with the users
		return featureComponent.getAllFeatures();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Feature getFeatureByID(@PathVariable long id) {
		// This returns a JSON or XML with the users
		return featureComponent.getFeatureRecordByID(id);
	}

	// Edit an Feature by primary key
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	String updateFeature(@PathVariable long id) {
		// get that feature
		return featureComponent.updateFeatureData(featureComponent.getFeatureRecordByID(id));
	}
	//

}
