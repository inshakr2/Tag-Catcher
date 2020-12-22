package chany.tagcatcher.utils;

import com.opencsv.bean.CsvBindByName;

public class Sentence {

    @CsvBindByName
    private String sentence;
    @CsvBindByName
    private int id;


    public Sentence(int id, String sentence) {
        this.id = id;
        this.sentence = sentence;
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
