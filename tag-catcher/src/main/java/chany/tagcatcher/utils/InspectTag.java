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

    public boolean check(String sentence) {
        // clamp 체크
        //  | pass => tag 검사
        //      | pass => true
        //  | else => false

        return false;
    }

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

    // < , > 갯수 비교
    public static boolean CountClamp(String sentence) throws IOException {
        int left = 0 ;
        int right = 0 ;
        boolean result = false;

        for(int i=0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == '<') {
                left++;
            }
        }
        for(int i=0; i < sentence.length(); i++) {
            if(sentence.charAt(i) == '>') {
                right++;
            }
        }
        if(left == right) {
            result = true;
        }

        return result;

    }

    public static List<String> TagMatcher(String sentence) throws IOException {

        Pattern tagPattern = Pattern.compile("<.[^<]*?:[a-zA-Z가-힣\\s]*>");
        Matcher tagMatcher = tagPattern.matcher(sentence);
        List<String> tagsInSentence = new ArrayList<String>();
        while(tagMatcher.find()) {
            tagsInSentence.add(tagMatcher.group());
        }
        return tagsInSentence;
    }

}
