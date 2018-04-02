package com.account.subscription.component;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.account.subscription.entity.Document;
import com.account.subscription.repository.DocumentRepository;

@Component
public class DocumentComponent {
	private static final Logger logger = LoggerFactory.getLogger(DocumentComponent.class);

//	@Autowired
	DocumentRepository documentRepository;

	public DocumentComponent() {
		System.out.println("*******Component***********");
	}

	@Autowired
	DocumentComponent(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	public DocumentRepository getDocumentRepository() {
		return documentRepository;
	}

	@Autowired
	@Qualifier(value = "documentRepository")
	public void setDocumentRepository(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	/**
	 * Document Sign Up (Registration)
	 */
	public String addDocument(Document document) {
		logger.info("Saving Document ");
		documentRepository.save(document);
		logger.info("Successfully saved Document ");

		return "Saved";

	}

	/**
	 * View Document’s profile
	 */
	public Document getDocumentRecordByID(long id) {
		Optional<Document> documentObject = documentRepository.findById(id);
		return documentObject.get();
	}

	/**
	 * get all document
	 */
	public Iterable<Document> getAllDocuments() {
		// This returns a JSON or XML with the document
		return documentRepository.findAll();
	}

	// Edit document data
	public String updateDocumentData(Document document) {
		logger.info("User's document to be updated ..."+ document.getUserId());
		
		documentRepository.save(document);
		logger.info("Successfully Updated the Document ");

		return "Updated";

	}

}
