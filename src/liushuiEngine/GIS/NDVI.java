// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Diff Class

package liushuiEngine.GIS;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.in2out1;

public class NDVI extends in2out1 {
	private int width,height;
	
	public NDVI(){
		super();
		name = "NDVI Calc Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 2;
		// 0 Src 1 Dist 
		//
		//    Src - Dist
		//
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
		
		output[0] = new ArrayDouble(width,height);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				double ndvi;
				int IR,R;
				IR = input[0].getValueI(x,y);
				R = input[1].getValueI(x,y);
				if(IR+R == 0)
				{
					output[0].setValue(0.0,x,y);
				} else {
					ndvi = ((double)IR - (double)R)/((double)IR + (double)R);
					output[0].setValue(ndvi,x,y);

				}
			}
		}
	}

	public void setParameter(){
	}
}
