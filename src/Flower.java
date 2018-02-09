
//David Mejicano Gormley

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements GardenComponent {
	Flower flowerObject;
	boolean moveable = false;
	Circle circle;
	Color colorOfFlower;
	Point2D position;
	Flower flower;

	public Flower(Point2D point2d, Color colorOfFlower, boolean moveable) {
		this.colorOfFlower = colorOfFlower.RED;
		this.position = point2d;
		this.moveable = moveable;
		circle = new Circle();
		circle.setCenterX(point2d.getX());
		circle.setCenterY(point2d.getY());
		circle.setRadius(30);
		circle.setFill(colorOfFlower.RED);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);
	}
	
	private void produceRainbow() {
		Color color = Color.RED;
	}

	public Circle getCircle() {
		return this.circle;
	}

	@Override
	public void move(double dx, double dy) {
		circle.setCenterY(circle.getCenterY() + dy);
		circle.setCenterX(circle.getCenterX() + dx);
	}

	@Override
	public boolean containsPoint(Point2D clickPoint) {
		//No Use
		return false;
	}

}
