package com.br.collectioncomparison.application;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class Test2 {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));

		String packageName = "com.br.collectioncomparison.model.entities";

		// Obtém o diretório de classes durante a execução
		String classDirectory = getClassDirectory(packageName);

		String interfaceName = "com.br.collectioncomparison.model.interfaces.CollectionTest";
		System.out.println(CollectionTest.class.getName());
		System.out.println(CollectionTest.class.getPackage().getName());

		List<Object> instances = instantiateClassesImplementingInterface(classDirectory, packageName, interfaceName);

		for (Object instance : instances) {
			System.out.println( ((CollectionTest) instance).getMilliseconds() );
		}
	}

	private static String getClassDirectory(String packageName) {
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

	private static List<Object> instantiateClassesImplementingInterface(String classDirectory, String packageName,
			String interfaceName) {
		List<Object> instances = new ArrayList<>();

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

	private static List<Class<?>> getClassesInPackage(String classDirectory, String packageName)
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

	private static boolean implementsInterface(Class<?> clazz, String interfaceName) {
		try {
			return Class.forName(interfaceName).isAssignableFrom(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static Object instantiateClass(Class<?> clazz) throws Exception {
		return clazz.getConstructor().newInstance();
	}
}
