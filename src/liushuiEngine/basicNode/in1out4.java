// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Filter Class
// One Input One Output Node

package liushuiEngine.basicNode;


import liushuiEngine.Array;
import liushuiEngine.Node;

public class in1out4 extends Node {
	public in1out4(){
		super();

		name = "Input1 Output4 Class";

		input = new Array[1];
		output = new Array[4];

		inputArrayType = new int[1];
		inputArrayDimension = new int[1];
		outputArrayType = new int[4];
		outputArrayDimension = new int[4];
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 1) input[0] = a;
	}

	public void Process(){}
	public Array getOutput(int i){
		if(i < 4) return output[i];
		return null;
	}
	public void setParameter(){}
}
