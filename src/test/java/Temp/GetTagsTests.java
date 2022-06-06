package Temp;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Tag;
import org.junit.jupiter.api.Test;
import requests.tags.GetTags;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GetTagsTests {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'Get all tags")
    public void getAllTagsTest () {


        // main check
        Tag[] tagArrayNew = GetTags.getAll();
        System.out.println(tagArrayNew.length);

        Tag firstTag = new Tag();
        firstTag.setId(tagArrayNew[0].getId());
        firstTag.setName(tagArrayNew[0].getName());

        Tag checkTag = GetTags.getOne(firstTag.getId());


    }
}
