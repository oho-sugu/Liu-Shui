// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class BCH Code Encoder Class
// 
// Encode 7bit data to (15,7)Double Error Correct Code

package liushuiEngine.dataprocess;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class BCHEncode extends Filter {
	public BCHEncode(){
		super();
		name = "BCH Code Encode Class";
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
		output[0] = new ArrayInt(15);
	}

	public void Process(){
		int shtReg[] = {0,0,0,0,0,0,0,0};
		int shtRegBk[] = {0,0,0,0,0,0,0,0};
		int xorVal = 0;

		for(int i = 7;i > 0;i--){
			xorVal = input[0].getValueI(i-1) ^ shtReg[7];
			output[0].setValue(input[0].getValueI(i-1),7+i);

			shtRegBk[0] = xorVal;
			shtRegBk[1] = shtReg[0];
			shtRegBk[2] = shtReg[1];
			shtRegBk[3] = shtReg[2];
			shtRegBk[4] = shtReg[3] ^ xorVal;
			shtRegBk[5] = shtReg[4];
			shtRegBk[6] = shtReg[5] ^ xorVal;
			shtRegBk[7] = shtReg[6] ^ xorVal;

			for(int j = 0;j < 8;j++){
				shtReg[j] = shtRegBk[j];
			}
		}
		
		for(int i = 8;i > 0;i--){
			output[0].setValue(shtReg[i-1],i-1);
		}
		
		for(int i = 0;i < 15;i++) System.out.print(""+output[0].getValueI(i));
		
		System.out.println("");
	}
	public void setParameter(){
	}
}
