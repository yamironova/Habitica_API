package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnvConfig {
    // network settings
    public static final String URL_BASE = "https://habitica.com";
    public static final String PATH_TAG = "/api/v4/tags";
    public static final String X_CLIENT = "72cff60d-3873-4c29-bb66-09558ddafe92-HabiticaJavaTest";
    public static final String PATH_TASKS = "/api/v4/tasks/user";
    public static final String PATH_TASK = "/api/v4/tasks";
    public static final File doc =
            new File("G:\\Codeart\\automatization\\Habitica_credentials.txt");
    public static Scanner obj = null;

    static {
        try {
            obj = new Scanner(doc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public EnvConfig() throws FileNotFoundException {
    }

    public static String getUser_Id() {
        return obj.nextLine();
    };
    public static String getAPI_key() {
        return obj.nextLine();
    };

}
