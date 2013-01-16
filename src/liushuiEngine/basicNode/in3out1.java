// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Filter Class
// One Input One Output Node

package liushuiEngine.basicNode;

import liushuiEngine.Array;
import liushuiEngine.Node;

public class in3out1 extends Node {
	public in3out1(){
		super();

		name = "Input3Output1 Class";

		input = new Array[3];
		output = new Array[1];

		inputArrayType = new int[3];
		inputArrayDimension = new int[3];
		outputArrayType = new int[1];
		outputArrayDimension = new int[1];
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 3) input[i] = a;
	}

	public void Process(){}
	public Array getOutput(int i){
		if(i < 1) return output[0];
		return null;
	}
	public void setParameter(){}
}
