package com.free.FileIO;
import  java.io.File;

public class FileIO {
	public static void main(String args[]){
		File f = new File("G:\\code\\java_workspace");
		printFile(f,0);
	}

	static void  printFile(File file,int level){
		for(int i = 0; i < level; i++){
			System.out.print("|"+i+"|");
		}
		
		System.out.println(file.getName());
		
		if(file.isDirectory()){
			File [] files = file.listFiles();
			for(File temp:files){
				printFile(temp,level+1);
			}
		}
		
		
	}
		
	
}
