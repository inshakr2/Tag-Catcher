package chany.tagcatcher.utils;

import chany.tagcatcher.utils.InspectTag;
import chany.tagcatcher.utils.ReadUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class InspectTagTest {

    @Test
    public void 문장검사() throws IOException {
        boolean res = InspectTag.check("안녕하세요. <유창열:PER> 입니다.");
        System.out.println("res = " + res);
    }



}
