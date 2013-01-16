// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Noise Genelator
//
// Add Noise as Information Communication Test

package liushuiEngine.dataprocess;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class Noise extends Filter {
	private int noiseNum;
	public Noise(){
		super();
		name = "Noise Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
	}

	public void Init(){
		super.Init();
	}

	public void setInput(int i,Array a){
		super.setInput(i,a);
		output[0] = new ArrayInt(input[0].getWidth(0));
	}

	public void Process(){
		int noiseCount = noiseNum;
		for(int i = 0;i < input[0].getWidth(0);i++){
			if(Math.random() < 0.5 && noiseCount > 0){
				output[0].setValue(input[0].getValueI(i) ^ 0x1 , i);
				noiseCount--;
			} else {
				output[0].setValue(input[0].getValueI(i), i);
			}
			System.out.print(""+output[0].getValueI(i));
		}
		System.out.println("");
	}
	public void setParameter(){
		System.out.println("Input Noise Number");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		noiseNum = Integer.valueOf(str[0]).intValue();
	}
}
