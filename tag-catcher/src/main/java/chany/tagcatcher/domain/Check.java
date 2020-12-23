package chany.tagcatcher.domain;

public class Check {
    private String sentence;
    private boolean inspectResult;

    public Check(String sentence, boolean inspectResult) {
        this.sentence = sentence;
        this.inspectResult = inspectResult;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public boolean getInspectResult() {
        return inspectResult;
    }

    public void setInspectResult(boolean inspectResult) {
        //TODO : InspectTag 완성되면 setter에 InspectTag 결과로 set
        // this.inspectResult = utils.InsepctTag.check(sentence)
        this.inspectResult = inspectResult;
    }


}
