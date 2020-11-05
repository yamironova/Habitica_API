package collectionTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Tag;
import org.junit.jupiter.api.Test;
import requests.GetTags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Collections.addAll;
import static java.util.Collections.frequency;

public class CollectionTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("some test")
    public void testCollection () {
        ArrayList<Tag> tags = new ArrayList<Tag>(), tags1 = new ArrayList<Tag>();
        Predicate<Tag> streamsPredicate = item -> item.getId() == "id";


       tags.add(Tag.randomTag());
        tags.add(Tag.randomTag());
        tags.add(Tag.randomTag());
        tags.add(Tag.randomTag());
        System.out.println(frequency(tags,Tag.defaultTag()));
        System.out.println(tags.stream()
                .filter(streamsPredicate).count());



        tags1 = tags.stream()
                .filter(streamsPredicate).collect(Collectors.toCollection(ArrayList::new));


        for(Tag o : tags) {
        System.out.println(o.getName());
            System.out.println(tags1.size());

        }

    }
}
