package com.corejava.dp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonDPApp implements Cloneable {
	
	final static Logger LOGGER = Logger.getLogger(SingletonDPApp.class.getName());

	public static void main(String[] args) {
		SingletonIns.getInstance().showMe();
		SingletonIns.getInstance().showMe();
		LOGGER.log(Level.INFO, SingletonInsEnum.INSTANCE.go());
		LOGGER.log(Level.INFO, SingletonInsEnum.INSTANCE.go());
	}
}


/**
 * use EasySingleton.INSTANCE instead getInstance() method call on Singleton.
 */
enum SingletonInsEnum {
	INSTANCE;
	
	 public String go(){
		return "SingletonInsEnum.go()";
	 }
	
}

class SingletonIns {

	final static Logger LOGGER = Logger.getLogger(SingletonIns.class.getName());

	// Declare a SingletonIns type class variable with 'static' scope
	//volatile keyword helps as concurrency control tool in a multiple threaded environment and provides the latest update in a most accurate manner
	private /*volatile*/ static SingletonIns instance;

	/**
	 * Declare constructor with 'private' access specifier, to avoid instantiation from outside of class SingletonIns
	 */
	private SingletonIns() {
	}

	/**
	 * Use factory method to instantiate and return object NOTE : if it is
	 * required to pass an input parameter value, while creating an instance, we
	 * can pass via factory method, here, getInstance()
	 * 
	 * it’s a thread-safe -  when you point out that this code will create multiple instances of Singleton class if called by more than one thread parallel.
	 */
	public static SingletonIns getInstance() {
		if (null == instance) {
				synchronized (SingletonIns.class){
					if (null == instance) {
						instance = new SingletonIns();
					}
			}
		}
		LOGGER.log(Level.INFO, "SingletonIns - SingletonIns.getInstance() :: hashcode :: "  + instance.hashCode());
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

/*
 * NOTE : Cloneable Preferred way is to not to implement Cloneable interface since why do we need another copy of singleton object.
 */
