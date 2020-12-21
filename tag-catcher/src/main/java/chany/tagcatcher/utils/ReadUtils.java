package chany.tagcatcher.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * upload 받아오기
 *  : csv read
 * json 가져오기
 *  : ClassPathResource
 */

public class ReadUtils {

    public static String read(ClassPathResource resource) throws IOException {

        Path path = Paths.get(resource.getURI());
        String contents = Files.readString(path);

        return contents;

    }

}

