package chany.tagcatcher.domain;

import chany.tagcatcher.utils.InspectTag;
import com.opencsv.bean.CsvBindByName;

import java.io.IOException;

public class BACK_Sentence {

    @CsvBindByName
    private String sentence;
    @CsvBindByName
    private int id;
    private boolean result;

    public boolean getResult() {
        return result;
    }

    public void setResult() throws IOException {
        this.result = InspectTag.check(this.sentence);
    }

    public BACK_Sentence(){
    }

    public BACK_Sentence(int id, String sentence) throws IOException {
        setId(id);
        setSentence(sentence);
        setResult();
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
