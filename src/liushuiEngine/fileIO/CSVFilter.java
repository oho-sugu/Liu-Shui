// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class CSV Tokenizer & Output Filter Class
// This Node Convert CSV Data Array to ArrayDouble2D
// Require in Head of Data there is Width & Height Data
// Width,Height
// data,data,-------

package liushuiEngine.fileIO;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class CSVFilter extends Filter {
	private static final int CR = 0x0D;
	private static final int LF = 0x0A;
	private static final int COMMA = 0x2C;
	private static final int SPC = 0x20;
	private static final int TAB = 0x09;
	private static final int MINUS = 0x2D;
	private static final int PERIOD = 0x2E;
	// int to Number   INT - 0x30

	private int countInp = 0;
	private int width,height;
	
	public CSVFilter(){
		super();
		name = "CSVFilter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		int i,j;
		width = (int)cutToken();
		height = (int)cutToken();
		output[0] = new ArrayDouble((int)width,(int)height);
		for(j = 0; j < (int)height;j++){
			for(i = 0; i < (int)width; i++){
				output[0].setValue(cutToken(),i,j);
			}
		}
	}

	private double cutToken()
	{
		double retValue = 0;
		String valueStr = "";
		int loopFlag = 0; // 0 : Looping 1 : Out Loop

		while(loopFlag == 0){
			int ch = input[0].getValueI(countInp);
			if(ch == COMMA){
				loopFlag = 1;
			} else if(ch == PERIOD){
				valueStr = valueStr + ".";
			} else if(ch == CR){
				loopFlag = 1;
			} else if(ch == MINUS){
				valueStr = valueStr + "-";
			} else if((0x29 < ch) && (ch < 0x3A)){
				valueStr = valueStr + Integer.toString(ch - 0x30);
			}
			countInp++;
		}

		retValue = new Double(valueStr).doubleValue();
		return retValue;
	}

	public void setParameter(){}
}
