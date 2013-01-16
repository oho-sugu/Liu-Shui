// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB Inverse Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class RGBInvFilter extends Filter {
	private int width,height;
	
	public RGBInvFilter(){
		super();
		name = "RGB Inverse Filter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
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
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue(255 - input[0].getValueI(x,y,0),x,y,0);
				output[0].setValue(255 - input[0].getValueI(x,y,1),x,y,1);
				output[0].setValue(255 - input[0].getValueI(x,y,2),x,y,2);
			}
		}
	}

	public void setParameter(){}
}
