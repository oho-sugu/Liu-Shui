// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Double Array Class

package liushuiEngine;


public class ArrayDouble extends Array{
	protected double data[];

	public ArrayDouble(int wid0)
	{
		super(wid0);
		arrayType = DOUBLE;
		data = new double[wid0];
	}
	
	public ArrayDouble(int wid0,int wid1)
	{
		super(wid0,wid1);
		arrayType = DOUBLE;
		data = new double[wid0*wid1];
	}
	
	public ArrayDouble(int wid0,int wid1,int wid2)
	{
		super(wid0,wid1,wid2);
		arrayType = DOUBLE;
		data = new double[wid0*wid1*wid2];
	}
	
	public ArrayDouble(int dim,int w[])
	{
		super(dim,w);
		arrayType = DOUBLE;
		int length = 1;
		for(int i=0;i < dim;i++){
			length *= width[i];
		}
		data = new double[length];
	}

	public double getValueD(int x)
	{
		if(dimensionArray == 1){
			if(x < width[0]){
				return data[x];
			}
		}
		return 0;
	}
	
	public double getValueD(int x,int y)
	{
		if(dimensionArray == 2){
			if((x < width[0])&&(y < width[1])){
				return data[x+width[0]*y];
			}
		}
		return 0;
	}
	
	public double getValueD(int x,int y,int z)
	{
		if(dimensionArray == 3){
			if((x < width[0])&&(y < width[1])&&(z < width[2])){
				return data[x+width[0]*y+width[0]*width[1]*z];
			}
		}
		return 0;
	}
	
	public double getValueD(int coord[])
	{
		int chkf=0,len=0,mul=1;
		if(dimensionArray == coord.length){
			for(int i = 0;i < dimensionArray;i++){
				if(coord[i] < width[i]) chkf++;
				len += coord[i]*mul;
				mul *= width[i];
			}
			if(chkf == dimensionArray){
				return data[len];
			}
		}
		return 0;
	}

	public void setValue(double value,int x)
	{
		if(dimensionArray == 1){
			if(x < width[0]){
				data[x] = value;
			}
		}
	}
	
	public void setValue(double value,int x,int y)
	{
		if(dimensionArray == 2){
			if((x < width[0])&&(y < width[1])){
				data[x+width[0]*y] = value;
			}
		}
	}
	
	public void setValue(double value,int x,int y,int z)
	{
		if(dimensionArray == 3){
			if((x < width[0])&&(y < width[1])&&(z < width[2])){
				data[x+width[0]*y+width[0]*width[1]*z] = value;
			}
		}
	}
	
	public void setValue(double value,int coord[])
	{
		int chkf=0,len=0,mul=1;
		if(dimensionArray == coord.length){
			for(int i = 0;i < dimensionArray;i++){
				if(coord[i] < width[i]) chkf++;
				len += coord[i]*mul;
				mul *= width[i];
			}
			if(chkf == dimensionArray){
				data[len] = value;
			}
		}
	}
}
