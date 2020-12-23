package utils;

import chany.tagcatcher.utils.ReadUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class InspectTagTest {

    @Test
    String readTagJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/tag.json");
        String tagJson = ReadUtils.read(resource);

        System.out.println(tagJson);
        return tagJson;
    }


}
