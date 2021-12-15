package in.icomputercoding.computercoding.Quiz;

public class QuestionData {
    String oA,oB,oC,oD,ans,question;

    public QuestionData(){

    }

    public QuestionData(String oA, String oB, String oC, String oD, String ans, String question) {
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.oD = oD;
        this.ans = ans;
        this.question = question;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public String getoD() {
        return oD;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
