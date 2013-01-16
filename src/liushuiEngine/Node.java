// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Parent Class

package liushuiEngine;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;


public class Node implements Serializable {
	protected String name = "Node Parent Class";
	
	protected Image iconImage = null;

	public static final int INT = 1;
	public static final int DOUBLE = 2;

	protected Array input[];
	protected Array output[];
	
	public int inputArrayType[];
	public int outputArrayType[];
	public int inputArrayDimension[];
	public int outputArrayDimension[];

	protected Node(){}

	public void Init(){}
	public void setInput(int i,Array a){}
	public void Process(){}
	public Array getOutput(int i){ return null;}
	public void setParameter(){}
	
	public Image getIconImage(){
		return this.iconImage;
	}

	protected void readIconImage(String file){
		try {
			iconImage = ImageIO.read(new File(file));
		} catch (Exception e) {
			//System.out.println("Error on Node Icon Reader");
			iconImage = null;
		}
	}
		
	
	public void comInput(String str[])
	{
		int i = 0,j = 0,k = 0;
		int loopFlag = 0;
		
		while(loopFlag == 0){
			int inpCode = 0;

			try{
				inpCode = System.in.read();
			} catch(IOException e){}
			
			if(inpCode == -1){
				loopFlag = 1;
			} else if(inpCode == 10){
				loopFlag = 1; // LF
			} else if(inpCode == 13){
			} else if(inpCode == 0x20){
				if(i < str.length - 1){
					++i;
				} else {
					loopFlag = 1;
				}
			} else {
				str[i] = str[i] + (char)inpCode;
			}
		}
	}
}
