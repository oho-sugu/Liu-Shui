// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Data Smoothing Filter Class Triangle Balance Point Method
//                This Method ideaed by Prof.Matsubara
// This Node Smooth Data

package liushuiEngine.dataanalysis;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class TBPFilter extends Filter {
	public TBPFilter(){
		super();
		name = "TBP Filter Class";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		int i,j;
		int length;
		
		length = input[0].getWidth(1);
		
		output[0] = new ArrayDouble(2,length-2);
		for(j = 0; j < length - 2;j++){
			double x = 0,y = 0;
			x = input[0].getValueD(0,j) + input[0].getValueD(0,j+1) + input[0].getValueD(0,j+2);
			y = input[0].getValueD(1,j) + input[0].getValueD(1,j+1) + input[0].getValueD(1,j+2);
			x /= 3;
			y /= 3;
			output[0].setValue(x,0,j);
			output[0].setValue(y,1,j);
		}
	}

	public void setParameter(){}
}
