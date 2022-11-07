package models.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DbInitializer {
    private final String driver;

    private final String url;

    public DbInitializer(String driver, String url){
        this.driver = driver;
        this.url = url;
    }

    public void init(){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url);

            String sql =
                    "CREATE TABLE ChatMessages "
                    + "("
                    + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY "
                    + " CONSTRAINT ChatMessages_PK PRIMARY KEY, "
                    + "author varchar(50), "
                    + "text varchar(1000), "
                    + "created timestamp"
                    + ")";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
