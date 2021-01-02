package chany.tagcatcher.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagToOrg {

    public static String Convert(String tagSentence) {


        String orgSentence = tagSentence.toString();

        Pattern tagPattern = Pattern.compile("<(.[^<]*):\\w{3}>");
        Matcher wholeTag = tagPattern.matcher(tagSentence);

        while (wholeTag.find()) {
            String tag = wholeTag.group(0);
            String org = wholeTag.group(1);
            orgSentence = orgSentence.replace(tag, org);
        }

        return orgSentence;
    }
}
