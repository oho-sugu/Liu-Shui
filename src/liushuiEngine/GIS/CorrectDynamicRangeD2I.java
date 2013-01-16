// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.GIS;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class CorrectDynamicRangeD2I extends Filter {
	private int width,height;
	
	public CorrectDynamicRangeD2I(){
		super();
		name = "Correct Dynamic Range Double 2 Int";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
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
		
		double min = Double.MAX_VALUE,max = Double.MIN_VALUE;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				min = Math.min(input[0].getValueD(x,y),min);
				max = Math.max(input[0].getValueD(x,y),max);
			}
		}
		double multiple = 255.0/(max - min);
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue((int)((input[0].getValueD(x,y)-min)*multiple),x,y);
			}
		}
	}

	public void setParameter(){
	}
}
