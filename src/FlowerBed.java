import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//David Mejicano Gormley

public class FlowerBed implements GardenComponent{
	Point2D position;
	Rectangle rectangle;
	
	public FlowerBed(){
		rectangle = new Rectangle(130, 104, 100, 120);
		rectangle.setFill(Color.BROWN);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(1);
	}
	public FlowerBed(Point2D position) {
		this.position = position;
		rectangle = new Rectangle(position.getX(), position.getY(), 160, 220);
		rectangle.setFill(Color.BROWN);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(1);
	}
	
	public Point2D getPosition() {
		return position;
	}
	public void setPosition(Point2D position) {
		this.position = position;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	@Override
	public void move(double dx, double dy) {
		rectangle.setX(rectangle.getX() + dx);
		rectangle.setY(rectangle.getY() + dy);
	}

	@Override
	public boolean containsPoint(Point2D clickPoint) {
		if(this.getRectangle().contains(clickPoint))
			return true;
		return false;
	}

}
