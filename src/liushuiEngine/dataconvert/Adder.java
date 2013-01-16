// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Adder Class for test
//
// Add constant to All data

package liushuiEngine.dataconvert;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class Adder extends Filter {
	private int addValue;
	public Adder(){
		super();
		name = "Adder Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
		
		// addValue = avl;
	}

	public void Init(){
		super.Init();
	}

	public void setInput(int i,Array a){
		super.setInput(i,a);
		output[0] = new ArrayInt(input[0].getWidth(0));
	}

	public void Process(){
		for(int i = 0;i < input[0].getWidth(0);i++){
				output[0].setValue((input[0].getValueI(i) + addValue),i);
		}
	}
	public void setParameter(){
		System.out.println("Input Add Value");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		addValue = Integer.valueOf(str[0]).intValue();
	}
}
