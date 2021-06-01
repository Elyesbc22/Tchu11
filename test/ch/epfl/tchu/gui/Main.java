package ch.epfl.tchu.gui;

import ch.epfl.tchu.game.ChMap;
import ch.epfl.tchu.game.Route;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        BorderPane view = new BorderPane();
        Pane mapView = new Pane();
        ImageView imageView = new ImageView();
        mapView.getStylesheets().add("map.css");
        mapView.getStylesheets().add("colors.css");
        mapView.getChildren().add(imageView);

        ChMap.routes().forEach(r -> mapView.getChildren().add(createGroup(r)));

        view.setCenter(mapView);
//        view.setRight(DecksViewCreator.createCardsView());
//        view.setBottom(DecksViewCreator.createHandView());
        Scene scene = new Scene(view);

        stage.setScene(scene);
        stage.show();
    }

    public static Group createGroup(Route route) {
        Group routeGroup = new Group();

        routeGroup.setId(route.id());

        routeGroup.getStyleClass().add("route");
        routeGroup.getStyleClass().add(route.level().name());
        routeGroup.getStyleClass().add(route.color() == null ? "NEUTRAL" : route.color().name());

        for (int i = 0; i < route.length(); ++i) {
            Group routeCell = new Group();

            routeCell.setId(String.format("%s_%s", route.id(), i+1));

            Rectangle trackGroup = new Rectangle(36, 12);
            trackGroup.getStyleClass().add("track");
            trackGroup.getStyleClass().add("filled");

            Group carGroup = new Group();

            Rectangle rectangleGroup = new Rectangle(36, 12);
            rectangleGroup.getStyleClass().add("filled");

            carGroup.getChildren().add(rectangleGroup);
            carGroup.getChildren().add(new Circle());
            carGroup.getChildren().add(new Circle());
            carGroup.getStyleClass().add("car");

            routeCell.getChildren().add(carGroup);
            routeCell.getChildren() .add(trackGroup);
            routeGroup.getChildren().add(routeCell);
        }

        return routeGroup;
    }
}
