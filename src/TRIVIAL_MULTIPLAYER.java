import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TRIVIAL_MULTIPLAYER {

    private static final int MAX_POINTS = 20;
    private static final String GEOGRAPHY = "geografia";
    private static final String SPORTS = "deportes";
    private static final String MOVIES = "cine";
    private static final String SERIES = "series";

    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;



    public static void main(String[] args) {

        List<Question> mixedQuestions = buildQuestionList();
        String namePlayer1 = askUserForName();

        player1 = new Player(namePlayer1);
        String namePlayer2 = askUserForName();
        player2 = new Player(namePlayer2);

        currentPlayer = player1;
        System.out.println("Empieza el jugador " + currentPlayer.getName());



        while (mixedQuestions.size() > 0 && currentPlayer.getPlayerScore() < MAX_POINTS) {

            System.out.println("Te toca jugador " + currentPlayer.getName());
            String topicChoosen = askTheUserWichTopic();
            Question questionByTopic = selectQuestionByTopic(mixedQuestions, topicChoosen);

            if ( questionByTopic != null) {
                playWithQuestion(questionByTopic);
            }
            else {
                System.out.println("Ya no quedan preguntas de esa temática, por favor selecciona otra.  ");
            }

            switchPlayer();

        }

        printResult();
    }

    private static void printResult() {
        System.out.println("Tu puntuación final es: " + player1.getPlayerScore() + "Jugador" + player1.getName());
        System.out.println("Tu puntuación final es: " + player2.getPlayerScore() + "Jugador" + player2.getName());

    }

    private static void switchPlayer() {
        if (currentPlayer == player1){
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1 ;
        }
    }

    private static String askUserForName() {
        System.out.println("Choose a name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return name;
    }

    private static void playWithQuestion(Question question) {
        System.out.println(question.getStatement());

        System.out.println("Es verdadero o falso? T/F");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.nextLine();

        boolean userChoice = userAnswer.equalsIgnoreCase("T");

        if (userChoice == question.isTrueOrFalse()) {
            int playerscore = currentPlayer.getPlayerScore() + question.getScores();
            currentPlayer.setPlayerScore(playerscore);

            System.out.println("Correct answer !!!");
        }else System.out.println("Incorrect answer :( ");
    }

    private static Question selectQuestionByTopic(List<Question> mixedQuestions, String topicChoosen) {
        Question oneQuestion = null;
        for (int i = 0; i < mixedQuestions.size(); i++) {
            Question currentQuestion = mixedQuestions.get(i);
            if (currentQuestion.getTheme().equals(topicChoosen)) {
                oneQuestion = currentQuestion;
                mixedQuestions.remove(i);
            }
        }
        return oneQuestion;
    }

    private static String askTheUserWichTopic() {

        System.out.println("Elige qué categoria de preguntas quieres responder: ");
        System.out.println(" 1. Geografía / 2. Deportes / 3. Cine / 4. Series ");
        Scanner sc = new Scanner(System.in);
        int topicChoosed = sc.nextInt();
        if (topicChoosed == 1) return GEOGRAPHY;
        else if (topicChoosed == 2) return SPORTS;
        else if (topicChoosed == 3) return MOVIES;
        else if (topicChoosed == 4) return SERIES;
        return null;
    }

    private static List<Question> buildQuestionList() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("La capital de Francia es Paris?", true, 3, GEOGRAPHY));
        questions.add(new Question("La capital de Francia es Paris", true, 3, GEOGRAPHY));
        questions.add(new Question("La capital de Francia es Paris", true, 3, GEOGRAPHY));
        questions.add(new Question("La capital de Francia es Paris", true, 3, GEOGRAPHY));
        questions.add(new Question("La capital de Francia es Paris", true, 3, GEOGRAPHY));

        questions.add(new Question("El Barça viste de blaugrana?", true, 2, SPORTS));
        questions.add(new Question("El Barça viste de blaugrana", true, 2, SPORTS));
        questions.add(new Question("El Barça viste de blaugrana", true, 2, SPORTS));
        questions.add(new Question("El Barça viste de blaugrana", true, 2, SPORTS));
        questions.add(new Question("El Barça viste de blaugrana", true, 2, SPORTS));

        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, MOVIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, MOVIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, MOVIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, MOVIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, MOVIES));

        questions.add(new Question("Steve carrel es el protagonista de The office?", true, 4, SERIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 3, SERIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 4, SERIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, SERIES));
        questions.add(new Question("Titanic va sobre un barco que se hunde?", true, 2, SERIES));

        return questions;

    }


}
