// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Adder Class for test
//
// Add constant to All data

package liushuiEngine.dataconvert;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class OhoDecode1 extends Filter {
//	private int addValue;
	public OhoDecode1(){
		super();
		name = "Oho Decode Stage1 Class";
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
		int code[] = new int[5];
		code[0] = 0x27;
		code[1] = 0x39;
		code[2] = 0x5b;
		code[3] = 0x6d;
		code[4] = 0x55;
		
		for(int i = 0;i < input[0].getWidth(0);i++){
			int data = input[0].getValueI(i) & 0x7f;
			int dataxor[] = new int[5];
			for(int j = 0;j < 5;j++){
				dataxor[j] = data | code[j];
			}
			int sumbit[] = new int[5];
			for(int j = 0;j < 5;j++){ sumbit[j] = 0; }
			for(int j = 0;j < 5;j++){
				for(int k = 0;k < 5;k++){
					sumbit[j] += (0x01 & (dataxor[j] >> k));
				}
			}
			int min = 8;
			int checki = 0;
			for(int j = 0;j < 5;j++){
				if(sumbit[j] < min){
					min = sumbit[j];
					checki = j;
				}
			}
			output[0].setValue(code[checki],i);
		}
	}
	public void setParameter(){
	}
}
