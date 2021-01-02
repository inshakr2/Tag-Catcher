package chany.tagcatcher.domain;

import chany.tagcatcher.utils.InspectTag;
import chany.tagcatcher.utils.TagToOrg;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;


@Entity
public class Sentence {


    @CsvBindByName
    private String sentence;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean result;
    private String orgSentence;

    public String getOrgSentence() {
        return orgSentence;
    }

    public void setOrgSentence(String orgSentence) {
        this.orgSentence = TagToOrg.Convert(getSentence());
    }

    public boolean getResult() {
        return result;
    }

    public void setResult() {
        try {
            this.result = InspectTag.check(getSentence());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sentence(){
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {

        this.sentence = sentence;
    }

}
