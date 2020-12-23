package chany.tagcatcher.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String tagJson = ReadUtils.read(resource);

        return tagJson;
    }

    // get Tags to List
    public static List<String> getTag() throws IOException {

        List<String> tags = new ArrayList<String>();
        String tagJson = readTagJson();

        String[] tagJsonLines = tagJson.split("\n");
        Pattern BtagPattern = Pattern.compile("\"B-[a-zA-Z]{3}");

        for(String line : tagJsonLines) {
            String trimLine = line.trim();

            if(trimLine.startsWith("\"B-")) {
                Matcher Btag = BtagPattern.matcher(trimLine);
                Btag.find();
                tags.add(Btag.group().replace("\"B-", ""));
            }
        }

        return tags;
    }

}
