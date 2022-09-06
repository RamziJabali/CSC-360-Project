# Introduction to JavaFx

The `start()` method is the main entry point for all JavaFX applications.

A JavaFX application defines the user interface container by means of a `stage` and a `scene`. The JavaFX `Stage` class is the top-level JavaFX container. The JavaFX `Scene` class is the container for all content.

You create a JavaFX `Stage` object just like any other Java object: Using the new command and the `Stage` constructor. Here is an example of creating a JavaFX Stage object.

```
Stage stage = new Stage();
stage.show();
```
## Set a Scene on a Stage

In order to display anything inside a JavaFX `Stage`, you must set a JavaFX `Scene` object on the `Stage`. The content of the `Scene` will then be displayed inside the `Stage` when the `Stage` is shown. Here is an example of setting a `Scene` on a JavaFX `Stage`:

Example:
```
VBox vBox = new VBox(new Label("A JavaFX Label"));
Scene scene = new Scene(vBox);

Stage stage = new Stage();
stage.setScene(scene);
```
## Stage Title
You can set the JavaFX `Stage` title via the `Stage setTitle()` method. The `Stage` title is displayed in the title bar of the `Stage` window. Here is an example of setting the title of a JavaFX `Stage`:

`stage.setTitle("JavaFX Stage Window Title");`

## Stage Position

You can set the position (X,Y) of a JavaFX `Stage` via its `setX()` and `setY()` methods. The `setX()` and `setY()` methods set the position of the upper left corner of the window represented by the `Stage`. Here is an example of setting the X and Y position of a JavaFX `Stage` object:
```
Stage stage = new Stage();

stage.setX(50);
stage.setY(50);
```
Please note, that it might be necessary to also set the width and height of the `Stage` if you set the X and Y position, or the `stage` window might become very small. 

## Stage Width and Height
You can set the width and of a JavaFX Stage via its `setWidth()` and `setHeight()` methods. Here is an example of setting the width and height of a JavaFX `Stage`:
```
Stage stage = new Stage();

stage.setWidth(600);
stage.setHeight(300);
```
