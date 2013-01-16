// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class BinaryImageDifferenceFilter extends in2out1 {
	private int width,height;
	
	public BinaryImageDifferenceFilter(){
		super();
		name = "Binary Image Difference Filter Class for graduation thesis";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 2;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);

		output[0] = new ArrayInt(width,height);

		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue(Math.abs(input[0].getValueI(x,y)-input[1].getValueI(x,y)),x,y);
			}
		}
	}

	public void setParameter(){
	}
}
