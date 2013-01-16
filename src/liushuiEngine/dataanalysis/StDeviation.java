// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Calc Standard Deviation

package liushuiEngine.dataanalysis;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class StDeviation extends Filter {
	public StDeviation(){
		super();
		name = "Standard Deviation Calc Class";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 2;
		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		int i,j;
		int length;
		
		length = input[0].getWidth(1); // データ数の計算格納
		
		output[0] = new ArrayDouble(1,5);
		double sum = 0,avr = 0,sum2 = 0; // sum：合計格納用 avr：平均格納用 sum2：２乗の合計
		for(j = 0; j < length;j++){
			sum += input[0].getValueD(0,j); // input[0].getValueD(0,j)１つのデータ
		}
		avr = sum / (double)length;
		for(j = 0; j < length;j++){
			sum2 += (input[0].getValueD(0,j) - avr)*(input[0].getValueD(0,j) - avr);
			// 平均との差をとって、２乗　合計
		}
		double stDev = Math.sqrt(sum2/((double)(length - 1)));
		double stDev2 = Math.sqrt(sum2/(double)length);

		//以下、結果の出力
		output[0].setValue(stDev,0,0);
		output[0].setValue(avr,0,1);
		output[0].setValue(sum,0,2);
		output[0].setValue(sum2,0,3);
		output[0].setValue(stDev2,0,4);
	}

	public void setParameter(){}
}
