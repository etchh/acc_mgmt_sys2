package com.account.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.subscription.component.DocumentComponent;
import com.account.subscription.entity.Document;

@RestController
@RequestMapping("/documents")
public class DocumentController {

	DocumentComponent documentComponent;

	@Autowired
	DocumentController(DocumentComponent documentComponent) {
		this.documentComponent = documentComponent;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String createParnter(@RequestBody Document documentRecord) {
		System.out.println("-----------Adding New Document--------");
		return documentComponent.addDocument(documentRecord);
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Document> getAllDocuments() {
		// This returns a JSON or XML with the users
		return documentComponent.getAllDocuments();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Document getDocumentByID(@PathVariable long id) {
		// This returns a JSON or XML with the users
		return documentComponent.getDocumentRecordByID(id);
	}

	// Edit an Document by primary key
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	String updateDocument(@PathVariable long id) {
		// get that document
		return documentComponent.updateDocumentData(documentComponent.getDocumentRecordByID(id));
	}
	//

}
