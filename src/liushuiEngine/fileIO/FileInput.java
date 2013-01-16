// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class CSV Input Class
//
// This Class is Data Input(Generate) Class from File
//
// Set Byte Data to Output Array

package liushuiEngine.fileIO;

import java.io.*;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Generator;

public class FileInput extends Generator {
	File fp;
	BufferedInputStream inp;
	int fileLength;

	public FileInput(){
		super();
		name = "FileInput Class";
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){}
	
	public void Process(){
		for(int i = 0;i < fileLength;i++){
			try{
				output[0].setValue(inp.read(),i);
			} catch(IOException e){}
		}
		try{
			inp.close();
		} catch(IOException e){}
	}

	public Array getOutput(int i){
		if(i < 1) return output[0];
		return null;
	}

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
		inp = new BufferedInputStream(new FileInputStream(fp));
		} catch(FileNotFoundException e){}
		try{
			fileLength = new Long(fp.length()).intValue();
		} catch(SecurityException e){}
		
		output[0] = new ArrayInt(fileLength);
	}
}
