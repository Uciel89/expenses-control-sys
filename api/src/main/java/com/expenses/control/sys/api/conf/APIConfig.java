package com.expenses.control.sys.api.conf;

import io.github.cdimascio.dotenv.Dotenv;

public class APIConfig {
    public static void loadEnv() {
        Dotenv dotenv = Dotenv.configure().load();
        
        String springDataSourceUrl = dotenv.get("SPRING_DATASOURCE_URL");
        String mysqlUser = dotenv.get("MYSQL_USER");
        String mysqlPassword = dotenv.get("MYSQL_PASSWORD");

        System.setProperty("SPRING_DATASOURCE_URL", springDataSourceUrl);
        System.setProperty("MYSQL_USER", mysqlUser);
        System.setProperty("MYSQL_PASSWORD", mysqlPassword);
    }
    
}
