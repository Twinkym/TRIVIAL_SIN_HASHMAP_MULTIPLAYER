public class Question {
    private String statement;
    private boolean trueOrFalse;
    private int scores;
    private boolean userAnswer;
    private String theme;

    public Question(String statement, boolean trueOrFalse, int scores, String theme) {
        this.statement = statement;
        this.trueOrFalse = trueOrFalse;
        this.scores = scores;
        this.theme = theme;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }



    public int getScores() {
        return scores;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getTheme() {
        return theme;
    }

    public String getStatement() {
        return statement;
    }
}
