// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Adder Class for test
//
// Add constant to All data

package liushuiEngine.dataconvert;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class TeraFilter extends Filter {
	public TeraFilter(){
		super();
		name = "TeraFilter Class";
		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
	}

	public void Init(){
		super.Init();
	}

	public void setInput(int i,Array a){
		super.setInput(i,a);
		output[0] = new ArrayInt(input[0].getWidth(0) * 2 + 1);
	}

	public void Process(){
		for(int i = 0;i < input[0].getWidth(1);i++){
				output[0].setValue((int)(input[0].getValueD(0,i)),2*i);
				output[0].setValue((int)(input[0].getValueD(0,i))>>8,2*i+1);
		}
	}
	public void setParameter(){
	}
}
