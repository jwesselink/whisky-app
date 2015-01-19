package repsaj.whisky_app.backend.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.codehaus.jackson.map.ObjectMapper;
import repsaj.whisky_app.backend.model.Whisky;

public class MongoDB {

    private static final String WHISKY_COLLECTION = "whisky";
    private final String uri;
    private MongoClientURI clientURI;
    private MongoClient mongoClient;
    private DB db;

    public MongoDB(String uri) {
        this.uri = uri;
    }

    public void init() {
        clientURI = new MongoClientURI(uri);
    }

    public void start() throws UnknownHostException {
        mongoClient = new MongoClient(clientURI);
        db = mongoClient.getDB(clientURI.getDatabase());
    }

    public void stop() {
        mongoClient.close();
    }

    public Whisky store(Whisky whisky) throws IOException {
        DBCollection collection = db.getCollection(WHISKY_COLLECTION);
        ObjectMapper mapper = new ObjectMapper();
        whisky.setId(null);
        String jsonString = mapper.writeValueAsString(whisky);
        BasicDBObject basicDBObject = (BasicDBObject) JSON.parse(jsonString);
        collection.insert(basicDBObject);
        ObjectId id = (ObjectId)basicDBObject.get( "_id" );
        whisky.setId(id.toHexString());
        return whisky;
    }

    public List<Whisky> findAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Whisky> list = new ArrayList<>();
        DBCollection collection = db.getCollection(WHISKY_COLLECTION);
        try (DBCursor cursor = collection.find()) {
            while (cursor.hasNext()) {
                BasicDBObject dbobj = (BasicDBObject) cursor.next();
                Whisky tmp = toWhisky(dbobj, mapper);
                list.add(tmp);
            }
        }
        return list;
    }

    private Whisky toWhisky(BasicDBObject dbobj, ObjectMapper mapper) throws IOException {
        ObjectId id = (ObjectId) dbobj.remove("_id");
        Whisky tmp = mapper.readValue(dbobj.toString(), Whisky.class);
        tmp.setId(id.toHexString());
        return tmp;
    }

    public Whisky findById(String id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DBCollection collection = db.getCollection(WHISKY_COLLECTION);
        BasicDBObject dbobj = (BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id)));
        return toWhisky(dbobj, mapper);
    }
}
