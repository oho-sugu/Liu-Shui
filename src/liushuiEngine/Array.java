// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// General Array Class

package liushuiEngine;


public class Array{
	protected int dimensionArray;
	protected int width[];
	protected int arrayType = 0;

	public static final int INT = 1;
	public static final int DOUBLE = 2;
	public static final int STRING = 3;

	public Array(int wid0)
	{
		dimensionArray = 1;
		width = new int[1];
		width[0] = wid0;
	}
	
	public Array(int wid0,int wid1)
	{
		dimensionArray = 2;
		width = new int[2];
		width[0] = wid0;
		width[1] = wid1;
	}
	
	public Array(int wid0,int wid1,int wid2)
	{
		dimensionArray = 3;
		width = new int[3];
		width[0] = wid0;
		width[1] = wid1;
		width[2] = wid2;
	}
	
	public Array(int dim,int w[])
	{
		dimensionArray = dim;
		width = new int[dimensionArray];
		
		for(int i=0;i < dim;i++){
			width[i] = w[i];
		}
	}

	public int getDimension()
	{
		return dimensionArray;
	}

	public int getWidth(int dim)
	{
		if(dim < dimensionArray){
			return width[dim];
		}
		return 0;
	}

	public int getType()
	{
		return arrayType;
	}

	public void setValue(int value,int x){}
	public void setValue(int value,int x,int y){}
	public void setValue(int value,int x,int y,int z){}
	public void setValue(int value,int coord[]){}
	public void setValue(double value,int x){}
	public void setValue(double value,int x,int y){}
	public void setValue(double value,int x,int y,int z){}
	public void setValue(double value,int coord[]){}
	
	public int getValueI(int x){ return 0; }
	public int getValueI(int x,int y){ return 0; }
	public int getValueI(int x,int y,int z){ return 0; }
	public int getValueI(int coord[]){ return 0; }
	public double getValueD(int x){ return 0; }
	public double getValueD(int x,int y){ return 0; }
	public double getValueD(int x,int y,int z){ return 0; }
	public double getValueD(int coord[]){ return 0; }
	public String getValueS(int x){ return ""; }
	public String getValueS(int x,int y){ return ""; }
	public String getValueS(int x,int y,int z){ return ""; }
	public String getValueS(int coord[]){ return ""; }
}
