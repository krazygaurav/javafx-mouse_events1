
//David Mejicano Gormley
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GardenLayout extends Application {
	// EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>();
	final List<Node> children = new ArrayList<>();
	Pane myPane;
	Scene scene;
	Flower flower;
	FlowerBed flowerBed;
	AnchorPane root;
	Point2D lastPosition;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new AnchorPane();
		scene = new Scene(root, 800, 800);
		scene.setFill(Color.YELLOWGREEN);

		flower = new Flower(new Point2D(70, 90), Color.RED, true);
		root.getChildren().add(flower.getCircle());
		flower.getCircle().setOnMouseDragged(mouseHandler);
		flower.getCircle().setOnMousePressed(mouseHandler);

		flowerBed = new FlowerBed(new Point2D(401, 540));
		root.getChildren().add(flowerBed.getRectangle());
		flowerBed.getRectangle().setOnMouseDragged(mouseHandler);
		flowerBed.getRectangle().setOnMousePressed(mouseHandler);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
		// @Override
		public void handle(MouseEvent mouseEvent) {
			Point2D clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
			System.out.println(clickPoint.getX() + " " + clickPoint.getY());
			String eventName = mouseEvent.getEventType().getName();

			switch (eventName) {
				case ("MOUSE_DRAGGED"):
					if (lastPosition != null) {
						double delataX = clickPoint.getX() - lastPosition.getX();
						double delataY = clickPoint.getY() - lastPosition.getY();
						if (mouseEvent.getSource() == flower.getCircle()) {
							flower.move(delataX, delataY);
						} else if (mouseEvent.getSource() == flowerBed.getRectangle()) {
							if(flowerBed.containsPoint(new Point2D(flower.getCircle().getCenterX(), flower.getCircle().getCenterY()))){
								flower.move(delataX, delataY);
							}
							flowerBed.move(delataX, delataY);
						}
					}
					break;
				case ("MOUSE_PRESSED"):
					lastPosition = null;
					if (mouseEvent.getSource() == flower.getCircle()) {
						flower.getCircle().toFront();
						flowerBed.getRectangle().toBack();
					}
					break;
			}
			lastPosition = clickPoint;
		}
	};

}

// composite node has a list to delegate the children
// but the flower has to move itself
/*
 * Flower FlowerBed GardenComponent <- interface GardenLayout
 */
