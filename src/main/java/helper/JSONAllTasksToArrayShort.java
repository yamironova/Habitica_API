package helper;
import io.restassured.path.json.JsonPath;
import lombok.*;
import models.Task;
import java.util.LinkedHashMap;

import java.util.ArrayList;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class JSONAllTasksToArrayShort {

   // private Boolean success;
 private ArrayList<Task> data;
   // private JsonNode[] notifications;
   // private Integer userV;
   // private String appVersion;

    public static ArrayList<Task> getTaskIdNameTypeArray(JsonPath jsonPath) {
        ArrayList<Task> tasks = new ArrayList<Task>();

                    // ***Without COLLECTION***
                    // ***Using List***
        //  List<LinkedHashMap> linkedHashMap = jsonPath.getList("data");
         // for(LinkedHashMap x : linkedHashMap)
         //        {
         //            tasks.add(addReqTask(x));
         //            System.out.println(x);
         //            System.out.println("new");
         //       }
                     // ***Directly*** //
     //    int size = jsonPath.getList("data").size();
    //    for (int i = 0; i< size; i++)
        //    {
     //       tasks.add(addShortTask(jsonPath, i));
     //       System.out.println(jsonPath.getList("data").get(i) );
    //        System.out.println("new");
    //    }

                // ***WITH COLLECTION***
        jsonPath.getList("data").stream().forEach(x -> tasks.add(addReqTask((LinkedHashMap) x)));
    //    jsonPath.getList("data").stream().forEach(x -> System.out.println(getId((LinkedHashMap) x)));

        return tasks;
    }

    public static Task addReqTask (LinkedHashMap linkedHashMap) {
        return  new Task(linkedHashMap.get("id").toString(),
                linkedHashMap.get("text").toString(),
                linkedHashMap.get("type").toString());
    }

    public static Task addShortTask(JsonPath jsonPath, Integer i) {
       // possible option
        // Task task = new Task(id,text,type);
      //  task.setId(id);

        return new Task(jsonPath.getString("data["+ i +"].id"),
                jsonPath.getString("data["+ i + "].text"),
                jsonPath.getString("data[" + i +"].type"));
    }

    public static String getId (LinkedHashMap linkedHashMap) {
        return linkedHashMap.get("id").toString();
    }


}
