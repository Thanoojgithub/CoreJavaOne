package com.corejava.comparatorcomparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class ComparatorComparable {
	
	private static final Logger LOG = Logger.getLogger("ComparatorComparable");

	public static void main(String[] args) {

		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineappale;
		fruits[1] = apple;
		fruits[2] = orange;
		fruits[3] = banana;

		LOG.info("+++++++++++++++++natural sorting, using comparable+++++++++++++++++++++++");
		// natural sorting, using comparable
		Arrays.sort(fruits);
		for (Fruit fruit : fruits) {
			LOG.info("fruit : "+fruit);
		}
		LOG.info("+++++++++++++++++natural sorting, using FruitNameComparator+++++++++++++++++++++++");
		Arrays.sort(fruits, Fruit.FruitNameComparator);
		for (Fruit fruit : fruits) {
			LOG.info("fruit : "+fruit);
		}
		LOG.info("+++++++++++++++++natural sorting, using FruitDescComparator+++++++++++++++++++++++");
		Arrays.sort(fruits, Fruit.FruitDescComparator);
		for (Fruit fruit : fruits) {
			LOG.info("fruit : "+fruit);
		}
		LOG.info("+++++++++++++++++natural sorting, using QuantityComparator+++++++++++++++++++++++");
		Arrays.sort(fruits, Fruit.QuantityComparator);
		for (Fruit fruit : fruits) {
			LOG.info("fruit : "+fruit);
		}
	}

}

class Fruit implements Comparable<Fruit> {

	private String fruitName;
	private String fruitDesc;
	private int quantity;

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDesc() {
		return fruitDesc;
	}

	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Fruit compareFruit) {
		if (this.fruitName.compareTo(compareFruit.getFruitName()) == 0) {
			if (this.fruitDesc.compareTo(compareFruit.getFruitDesc()) == 0) {
				return this.quantity - compareFruit.getQuantity();
			} else {
				return this.fruitDesc.compareTo(compareFruit.getFruitDesc());
			}
		} else {
			return this.fruitName.compareTo(compareFruit.getFruitName());
		}
	}

	public static Comparator<Fruit> FruitNameComparator = new Comparator<Fruit>() {
		public int compare(Fruit fruit1, Fruit fruit2) {
			String fruitName1 = fruit1.getFruitName().toUpperCase();
			String fruitName2 = fruit2.getFruitName().toUpperCase();
			// ascending order
			return fruitName1.compareTo(fruitName2);
			// descending order
			// return fruitName2.compareTo(fruitName1);
		}
	};

	public static Comparator<Fruit> FruitDescComparator = new Comparator<Fruit>() {
		public int compare(Fruit fruit1, Fruit fruit2) {
			String fruitDesc1 = fruit1.getFruitDesc().toUpperCase();
			String fruitDesc2 = fruit2.getFruitDesc().toUpperCase();
			// ascending order
			return fruitDesc1.compareTo(fruitDesc2);
			// descending order
			// return fruitDesc2.compareTo(fruitDesc1);
		}
	};

	public static Comparator<Fruit> QuantityComparator = new Comparator<Fruit>() {
		public int compare(Fruit fruit1, Fruit fruit2) {
			int quantity1 = fruit1.getQuantity();
			int quantity2 = fruit2.getQuantity();
			// ascending order
			return quantity1 - quantity2;
			// descending order
			// return quantity2 - quantity1;
		}
	};

	@Override
	public String toString() {
		return "Fruit [fruitName=" + fruitName + ", fruitDesc=" + fruitDesc
				+ ", quantity=" + quantity + "]";
	}
}
