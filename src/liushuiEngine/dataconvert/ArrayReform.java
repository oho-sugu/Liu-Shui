// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Array Reforming Filter

package liushuiEngine.dataconvert;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class ArrayReform extends Filter {
	public ArrayReform(){
		super();
		name = "Array Reform Filter Class";

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
		int length;
		
		length = input[0].getWidth(1);
		
		output[0] = new ArrayDouble(16,16);

		for(int x = 0;x < 16;x++){
			for(int y = 0;y < 16;y++){
				output[0].setValue(16.0,x,y);
			}
		}
		
		for(int j = 0; j < length;j++){
			output[0].setValue(input[0].getValueD(3,j),
												(int)input[0].getValueD(0,j),
												(int)input[0].getValueD(1,j));
		}
	}

	public void setParameter(){}
}
