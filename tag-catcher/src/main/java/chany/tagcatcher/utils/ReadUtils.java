package chany.tagcatcher.utils;

import chany.tagcatcher.domain.Sentence;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream() ,"EUC-KR"))) {

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Sentence.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Sentence> sentences = csvToBean.parse();
            return sentences;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Sentence> readTextarea(String text) {

        String[] texts = text.split("\\r\\n");
        List<Sentence> sentences = new ArrayList<>();
        for (String row : texts) {
            Sentence sentence = new Sentence();
            sentence.setSentence(row);
            sentences.add(sentence);
        }

        return sentences;
    }

    

}

