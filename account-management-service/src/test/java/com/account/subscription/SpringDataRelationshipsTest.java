/*package com.account.subscription;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.account.subscription.entity.Account;
import com.account.subscription.entity.Feature;
import com.account.subscription.entity.Packg;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountManagementServiceApplication.class, 
  webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringDataRelationshipsTest {
	
	@Autowired
    private TestRestTemplate template;
 
    private static String ACCOUNT_ENDPOINT = "http://localhost:8080/account/";
//    private static String DOCUMENT_ENDPOINT = "http://localhost:8080/documents/";
    private static String FEATURE_ENDPOINT = "http://localhost:8080/features/";
    private static String PACKAGE_ENDPOINT = "http://localhost:8080/packgs/";
 
//    private static String FEATURE_NAME = "My Feature";
    private static String PACKAGE_NAME = "Golden";
    
    
    @Test
    public void whenSaveOneToOneRelationship_thenCorrect() {
        Packg packg = new Packg(PACKAGE_NAME,"Golden Member");
        template.postForEntity(PACKAGE_ENDPOINT, packg, Packg.class);
        
        Account account = new Account();
        template.postForEntity(ACCOUNT_ENDPOINT, account, Account.class);
         
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-type", "text/uri-list");
        HttpEntity<String> httpEntity 
          = new HttpEntity<>(ACCOUNT_ENDPOINT + "/1", requestHeaders);
        template.exchange(PACKAGE_ENDPOINT + "/1/accountPackg", 
          HttpMethod.PUT, httpEntity, String.class);
     
        ResponseEntity<Packg> packgGetResponse 
          = template.getForEntity(ACCOUNT_ENDPOINT + "/1/packg", Packg.class);
        assertEquals("Package is incorrect", 
          packgGetResponse.getBody().getName(), PACKAGE_NAME);
    }

    @Test
    public void whenSaveOneToManyRelationship_thenCorrect() {
        Packg packg = new Packg(PACKAGE_NAME, "Golden Member");
        template.postForEntity(PACKAGE_ENDPOINT, packg, Packg.class);
     
        Feature feature1 = new Feature("Manual_Truck","Manual Trucks", packg);
        template.postForEntity(FEATURE_ENDPOINT, feature1, Feature.class);
     
        Feature feature2 = new Feature("Automatic_Truck","Auto Trucks", packg);
        template.postForEntity(FEATURE_ENDPOINT, feature2, Feature.class);
     
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");    
        HttpEntity<String> featureHttpEntity 
          = new HttpEntity<>(PACKAGE_ENDPOINT + "/1", requestHeaders);
        template.exchange(FEATURE_ENDPOINT + "/1/library", 
          HttpMethod.PUT, featureHttpEntity, String.class);
        template.exchange(FEATURE_ENDPOINT  + "/2/library", 
          HttpMethod.PUT, featureHttpEntity, String.class);
     
        ResponseEntity<Packg> packgGetResponse = 
          template.getForEntity(FEATURE_ENDPOINT + "/1/packg", Packg.class);
        assertEquals("Package is incorrect", 
          packgGetResponse.getBody().getName(), PACKAGE_NAME);
    }
    
    @Test
    public void whenSaveManyToManyRelationship_thenCorrect() {
//        Author author1 = new Author(AUTHOR_NAME);
//        template.postForEntity(AUTHOR_ENDPOINT, author1, Author.class);
//     
//        Book book1 = new Book("Animal Farm");
//        template.postForEntity(BOOK_ENDPOINT, book1, Book.class);
//     
//        Book book2 = new Book("1984");
//        template.postForEntity(BOOK_ENDPOINT, book2, Book.class);
//     
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.add("Content-type", "text/uri-list");
//        HttpEntity<String> httpEntity = new HttpEntity<>(
//          BOOK_ENDPOINT + "/1\n" + BOOK_ENDPOINT + "/2", requestHeaders);
//        template.exchange(AUTHOR_ENDPOINT + "/1/books", 
//          HttpMethod.PUT, httpEntity, String.class);
//     
//        String jsonResponse = template
//          .getForObject(BOOK_ENDPOINT + "/1/authors", String.class);
//        JSONObject jsonObj = new JSONObject(jsonResponse).getJSONObject("_embedded");
//        JSONArray jsonArray = jsonObj.getJSONArray("authors");
//        assertEquals("author is incorrect", 
//          jsonArray.getJSONObject(0).getString("name"), AUTHOR_NAME);
    }
}
*/