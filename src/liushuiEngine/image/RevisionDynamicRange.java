// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class RevisionDynamicRange extends Filter {
	private int width,height;
	private int borderValue;
	
	public RevisionDynamicRange(){
		super();
		name = "Revise Image Dynamic Range Class for graduation thesis";

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
		
		int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				min = Math.min(input[0].getValueI(x,y,0),min);
				max = Math.max(input[0].getValueI(x,y,0),max);
				min = Math.min(input[0].getValueI(x,y,1),min);
				max = Math.max(input[0].getValueI(x,y,1),max);
				min = Math.min(input[0].getValueI(x,y,2),min);
				max = Math.max(input[0].getValueI(x,y,2),max);
			}
		}
		double multiple = 255.0/(max - min);
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue((int)((input[0].getValueI(x,y,0)-min)*multiple),x,y,0);
				output[0].setValue((int)((input[0].getValueI(x,y,1)-min)*multiple),x,y,1);
				output[0].setValue((int)((input[0].getValueI(x,y,2)-min)*multiple),x,y,2);
			}
		}
	}

	public void setParameter(){
	}
}
