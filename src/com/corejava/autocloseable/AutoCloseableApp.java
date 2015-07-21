package com.corejava.autocloseable;

public class AutoCloseableApp {

	public static void main(String[] args) {
		try (Lion lion = new Lion(); Tiger tiger = new Tiger()) {
			lion.hunt();
			tiger.hunt();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("here, No Need of Finally block, as close() method has been called in a STACK order - LIFO");
		}
	}

}

class Lion implements AutoCloseable {
	public Lion() {
		System.out.println("LION is OPEN in the wild.");
	};

	public void hunt() throws Exception {
		//throw new LionException("DeerNotFound says Lion!");
	}

	public void close() throws Exception {
		System.out.println("LION is CLOSED in the cage.");
		throw new LionException("Unable to close the LION cage!");
	}
}

class Tiger implements AutoCloseable {
	public Tiger() {
		System.out.println("TIGER is OPEN in the wild.");
	};

	public void hunt() throws Exception {
		//throw new TigerException("DeerNotFound says Tiger!");
	}

	public void close() throws Exception {
		System.out.println("TIGER is INSIDE the cage.");
		throw new LionException("Unable to close the TIGER cage!");
	}
}