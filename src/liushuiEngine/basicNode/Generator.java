// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Generator Class

package liushuiEngine.basicNode;

import liushuiEngine.Array;
import liushuiEngine.Node;

public class Generator extends Node {
	public Generator(){
		super();

		name = "Generator Class";

		input = null;
		output = new Array[1];

		inputArrayType = new int[1];
		inputArrayDimension = new int[1];
		outputArrayType = new int[1];
		outputArrayDimension = new int[1];
		inputArrayType[0] = 0;
		inputArrayDimension[0] = 0;
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){}
	public void Process(){}
	public Array getOutput(int i){
		if(i < 1) return output[0];
		return null;
	}
	public void setParameter(){}
}
