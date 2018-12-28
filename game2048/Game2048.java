/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

/**
 *
 * @author Konstantin
 * @version 1.1
 */
public class Game2048 extends Application {

    private Board board;
    private ImageView[][] squareImages;

    private boolean gameReady;

    @Override
    public void start(Stage primaryStage) {
        Board board = new Board();
        this.board = board;
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 200, 200);
        gameReady = true;

        ImageView numbers[][] = new ImageView[4][4];
        squareImages = numbers;
        Image zero = new Image("/game2048/images/Zero.png");
        Image two = new Image("/game2048/images/Two.png");
        Image four = new Image("/game2048/images/Four.png");
        Image eight = new Image("/game2048/images/eight.jpg");
        Image sixteen = new Image("/game2048/images/sixteen.jpg");
        Image thirtyTwo = new Image("/game2048/images/thirtytwo.jpg");
        Image sixtyFour = new Image("/game2048/images/sixtyfour.jpg");
        Image oneTwentyEight = new Image("/game2048/images/onetwentyeight.jpg");
        Image twoFiftySix = new Image("/game2048/images/twofiftysix.jpg");
        Image fiveTwelve = new Image("/game2048/images/fivetwelve.jpg");
        Image tenTwentyFour = new Image("/game2048/images/tentwentyfour.jpg");
        Image twentyFourtyEight = new Image("/game2048/images/twentyfourtyeight.jpg");
        Image fourtyNintySix = new Image("/game2048/images/fourtynintysix.jpg");
        Image eightyOneNintyTwo = new Image("/game2048/images/eightyonenintytwo.jpg");
        Image oneSixtyThreeEightyFour = new Image("/game2048/images/onesixtythreeeightyfour.jpg");
        Image threeTwentySevenSixtyEight = new Image("/game2048/images/threetwentysevensixtyeight.jpg");
        Image startImage = new Image("/game2048/images/playunclickedv2.jpg");
        Image startImageHovered = new Image("/game2048/images/playclickedv2.jpg");
        ImageView titlemessage = new ImageView(new Image("/game2048/images/logo.jpg"));
        ImageView Instructions = new ImageView(new Image("/game2048/images/Instructions.jpg"));

        VBox rootTitle = new VBox();
        rootTitle.setSpacing(10);
        Scene title = new Scene(rootTitle, 200, 200);
        rootTitle.setBackground(new Background(new BackgroundImage(new Image("/game2048/images/background.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        root.setBackground(new Background(new BackgroundImage(new Image("/game2048/images/gameBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        ImageView start = new ImageView(startImage);
        rootTitle.getChildren().add(0, titlemessage);
        rootTitle.getChildren().add(1, start);
        rootTitle.getChildren().add(2, Instructions);

        rootTitle.setAlignment(Pos.CENTER);

        start.setOnMouseEntered(event -> {
            start.setImage(startImageHovered);
        });
        start.setOnMouseExited(event -> {
            start.setImage(startImage);
        });

        start.setOnMouseClicked(event -> {
            primaryStage.setScene(scene);
        });

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.getSquare(i, j).getValue() == 0) {
                    numbers[i][j] = new ImageView(zero);
                }
                if (board.getSquare(i, j).getValue() == 2) {
                    numbers[i][j] = new ImageView(two);
                }
                root.add(numbers[i][j], i, j);
            }
        }

        scene.setOnKeyPressed(
                event -> {
                    if (gameReady) {
                        switch (event.getCode()) {
                            case W:
                                board.moveUp();
                                break;
                            case S:
                                board.moveDown();
                                break;

                            case D:
                                board.moveRight();
                                break;

                            case A:
                                board.moveLeft();
                                break;
                        }
                        gameReady = false;
                    }

                    ImageView numbersCopy[][] = squareImages.clone();

                    this.squareMoveAnimation();

                    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

                    executorService.schedule(new Runnable() {
                        @Override
                        public void run() {

                            for (int i = 0; i < 4; i++) {
                                for (int j = 0; j < 4; j++) {
                                    switch (board.getSquare(i, j).getValue()) {
                                        case 0:
                                            numbers[i][j].setImage(zero);
                                            break;
                                        case 2:
                                            numbers[i][j].setImage(two);
                                            break;
                                        case 4:
                                            numbers[i][j].setImage(four);
                                            break;
                                        case 8:
                                            numbers[i][j].setImage(eight);
                                            break;
                                        case 16:
                                            numbers[i][j].setImage(sixteen);
                                            break;
                                        case 32:
                                            numbers[i][j].setImage(thirtyTwo);
                                            break;
                                        case 64:
                                            numbers[i][j].setImage(sixtyFour);
                                            break;
                                        case 128:
                                            numbers[i][j].setImage(oneTwentyEight);
                                            break;
                                        case 256:
                                            numbers[i][j].setImage(twoFiftySix);
                                            break;
                                        case 512:
                                            numbers[i][j].setImage(fiveTwelve);
                                            break;
                                        case 1024:
                                            numbers[i][j].setImage(tenTwentyFour);
                                            break;
                                        case 2048:
                                            numbers[i][j].setImage(twentyFourtyEight);
                                            break;
                                        case 4096:
                                            numbers[i][j].setImage(fourtyNintySix);
                                            break;
                                        case 8192:
                                            numbers[i][j].setImage(eightyOneNintyTwo);
                                            break;
                                        case 16384:
                                            numbers[i][j].setImage(oneSixtyThreeEightyFour);
                                            break;
                                        case 32768:
                                            numbers[i][j].setImage(threeTwentySevenSixtyEight);
                                            break;
                                    }
                                }
                            }
                            gameReady = true;
                        }
                    }, 300, TimeUnit.MILLISECONDS);
                }
        );
        primaryStage.setTitle("2048");
        primaryStage.setScene(title);
        primaryStage.show();
        primaryStage.setOnHidden(close -> {
            System.exit(0);
        });
    }

    private void squareMoveAnimation() {
        for (Square source : board.getPositionSwap().keySet()) {

            int sourceXPosition = source.getColumnNumber();
            int sourceYPosition = source.getRowNumber();
            Square destination = board.getPositionSwap().get(source);
            int destXPosition = destination.getColumnNumber();
            int destYPosition = destination.getRowNumber();
            this.squareImages[destXPosition][destYPosition].toFront();
            ImageView destImage = this.squareImages[destXPosition][destYPosition];

            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.millis(298));
            transition.setNode(squareImages[sourceXPosition][sourceYPosition]);
            TranslateTransition reverseTranslation = new TranslateTransition();
            reverseTranslation.setDuration(Duration.millis(0.5));
            reverseTranslation.setNode(squareImages[sourceXPosition][sourceYPosition]);

            if ((int) squareImages[sourceXPosition][sourceYPosition].getLayoutX() - (int) destImage.getLayoutX() != 0) {
                double xTransition = destImage.getLayoutX() - squareImages[sourceXPosition][sourceYPosition].getLayoutX();
                transition.setToX(xTransition);
                reverseTranslation.setToX(0);
            } else {
                double yTransition = destImage.getLayoutY() - squareImages[sourceXPosition][sourceYPosition].getLayoutY();
                transition.setToY(yTransition);
                reverseTranslation.setToY(0);
            }
            SequentialTransition st = new SequentialTransition(squareImages[sourceXPosition][sourceYPosition], transition, reverseTranslation);
            st.play();

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
