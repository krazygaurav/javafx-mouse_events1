import javafx.geometry.Point2D;

//David Mejicano Gormley

public interface GardenComponent {
	public void move(double dx, double dy);
	public boolean containsPoint(Point2D clickPoint);
}
