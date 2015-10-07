package com.corejava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationApp {

	public static void main(String[] args) {
		customTask();
		detaultTask();
		reflectionUsingAnnotation();
	}

	@ToDo(priority = ToDo.Priority.MEDIUM, status = ToDo.Status.STARTED)
	public static void customTask() {
		System.out.println("AnnotationApp.task()");
	}

	@ToDo
	public static void detaultTask() {
		System.out.println("AnnotationApp.detaultTask()");
	}

	private static void reflectionUsingAnnotation() {
		Class<AnnotationApp> annotationApp = AnnotationApp.class;
		for (Method method : annotationApp.getMethods()) {
			ToDo annotation = (ToDo) method.getAnnotation(ToDo.class);
			if (annotation != null) {
				System.out.println(" Method Name : " + method.getName() + " | Priority : " + annotation.priority()
						+ " | Status : " + annotation.status());
			}
		}
	}

	/**
	 * 
	 * @Target(ElementType.METHOD) 
	 * @Retention(RetentionPolicy.SOURCE)
	 * public @interface Override {
	 * }
	 * 
	 * Indicates that a method declaration is
	 * intended to override a method declaration in
	 * a supertype. If a method is annotated with
	 * this annotation type compilers are required
	 * to generate an error message unless at least
	 * one of the following conditions hold: 
	 * • The method does override or implement a method declared in a supertype. 
	 * • The method has a signature that is override-equivalent to Object class declaration
	 * 
	 */
	@Override
	public String toString() {
		return "AnnotationApp.toString()";
	}

}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface ToDo {
	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Status {
		NOT_STARTED, STARTED, IN_PROGRESS, FINISHED
	}

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;
}