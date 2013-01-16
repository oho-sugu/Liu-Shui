// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class PutImageAlign extends in2out1 {
	private int width,height;
	private int widthSrc,heightSrc;
	private int putx,puty;
	private String HAlign = new String(),VAlign = new String();
	
	public PutImageAlign(){
		super();
		name = "Put Image by Align";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		// 0 Dist 1 Src 
		//
		//    Src
		//   ======
		//    Dist
		//
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);

		widthSrc = input[1].getWidth(0);
		heightSrc = input[1].getWidth(1);
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue(input[0].getValueI(x,y,0),x,y,0);
				output[0].setValue(input[0].getValueI(x,y,1),x,y,1);
				output[0].setValue(input[0].getValueI(x,y,2),x,y,2);
			}
		}
		
		if(HAlign.equals("R")){
			putx = 0;
		} else if(HAlign.equals("C")){
			putx = (width/2) - (widthSrc/2);
		} else if(HAlign.equals("L")){
			putx = width - widthSrc;
		} else {
			putx = 0;
		}

		if(VAlign.equals("T")){
			puty = 0;
		} else if(VAlign.equals("C")){
			puty = (height/2) - (heightSrc/2);
		} else if(VAlign.equals("B")){
			puty = height - heightSrc;
		} else {
			puty = 0;
		}
		


		for(int y = 0;y < heightSrc;y++){
			for(int x = 0;x < widthSrc;x++){
				if((putx+x >= 0) && (width > putx+x) && (puty+y >= 0) && (height > puty+y)){
					output[0].setValue(input[1].getValueI(x,y,0),putx+x,puty+y,0);
					output[0].setValue(input[1].getValueI(x,y,1),putx+x,puty+y,1);
					output[0].setValue(input[1].getValueI(x,y,2),putx+x,puty+y,2);
				}
			}
		}
	}

	public void setParameter(){
		String str[] = new String[1];
		str[0] = "";
		System.out.println("Input HAlign VAlign");
		System.out.print("HAlign [R C L]>");
		comInput(str);
		HAlign = str[0];
		System.out.print("VAlign [T C B]>");
		str[0] = "";
		comInput(str);
		VAlign = str[0];
	}
}
