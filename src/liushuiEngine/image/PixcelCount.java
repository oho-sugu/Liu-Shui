// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class PixcelCount extends Filter {
	private int width,height;
	
	public PixcelCount(){
		super();
		name = "Pixcel Counter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = DOUBLE;
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
		
		double cnt = 0;
		
		output[0] = new ArrayDouble(1,1);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int rgb = input[0].getValueI(x,y,0)+input[0].getValueI(x,y,1)+input[0].getValueI(x,y,2);
				cnt += (double)rgb / 3.0;
			}
		}
		cnt /= 255.0;
		
		output[0].setValue(cnt,0,0);
	}

	public void setParameter(){}
}
