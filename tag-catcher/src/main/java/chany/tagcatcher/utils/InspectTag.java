package chany.tagcatcher.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * inspect
 *  - tag.json 가져오기
 *  - tag 추출
 *  - 꺽쇄
 *  - 태그
 */

public class InspectTag {

    // Read Tag.json file
    public static String readTagJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/tag.json");
        String tag = ReadUtils.read(resource);

        return tag;
    }

}
