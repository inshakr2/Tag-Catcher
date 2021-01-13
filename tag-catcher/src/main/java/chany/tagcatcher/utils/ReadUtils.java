package chany.tagcatcher.utils;

import chany.tagcatcher.domain.Sentence;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * upload 받아오기
 *  : csv read
 * +++ csv 외 직접 입력 txt 받아오기 추가
 * json 가져오기
 *  : ClassPathResource
 */

public class ReadUtils {

    public static String read(ClassPathResource resource) throws IOException {

        Path path = Paths.get(resource.getURI());
        String contents = Files.readString(path);

        return contents;

    }

    public static List<Sentence> readCsv(MultipartFile file) {

        return List < Sentence >;
    }

    public static List<Sentence> readTextarea(String text) {
        return List < Sentence >;
    }

    

}

