// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class File Output Class
//
// This Class is Data Output Class to File
// Write Input Array Data to File

package liushuiEngine.fileIO;

import java.io.*;

import liushuiEngine.Array;
import liushuiEngine.basicNode.Terminator;

public class FileOutput extends Terminator {
	File fp;
	BufferedOutputStream out;
	int fileLength;

	public FileOutput(){
		super();
		name = "FileOutput Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 1) input[0] = a;
	}
	public void Process(){
		for(int i = 0;i < input[0].getWidth(0);i++){
			try{
				out.write(input[0].getValueI(i));
			} catch(IOException e){}
		}
		try{
			out.flush();
		} catch(IOException e){}
		try{
			out.close();
		} catch(IOException e){}
	}

	public Array getOutput(int i){ return null;}
	public void setParameter(){
		System.out.println("Input File Name");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		try{
			fp = new File(str[0]);
		} catch(NullPointerException e){}
		try{
			fp.createNewFile();
		} catch(IOException e){}
		try{
			out = new BufferedOutputStream(new FileOutputStream(fp));
		} catch(FileNotFoundException e){}
	}
}
