package chany.tagcatcher.domain;

import chany.tagcatcher.utils.InspectTag;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.IOException;

@Entity
public class DemoSentence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName
    private int id;

    @CsvBindByName
    private String sentence;

    public DemoSentence(){
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {

        this.sentence = sentence;
    }

}
