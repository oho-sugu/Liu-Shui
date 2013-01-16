// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Console Output Class
//
// This Class is Data Output Class to Console
// Write Input Array Data to Console

package liushuiEngine.fileIO;

import liushuiEngine.basicNode.Terminator;

public class ConOutput extends Terminator {
	public ConOutput(){
		super();
		name = "ConsoleOutput Class";
		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}
	
	public void Process(){
		for(int j = 0;j < input[0].getWidth(1);j++){
			for(int i = 0;i < input[0].getWidth(0);i++){
				System.out.print(""+input[0].getValueD(i,j)+" ");
			}
			System.out.println("");
		}
	}

	public void setParameter(){}
}
