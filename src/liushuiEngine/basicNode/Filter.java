// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Filter Class
// One Input One Output Node

package liushuiEngine.basicNode;


import liushuiEngine.Array;
import liushuiEngine.Node;

public class Filter extends Node {
	public Filter(){
		super();

		name = "Filter Class";

		input = new Array[1];
		output = new Array[1];

		inputArrayType = new int[1];
		inputArrayDimension = new int[1];
		outputArrayType = new int[1];
		outputArrayDimension = new int[1];
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 1) input[0] = a;
	}

	public void Process(){}
	public Array getOutput(int i){
		if(i < 1) return output[0];
		return null;
	}
	public void setParameter(){}
}
