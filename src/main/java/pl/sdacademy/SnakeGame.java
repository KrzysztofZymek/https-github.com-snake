package pl.sdacademy;

import java.util.Random;

public class SnakeGame {

    private int xBound;
    private int yBound;
    private Snake snake;
    private Point apple;
    private int points;

    public SnakeGame(int xBound, int yBound, Snake snake) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.snake = snake;
    }

    public SnakeGame(Snake snake, int yBound, int i) {
    }

    public void start(){
        points=0;
        randomizeApple();
        while (isSnakeBounds()){
            System.out.println(this);
            snake.expand();
            if(apple.equals(snake.getHead())) {
                points++;
                randomizeApple();
            }else{
                snake.cutTail();
            }

        }
    }

    private boolean isSnakeBounds() {
        Point head = snake.getHead();
        int headX = head.getX();
        int headY = head.getY();

        ////////tu kod do dopisania
        return headX >= 0&&headX < xBound &&
         headY >= 0 && headY < yBound;

    }
    private void randomizeApple(){
        Random random = new Random();
        do{
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX,appleY);
        }while (snake.contains(apple));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
        for (int x = 0; x < xBound; x++) {
            Point point = new Point(x,y);
            if (point.equals((apple))) {
                stringBuilder.append('A');
            } else if (point.equals(snake.getHead())) {
                stringBuilder.append('H');
            }else if (snake.getBody().contains(point)) {
            }else {
                    stringBuilder.append(' ');
                }
            }
        stringBuilder.append('\n');
        }
        return stringBuilder.toString();
        }
}





