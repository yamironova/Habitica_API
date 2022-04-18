package smoke;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Tag;
import org.junit.jupiter.api.Test;
import requests.tags.DeleteTag;
import requests.tags.GetTags;
import requests.tags.PostTag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTagsTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("'post-get all - get one - delete tag")
    public void smokeTest () {

        //create tag
        Tag myTag = new Tag("TEXT", "JavaTag" );
        // post Tag
        Tag responseTag = PostTag.postOne(myTag);
        myTag.setId(responseTag.getId());
        //get all tags
        Tag[] tagArrayNew = GetTags.getAll();
        System.out.println(tagArrayNew.length);
        //get my tag
        Tag checkTag = GetTags.getOne(myTag.getId());

        assertEquals(myTag, checkTag);
        // delete tag
        Boolean deletingSuccess = DeleteTag.deleteTag(myTag.getId());

        //check
        tagArrayNew = GetTags.getAll();
        System.out.println(tagArrayNew.length);

        assertTrue(deletingSuccess);


    }
}
