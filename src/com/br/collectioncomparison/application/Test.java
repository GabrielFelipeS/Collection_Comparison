package com.br.collectioncomparison.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.br.collectioncomparison.model.interfaces.CollectionTest;

public class Test {
	public static void main(String[] args) {
		//String packageName = "com.br.collectioncomparison.model.entities";
		 String packageName = "C:\\Users\\Dell\\OneDrive\\Documentos\\faculdade\\Disciplinas\\4º Semestre\\Java\\Comparable_Collections\\bin\\com\\br\\collectioncomparison\\model\\entities";

		String interfaceName = "com.br.collectioncomparison.model.interfaces.CollectionTest";

		List<CollectionTest> instances = instantiateClassesImplementingInterface(packageName, interfaceName);
		System.out.println(instances.size());
        // Agora você tem instâncias das classes que implementam a interface
        for (CollectionTest instance : instances) {
            // Faça algo com as instâncias, por exemplo, chame um método
            // instance.metodo();
        	System.out.println(instance.getInstant());
        }
	}


	public static List<CollectionTest> instantiateClassesImplementingInterface(String packageName, String interfaceName) {
        List<CollectionTest> instances = new ArrayList<>();

        try {
            List<Class<?>> classes = getClassesInPackage(packageName);

            for (Class<?> clazz : classes) {
                if (implementsInterface(clazz, interfaceName)) {
                    instances.add((CollectionTest) instantiateClass(clazz));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instances;
    }

    private static List<Class<?>> getClassesInPackage(String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        String packagePath = packageName.replace('.', '/');

        System.out.println("Package Path: " + packagePath);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       // File packageDirectory = new File(classLoader.getResource(packagePath).getFile());
        File packageDirectory = new File(packageName);
        System.out.println(packageDirectory.getAbsolutePath());
        File[] files = packageDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
               
                
                System.out.println(fileName);
                if (fileName.endsWith(".class")) {
                    String className = "com.br.collectioncomparison.model.entities" + '.' + fileName.substring(0, fileName.length() - 6);
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
