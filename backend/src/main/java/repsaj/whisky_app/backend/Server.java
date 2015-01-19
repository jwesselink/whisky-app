package repsaj.whisky_app.backend;

import repsaj.whisky_app.backend.db.MongoDB;

public class Server {

    private static final Server INSTANCE = new Server();
    private MongoDB db;

    private Server() {
    }

    public static Server getInstance() {
        return INSTANCE;
    }

    public MongoDB getDb() {
        return db;
    }

    public void setDb(MongoDB db) {
        this.db = db;
    }

}
