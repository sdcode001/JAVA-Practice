package com.sd.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo {

	private static void fileMethodsDemo() {
		File f = new File("D:\\JAVA_Workshop\\project1\\src\\com\\sd\\java\\io\\image.jpeg");

		System.out.println("getAbsolutePath(): " + f.getAbsolutePath());
		try {
			System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
			System.out.println("createNewFile(): " + f.createNewFile());
		} catch (IOException e) {}	
		
		System.out.println("separator: " + f.separator);
		System.out.println("separatorChar: " + f.separatorChar);
		System.out.println("getParent(): " + f.getParent());
		System.out.println("lastModified(): " + f.lastModified());
		System.out.println("exists(): " + f.exists());
		System.out.println("isFile(): " + f.isFile());
		System.out.println("isDirectory(): " + f.isDirectory());
		System.out.println("length(): " + f.length());  //file size in bytes

		System.out.println("My working or user directory: " + System.getProperty("user.dir"));
		System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());
		System.out.println("new File(\"testdir\\test\").mkdir(): " + new File("testdir\\test").mkdir()); //create directory
		//delete will not work if directory is not empty and return false
		System.out.println("new File(\"testdir\").delete(): " + new File("testdir").delete());
		//creating nested directories recursively
		System.out.println("new File(\"testdir\\test1\\test2\").mkdirs(): " + new File("testdir\\test1\\test2").mkdirs());

		try {
			File f2 = new File("temp.txt");
			File f3 = new File("temp1.txt");
			System.out.println("f2.createNewFile(): " + f2.createNewFile()); //create new file
			System.out.println("f3.createNewFile(): " + f3.createNewFile());
			System.out.println("f2.renameTo(...): " + f2.renameTo(new File("temp2.txt")));  //rename !!
			System.out.println("f3.renameTo(...): " + f3.renameTo(new File("testdir\\temp1.txt")));  //move !!
		} catch (IOException e) {}

	}

	public static void dirFilter(boolean applyFilter) {
		System.out.println("\nInside dirFilter ...");

		File path = new File("."); //current working directory-> project1
		String[] list;

		if(!applyFilter)
			//gives names of all immediate directories and files
			list = path.list();
		else
			list = path.list(new DirFilter());

		for(String dirItem : list)
			System.out.println(dirItem);
	}

	public static void main(String[] args) {
		fileMethodsDemo();
		dirFilter(false);
	}

}

class DirFilter implements FilenameFilter {
	// Holds filtering criteria
	public boolean accept(File file, String name) {
		return name.endsWith(".jpg") || name.endsWith(".JPG");
	}
}
