package repsaj.whisky_app.backend;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import repsaj.whisky_app.backend.db.MongoDB;

public class ContextListener implements ServletContextListener {

    private MongoDB db;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            db = new MongoDB("mongodb://db:27017/whisky-app");
            db.init();
            db.start();
            
            Server.getInstance().setDb(db);
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            db.stop();
        } catch (Exception ex) {
        }
    }

}
