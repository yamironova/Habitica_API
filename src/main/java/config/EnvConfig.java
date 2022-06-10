package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnvConfig {
    // valid network settings
    public static final String URL_BASE = "https://habitica.com";
    public static final String PATH_TAG = "/api/v4/tags";
    public static final String X_CLIENT = "72cff60d-3873-4c29-bb66-09558ddafe92-HabiticaJavaTest";
    public static final String PATH_TASKS = "/api/v4/tasks/user";
    public static final String PATH_TASK = "/api/v4/tasks";

    // invalid settings
    public static final String WRONG_API_KEY = "00000000-0000-0000-0000-000000000000";
    public static final String WRONG_TOKEN_ERROR = "Unauthorized";



    public EnvConfig() throws FileNotFoundException {
    }

    public static String getUser_Id() {
        return readCred()[0];
    };
    public static String getAPI_key() {
        return readCred()[1];
    };

    private static String[] readCred() {
        File doc =
                new File("G:\\Codeart\\automatization\\Habitica_credentials.txt");
        Scanner obj = null;
        try {
                obj = new Scanner(doc);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return new String[]{obj.nextLine(),obj.nextLine()};
    }

}
