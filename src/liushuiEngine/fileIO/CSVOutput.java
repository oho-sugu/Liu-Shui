// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class CSV File Output Class
//
// This Class is Data Output Class to CSV File
// Write Input Array Data to File

package liushuiEngine.fileIO;

import java.io.*;

import liushuiEngine.basicNode.Terminator;

public class CSVOutput extends Terminator {
	File fp;
	PrintWriter out;
	int fileLength;
	private static final int CR = 0x0D;
	private static final int LF = 0x0A;

	public CSVOutput(){
		super();
		name = "CSVOutput Class";
		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}
	
	public void Process(){
		out.println(Integer.toString(input[0].getWidth(0))+","+Integer.toString(input[0].getWidth(1)));
		for(int j = 0;j < input[0].getWidth(1);j++){
			String oneLine = "";
			for(int i = 0;i < input[0].getWidth(0);i++){
				oneLine = oneLine + Double.toString(input[0].getValueD(i,j));
				if(i < input[0].getWidth(0) - 1){
					oneLine = oneLine + ",";
				} else {
					//oneLine = oneLine;
				}
			}
			out.println(oneLine);
		}
		out.flush();
		out.close();
	}

	public void setParameter(){
		System.out.println("Input Output File Name");
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
			out = new PrintWriter(new BufferedWriter((new FileWriter(fp))));
		} catch(IOException e){}
	}
}
