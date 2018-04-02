package com.account.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.subscription.component.PackgComponent;
import com.account.subscription.entity.Packg;

@RestController
@RequestMapping("/packgs")
public class PackgController {

	PackgComponent packgComponent;

	@Autowired
	PackgController(PackgComponent packgComponent) {
		this.packgComponent = packgComponent;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String createParnter(@RequestBody Packg packgRecord) {
		System.out.println("-----------Adding New Packg--------");
		return packgComponent.addPackg(packgRecord);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Packg> getAllPackgs() {
		// This returns a JSON or XML with the users
		return packgComponent.getAllPackgs();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Packg getPackgByID(@PathVariable long id) {
		// This returns a JSON or XML with the users
		return packgComponent.getPackgRecordByID(id);
	}

	// Edit an Packg by primary key
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	String updatePackg(@PathVariable long id) {
		// get that packg
		return packgComponent.updatePackgData(packgComponent.getPackgRecordByID(id));
	}
	//

}
