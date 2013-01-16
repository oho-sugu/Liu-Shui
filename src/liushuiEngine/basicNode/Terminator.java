// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Terminator Class

package liushuiEngine.basicNode;

import liushuiEngine.Array;
import liushuiEngine.Node;

public class Terminator extends Node {
	public Terminator(){
		super();

		name = "Terminator Class";

		input = new Array[1];
		output = null;

		inputArrayType = new int[1];
		inputArrayDimension = new int[1];
		outputArrayType = new int[1];
		outputArrayDimension = new int[1];
		outputArrayType[0] = 0;
		outputArrayDimension[0] = 0;
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 1) input[0] = a;
	}
	public void Process(){}
	public Array getOutput(int i){ return null;}
	public void setParameter(){}
}
