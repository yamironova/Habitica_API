package helper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;
import models.Task;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

@Data
@ToString
@AllArgsConstructor
@Log4j2
@SuperBuilder

public class MyDate {
  //  @JsonFormat(pattern = "EEE MMM dd yyyy HH:mm:ss zzz")

    public static Date changeNextDueToDate(String s) throws ParseException {

      //  Tue Jun 07 2022 00:00:00 GMT+0300
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'ZZZ", Locale.ENGLISH);
        return dateFormat.parse(s);
    }
    //public static final String FORMAT_HEURE_JSON_SERIALIZE_2 = new String("EEE dd MMM yyyy HH:mm:ss ZZZZ");
    //@JsonSerialize(using = CustomJsonDateSerializer.class)
    //public static class CustomJsonDateSerializer extends JsonSerializer<Date> {
      //  @Override
        //public void serialize(Date value, JsonGenerator jgen,
        //                      SerializerProvider provider) throws IOException,
        //        JsonProcessingException {
            //SimpleDateFormat dateFormat = new SimpleDateFormat(Properties.General.FORMAT_HEURE_JSON_SERIALIZE_2);
       // }
    //}
}
