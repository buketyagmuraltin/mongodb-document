package com.altin.mongodbdocument;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {
    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("IndexTest");
    MongoCollection<Document> collection = database.getCollection("Object");

    public void document(Object object){
        Document document = new Document("name", object.getName())
                .append("contact", new Document("phone", object.getContact().getPhone())
                        .append("email", object.getContact().getEmail())
                        .append("location", object.getContact().getLocation()))
                .append("stars", object.getStars())
                .append("categories", object.getCategories());
        collection.insertOne(document);
    }


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Repository repository;

    @PostMapping("/add")
    public String save(@RequestBody Object object){
        document(object);
        repository.save(object);
        return "Added book";
    }

    @GetMapping("/all")
    public List<Object> getAllVars(){
        return repository.findAll();
    }
}
