package com.corejava.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApp {

	public static void main(String[] args) {
		classForName();
		methodsInvokeUsingReflection();
	}

	private static void methodsInvokeUsingReflection() {
		try {
			Class<?> cls = Class.forName("com.corejava.reflection.Sample");
			Object instance = cls.newInstance();
			// list of all methods in extends
			for (Method method : cls.getMethods()) {
				System.out.println(method);
			}
			// list of methods, are declared in class
			for (Method declaredMethod : cls.getDeclaredMethods()) {
				System.out.println("declaredMethod :: " + declaredMethod);
			}

			for (Annotation annotation : cls.getAnnotations()) {
				System.out.println("annotation :: " + annotation);
			}

			for (Field field : cls.getFields()) {
				System.out.println("field :: " + field.getName());
			}
			for (Field field : cls.getDeclaredFields()) {
				System.out.println("declaredField :: " + field.getName());
			}
			Method declaredMethod = cls.getDeclaredMethod("messageString", new Class[] { String.class });
			declaredMethod.invoke(instance, "Simple.messageString()");
			declaredMethod = cls.getDeclaredMethod("messageInteger", new Class[] { Integer.class });
			declaredMethod.invoke(instance, 100);
			declaredMethod = cls.getDeclaredMethod("messageInt", new Class[] { Integer.TYPE });
			declaredMethod.invoke(instance, 1);
			declaredMethod = cls.getDeclaredMethod("messageNoParam", new Class[] {});
			declaredMethod.invoke(instance);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	private static void classForName() {
		try {
			Class<?> c = Class.forName("com.corejava.reflection.Sample");
			Sample s = (Sample) c.newInstance();
			s.messageString("Simple.messageString()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}