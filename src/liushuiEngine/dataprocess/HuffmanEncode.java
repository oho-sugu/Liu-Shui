// Huffman Encode Routine
// Copyright 2002 Oho Suguru
// 2002 / 09 / 08
// Processing Node for MuDAS-LiuShui(Tentative Name)
// This Program is very Slow and Heavy Memory Eater,
// But Basic implement of Huffman Code.
// And easy to Understand , maybe.
// Furthermore this routine based on Object Oriented Program.

package liushuiEngine.dataprocess;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class HuffmanEncode extends Filter {
	protected HuffNode huffTree[] = new HuffNode[1024];

//	int countNewNode = 255;
	int countAllNode = 255;
	
	int CodeBits[][] = new int[256][24];
	int codeLength[] = new int[256];

	int bitCount = 0,inputPointer = 0;
	int originalDataLength = 0;

	public HuffmanEncode(){
		super();
		name = "Huffman Encode Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 1;
	}
	public void Init(){
		super.Init();
		for(int i = 0;i < 256;i++){
			for(int j = 0;j < 24;j++){
				CodeBits[i][j] = 0;
			}
		}
	}

	public void Process(){
		// Huffman Tree Initialize
		for(int i = 0;i < 256;i++){
			huffTree[i] = new HuffNode();
			huffTree[i].code = i;
			huffTree[i].type = HuffNode.LEAF;
		}

		// Calc Frequency
		for(int i = 0;i < input[0].getWidth(0);i++){
			huffTree[input[0].getValueI(i)].freq++;
		}

//		for(int i = 0;i < 256;i++){
//			System.out.println("Huffman Encode : Node : "+i+" Freq : "+huffTree[i].freq);
//		}
		
		// Set Original Data Length
		originalDataLength = input[0].getWidth(0);
//		System.out.println("Huffman Encode : OriginalDataLength : "+originalDataLength);
		
		// Create Huffman Tree
		int flagNoUpper = countAllNode+1;
		while(flagNoUpper > 1){
			flagNoUpper = countAllNode+1;
			int min1 = 0x7fffffff,min2 = 0x7fffffff;
			int min1NodeNo = 2046,min2NodeNo = 2046;
			for(int i = 0;i < countAllNode+1;i++){
				if(huffTree[i].freq == 0){
					flagNoUpper--;
				} else {
					if(huffTree[i].Up != null) flagNoUpper--;
					
					if((min1 > huffTree[i].freq || min2 > huffTree[i].freq) && huffTree[i].Up == null){
						if(min1 > min2){
							min1 = min2;
							min1NodeNo = min2NodeNo;
							min2 = huffTree[i].freq;
							min2NodeNo = i;
						} else {
							min2 = huffTree[i].freq;
							min2NodeNo = i;
						}
					}
				}
			}
			huffTree[++countAllNode] = new HuffNode();
//			++countAllNode;
			huffTree[countAllNode].freq = min1 + min2;
			huffTree[countAllNode].Low1 = huffTree[min1NodeNo];
			huffTree[countAllNode].Low2 = huffTree[min2NodeNo];
			huffTree[min1NodeNo].bit = 0;
			huffTree[min2NodeNo].bit = 1;
			huffTree[min1NodeNo].Up = huffTree[countAllNode];
			huffTree[min2NodeNo].Up = huffTree[countAllNode];
			huffTree[countAllNode].type = HuffNode.BRANCH;
			flagNoUpper--;
		}

		// Create Code Bits
		// Code 2 is Terminate code
		HuffNode workUp;
		for(int i = 0;i < 256;i++){
//			System.out.print("Origin Code "+i+" : ");
			if(huffTree[i].freq == 0){
//				System.out.println(" No Code");
				CodeBits[i][0] = 2;
			} else {
				CodeBits[i][1] = 2;
				CodeBits[i][0] = huffTree[i].bit;
				workUp = huffTree[i].Up;
//				System.out.println("");
				while(workUp != null){
					if(workUp.Up == null) break;
					for(int j = 24;j > 1;j--){
						CodeBits[i][j-1] = CodeBits[i][j - 2];
					}
					CodeBits[i][0] = workUp.bit;
					workUp = workUp.Up;
				}
			}
		}
		
		// For Test Printout All Code
		for(int i = 0;i < 256;i++){
//			System.out.print(""+i+" : ");
			for(int j = 0;j < 24;j++){
//				System.out.print(""+CodeBits[i][j]);
			}
//			System.out.println("");
		}
		
		// count Code Length & calc Array Length
		for(int i = 0;i < 256;i++){
			int length = 0;
			int j = 0;
			while(CodeBits[i][j] != 2){
				j++;
				length++;
			}
			codeLength[i] = length;
		}
		long sum = 0;
		for(int i = 0;i < 256;i++){
			sum += codeLength[i]*huffTree[i].freq;
		}
		long dataSize = (long)(sum / 8.0) + 1 + 1024 + 8 + 4;

//		System.out.println("Huffman Encode : sum : "+sum);
		
		// dataSize : Byte  sum : bit
		
		output[0] = new ArrayInt((int)dataSize);
		
		// set Data Header
		//long sum  8Byte
		//int original Length
		//int  freq 4Byte * 256
		//int data-----
		
		// set Sum
		output[0].setValue((int)( sum        & 0x00000000000000ff),0);
		output[0].setValue((int)((sum >>  8) & 0x00000000000000ff),1);
		output[0].setValue((int)((sum >> 16) & 0x00000000000000ff),2);
		output[0].setValue((int)((sum >> 24) & 0x00000000000000ff),3);
		output[0].setValue((int)((sum >> 32) & 0x00000000000000ff),4);
		output[0].setValue((int)((sum >> 40) & 0x00000000000000ff),5);
		output[0].setValue((int)((sum >> 48) & 0x00000000000000ff),6);
		output[0].setValue((int)((sum >> 56) & 0x00000000000000ff),7);

		// set Original Length
		output[0].setValue((int)( originalDataLength        & 0x00000000000000ff),8);
		output[0].setValue((int)((originalDataLength >>  8) & 0x00000000000000ff),9);
		output[0].setValue((int)((originalDataLength >> 16) & 0x00000000000000ff),10);
		output[0].setValue((int)((originalDataLength >> 24) & 0x00000000000000ff),11);
		
		
		// set freq
		int dataloc = 12;
		for(int i = 0;i < 256;i++){
			int tempFreq = huffTree[i].freq;
			output[0].setValue((int)(tempFreq & 0x000000ff),dataloc++);
			output[0].setValue((int)((tempFreq >> 8) & 0x000000ff),dataloc++);
			output[0].setValue((int)((tempFreq >> 16) & 0x000000ff),dataloc++);
			output[0].setValue((int)((tempFreq >> 24) & 0x000000ff),dataloc++);
		}
		
		// set Data
		bitCount = 0;
		inputPointer = dataloc;
		
		for(int i = 0;i < input[0].getWidth(0);i++){
			int code = input[0].getValueI(i);
			int j = 0;
			while(CodeBits[code][j] != 2){
				putBit(CodeBits[code][j++]);
			}
		}
	}
	
	public void putBit(int bit){
		if(bitCount < 8){
			int inData = output[0].getValueI(inputPointer);
			int putData = (inData | (int)((bit & 0x01) << bitCount)) & 0x000000ff;
			output[0].setValue(putData,inputPointer);
			bitCount++;
		} else {
			bitCount = 0;
			inputPointer++;
			int inData = output[0].getValueI(inputPointer);
			int putData = (inData | (int)((bit & 0x01) << bitCount)) & 0x000000ff;
			output[0].setValue(putData,inputPointer);
			bitCount++;
		}
	}
}
