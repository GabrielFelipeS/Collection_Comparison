package com.br.collectioncomparison.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindClassesByInterface<T> {
	private String packageName;
	private String interfaceName;

	public FindClassesByInterface(String packageName, String interfaceName) {
		this.packageName = packageName;
		this.interfaceName = interfaceName;
	}

	public FindClassesByInterface(Class<? extends T> packageClass, Class<? extends T> interfaceClass) {
		this.packageName = packageClass.getPackage().getName();
		this.interfaceName = interfaceClass.getName();
	}

	public FindClassesByInterface(Class<? extends T> packageClass, String interfaceName) {
		this(packageClass.getPackage().getName() ,interfaceName);
	}
	
	public FindClassesByInterface(String packageName, Class<? extends T> interfaceClass) {
		this(packageName, interfaceClass.getName());
	}
	
	public void test() {
		System.out.println("Package: " + packageName);
		System.out.println("Interface: " + interfaceName);
	}
	
	
	public List<T> find() {
		String classDirectory = getClassDirectory(packageName);
		return  instantiateClassesImplementingInterface(classDirectory, packageName, interfaceName);
	}
	
	private String getClassDirectory(String packageName) {
		try {
			String packagePath = packageName.replace('.', '/');
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

			URL resource = classLoader.getResource(packagePath);
			if (resource != null) {
				URI uri = resource.toURI();
				return new File(uri).getAbsolutePath();
				
			} else {
				throw new RuntimeException("Failed to determine class directory.");
			}
		} catch(URISyntaxException e) {
			throw new RuntimeException("Failed convert to URI");
		}
	}

	private List<T> instantiateClassesImplementingInterface(String classDirectory, String packageName,
			String interfaceName) {
		List<T> instances = new ArrayList<>();

		try {
			System.out.println(classDirectory);
			List<Class<?>> classes = getClassesInPackage(classDirectory, packageName);

			for (Class<?> clazz : classes) {
				if (implementsInterface(clazz, interfaceName)) {
					instances.add(instantiateClass(clazz));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instances;
	}

	private List<Class<?>> getClassesInPackage(String classDirectory, String packageName)
			throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<>();

		File packageDirectory = new File(classDirectory);
		File[] files = packageDirectory.listFiles();

		if (files != null) {
			for (File file : files) {
				String fileName = file.getName();
				if (fileName.endsWith(".class")) {
					// System.err.println(fileName.substring(0, fileName.length() - 6));
					String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
					classes.add(Class.forName(className));
				}
			}
		}

		return classes;
	}

	private boolean implementsInterface(Class<?> clazz, String interfaceName) {
		try {
			return Class.forName(interfaceName).isAssignableFrom(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	private T instantiateClass(Class<?> clazz) throws Exception {
		return (T) clazz.getConstructor().newInstance();
	}
}
