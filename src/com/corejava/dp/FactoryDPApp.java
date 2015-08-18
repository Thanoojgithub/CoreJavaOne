package com.corejava.dp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryDPApp {

	public static void main(String[] args) {

		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle type and call its implemented draw method.
		Shape shape1 = shapeFactory.getShape(Shap.CIRCLE.value);
		shape1.draw();

		// get an object of Rectangle type and call its implemented draw method.
		Shape shape2 = shapeFactory.getShape(Shap.RECTANGLE.value);
		shape2.draw();

		// get an object of Square type and call its implemented draw method.
		Shape shape3 = shapeFactory.getShape(Shap.SQUARE.value);
		shape3.draw();
	}

}

interface Shape {
	void draw();
}

class Circle implements Shape {

	final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@Override
	public void draw() {
		LOGGER.log(Level.INFO, "Circle implements Shape - Circle.draw()");
	}
}

class Rectangle implements Shape {

	final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@Override
	public void draw() {
		LOGGER.log(Level.INFO, "Rectangle implements Shape - Rectangle.draw()");
	}
}

class Square implements Shape {

	final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@Override
	public void draw() {
		LOGGER.log(Level.INFO, "Square implements Shape - Square.draw()");
	}
}

class ShapeFactory {

	// use getShape method to get object of specified shape type
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase(Shap.CIRCLE.value)) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase(Shap.RECTANGLE.value)) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase(Shap.SQUARE.value)) {
			return new Square();
		}

		return null;
	}
}

enum Shap {

	CIRCLE("CIRCLE"), RECTANGLE("RECTANGLE"), SQUARE("SQUARE");
	public final String value;

	private Shap(String value) {
		this.value = value;
	}
}