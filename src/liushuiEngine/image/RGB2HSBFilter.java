// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class RGB2HSBFilter extends Filter {
	private int width,height;
	
	public RGB2HSBFilter(){
		super();
		name = "RGB2HSBFilter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);
		double hsb[] = new double[3];
		
		output[0] = new ArrayDouble(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				hsb = RGBtoHSB(input[0].getValueI(x,y,0),
				               input[0].getValueI(x,y,1),input[0].getValueI(x,y,2));
				output[0].setValue(hsb[0],x,y,0);
				output[0].setValue(hsb[1],x,y,1);
				output[0].setValue(hsb[2],x,y,2);
			}
		}
		
	}

	public void setParameter(){}
	
	public double[]	RGBtoHSB(int ir, int ig, int ib)
	{
		double max;	// r,g,bの最大値
		double min;	// r,g,bの最小値
		double dr, dg, db;
		double d;
		double ret[] = new double[3];
		double rr,gg,bb;
		double h,s,b;
		
		rr = (double)ir / 255.0;
		gg = (double)ig / 255.0;
		bb = (double)ib / 255.0;
	
		// 最大の色、最小の色を求める
		max = Math.max(Math.max(rr,gg),bb);
		min = Math.min(Math.min(rr,gg),bb);
		d = max - min;
		// 明度を求める
		b = max;
		// 彩度を求める(黒なら彩度なし)
		if(max != 0.0) {
			s = d / max;
		}
		else {
			s = 0.0;		// 黒
		}
		// 色相を求める
		if(s == 0.0) {
			h = 0.0;	// グレイのとき
		}
		else {
			dr = (max - rr) / d;
			dg = (max - gg) / d;
			db = (max - bb) / d;
			if(rr == max) {
				h = db - dg;
			}
			else if(gg == max) {
				h = 2.0 + dr - db;
			}
			else {
				h = 4.0 + dg - dr;
			}
			h /= 6.0;
			if( h < 0.0) {
				h += 1.0;
			}
		}
		
		ret[0] = h;
		ret[1] = s;
		ret[2] = b;
		
		return ret;
	} 
}
