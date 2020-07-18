package pl.sdacademy;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Point head;

    public Point getHead() {
        return head;
    }

    public List<Point> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    private List<Point> body;
    private Direction direction ;

    public Snake(Point head, List<Point> body, Direction direction) {
        this.head = head;
        this.body = new ArrayList<>(body);
        this.direction = direction;
    }




    @Override
    public String toString () {
        return "Snake{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }




    public void expand() {
        body.add(0,head);


        switch (direction) { //w zaleznosci od tego jaka jest wartosc w polu direction
            case UP:
                head = new Point(head.getX() , head.getY() -1);
                break;
            case DOWN:
                head = new Point(head.getX() , head.getY() +1);
                break;
            case RIGHT:
                head = new Point(head.getX()+1 , head.getY());
                break;
            case LEFT:
                head = new Point(head.getX()-1 , head.getY());
                break;
        }
    }

    public void cutTail() {
        body.remove(body.size()-1); //ta metoda odnosi sie do kolekcji( w tym wypadku listy)
    }


    public boolean contains(Point point) {
        return head.equals(point)|| body.contains(point);
    }
}





