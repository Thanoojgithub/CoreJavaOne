package com.corejava.dp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonDPApp implements Cloneable {

	public static void main(String[] args) {
		SingletonIns.getInstance().showMe();
	}
}

class SingletonIns {

	final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	// Declare a SingletonIns type class variable with 'static' scope
	private static SingletonIns instance = null;

	/**
	 * Declare constructor with 'private' access specifier, to avoid instantiation from outside of class SingletonIns
	 */
	private SingletonIns() {
	}

	/**
	 * Use factory method to instantiate and return object NOTE : if it is
	 * required to pass an input parameter value, while creating an instance, we
	 * can pass via factory method, here, getInstance()
	 */
	public static SingletonIns getInstance() {
		if (instance == null) {
			instance = new SingletonIns();
		}
		return instance;
	}

	public void showMe() {
		LOGGER.log(Level.INFO, "SingletonIns - SingletonIns.showMe()");
	}

	/**
	 * In order to restrict cloning, need to implement clone() and throw CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
