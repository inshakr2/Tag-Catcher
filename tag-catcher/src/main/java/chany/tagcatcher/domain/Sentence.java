package chany.tagcatcher.domain;

import chany.tagcatcher.utils.InspectTag;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;

@Entity
public class Sentence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName
    private String sentence;
    @CsvBindByName
    private int id;

    public Sentence(){
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
