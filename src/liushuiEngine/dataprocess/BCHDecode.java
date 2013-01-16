// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class BCH Code Decoder Class
// 
// Decode 7bit data to (15,7)Double Error Correct Code

package liushuiEngine.dataprocess;

import liushuiEngine.Array;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class BCHDecode extends Filter {
	// Look Up Table
	private int multiAlpha1Table[] = {0x0,0x2,0x4,0x6,0x8,0xa,0xc,0xe,
																		0x3,0x1,0x7,0x5,0xb,0x9,0xf,0xd};
	private int multiAlpha3Table[] = {0x0,0x8,0x3,0xb,0x6,0xe,0x5,0xd,
																		0xc,0x4,0xf,0x7,0xa,0x2,0x9,0x1};
	private int SyTable1[][] = {{17, 5, 6, 9, 7, 3, 0, 0, 8, 4, 4, 2, 1, 3, 1, 2},
															{16, 0,16,16,16,16, 5,10,16,16,16,16,16,16,16,16},
															{16, 6,16,11, 3,16, 3, 1,16, 6, 1, 8,16,16,16, 1},
															{16, 7, 7,16,16, 9,12, 2, 4,16,16,16, 4, 2, 2,16},
															{16,11,16, 6,16, 7, 1, 6, 2, 1, 2,16,16, 1,16,16},
															{16, 3, 3,16,13,16, 4, 9,16,16,16, 3, 8,16, 4, 8},
															{16, 2,12, 3,16,16, 7, 3,16, 2, 8,16, 2,16, 7,16},
															{16, 1,16,16, 9, 6, 6,11, 1,16,16, 1,16, 4,16, 4},
															{16,16, 1,16,16,16,16,16,16,16,16,16, 6,16,11,16},
															{16,16,16, 0, 1, 1,16,16, 5,10, 5, 6,16, 0,16, 0},
															{16,16,16,16,16, 8,16,16, 3,16,16,16,16,13,16,16},
															{16,16, 8, 5, 0,16,16,16,16, 0,10, 5, 0,16, 3, 3},
															{16,16,16,16, 2,16,16,16,16,16,16, 7,16,16,16,12},
															{16,16, 2, 2,16, 0,16,16,10, 5, 0,16, 7, 5, 0,16},
															{16,16, 0,16, 4, 4,16,16, 0,16,16, 0, 5, 9,10, 5},
															{16,16,16, 4,16,16,16,16,16,14, 9,16,16,16,16,16}};

	private int SyTable2[][] = {{17,10,11,14,12,13,10, 5,13, 9,14,12,11, 8, 6, 7},
															{16, 0,16,16,16,16, 5,10,16,16,16,16,16,16,16,16},
															{16,13,16,13, 6,16,11, 8,16, 8, 3,11,16,16,16,13},
															{16, 9,14,16,16,12,14, 4, 7,16,16,16,12,14, 9,16},
															{16,12,16,12,16,11, 2, 7, 6, 7,11,16,16,12,16,16},
															{16,14, 9,16,14,16, 8,13,16,16,16, 4,14,16,13, 9},
															{16, 8,13, 7,16,16,13,12,16,13,12,16, 3,16, 8,16},
															{16, 4,16,16,11,14, 9,14, 9,16,16,14,16,11,16, 6},
															{16,16, 1,16,16,16,16,16,16,16,16,16, 6,16,11,16},
															{16,16,16, 1, 5,10,16,16,11,11, 6,10,16, 6,16,11},
															{16,16,16,16,16, 8,16,16, 3,16,16,16,16,13,16,16},
															{16,16,10, 8, 8,16,16,16,16, 3,13,13,13,16, 5,10},
															{16,16,16,16, 2,16,16,16,16,16,16, 7,16,16,16,12},
															{16,16, 5,10,16, 2,16,16,12,12, 7,16,10, 7,12,16},
															{16,16, 4,16,10, 5,16,16,14,16,16, 9, 9,10,14,14},
															{16,16,16, 4,16,16,16,16,16,14, 9,16,16,16,16,16}};

	public BCHDecode(){
		super();
		name = "BCH Code Decode Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
/*		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 2;*/
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
	}

	public void Init(){
		super.Init();
	}

	public void setInput(int i,Array a){
		super.setInput(i,a);
		output[0] = new ArrayInt(15);
	}

	public void Process(){
		// Calc Syndrome
		int s1 = 0,s3 = 0;

		for(int i = 15;i > 0;i--){
			s1 = multiAlpha1Table[s1] ^ input[0].getValueI(i-1);
//					s1 = multiAlpha1Table[s1] ^ ePattern[i-1];
		}
		for(int i = 15;i > 0;i--){
			s3 = multiAlpha3Table[s3] ^ input[0].getValueI(i-1);
//					s3 = multiAlpha3Table[s3] ^ ePattern[i-1];
		}
		
		System.out.println(""+s1+" "+s3);
		
		// Calc Error Point
		int ePoint1 = SyTable1[s3][s1];
		int ePoint2 = SyTable2[s3][s1];
		System.out.println(""+ePoint1+" "+ePoint2);

		// Decode
		for(int i = 0;i < 15;i++) output[0].setValue(input[0].getValueI(i),i);
		
		if(ePoint1 == 17 || ePoint2 == 17){
			System.out.println("No Error!!");
		} else if(ePoint1 == 16 || ePoint2 == 16){
			System.out.println("Can't Decode this code!!");
		} else if(ePoint1 == ePoint2){
			System.out.println("One Error");
			output[0].setValue(input[0].getValueI(ePoint1) ^ 0x1,ePoint1);
		} else {
			System.out.println("Two Error");
			output[0].setValue(input[0].getValueI(ePoint1) ^ 0x1,ePoint1);
			output[0].setValue(input[0].getValueI(ePoint2) ^ 0x1,ePoint2);
		}
		
		for(int i = 0;i < 15;i++) System.out.print(""+output[0].getValueI(i));
		
		System.out.println("");
	}
	public void setParameter(){
	}
}
