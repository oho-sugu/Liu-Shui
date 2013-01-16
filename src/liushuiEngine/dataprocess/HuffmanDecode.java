// Huffman Decode Routine
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

public class HuffmanDecode extends Filter {
	protected HuffNode huffTree[] = new HuffNode[1024];

//	int countNewNode = 255;
	int countAllNode = 255;
	
	int CodeBits[][] = new int[256][24];
	int codeLength[] = new int[256];

	int bitCount = 0,inputPointer = 0;
	long bitSumCount = 0;
	int originalDataLength = 0;

	public HuffmanDecode(){
		super();
		name = "Huffman Decode Class";
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

		// bitSumCount : bit
		// get Data Header
		// long sum  8Byte
		// int originalDataLength 4Byte
		// int  freq 4Byte * 256
		// int data-----
		
		// get Sum
		bitSumCount += (long)(input[0].getValueI(0));
		bitSumCount += (long)(input[0].getValueI(1) << 8);
		bitSumCount += (long)(input[0].getValueI(2) << 16);
		bitSumCount += (long)(input[0].getValueI(3) << 24);
		bitSumCount += (long)(input[0].getValueI(4) << 32);
		bitSumCount += (long)(input[0].getValueI(5) << 40);
		bitSumCount += (long)(input[0].getValueI(6) << 48);
		bitSumCount += (long)(input[0].getValueI(7) << 56);
//		System.out.println("Huffman Decode : bitSumCount : "+bitSumCount);
		
		originalDataLength += input[0].getValueI(8);
		originalDataLength += input[0].getValueI(9) << 8;
		originalDataLength += input[0].getValueI(10) << 16;
		originalDataLength += input[0].getValueI(11) << 24;
//		System.out.println("Huffman Decode : originalDataLength : "+originalDataLength);

		output[0] = new ArrayInt(originalDataLength);

		// get freq
		int dataloc = 12;
		for(int i = 0;i < 256;i++){
			int tempFreq = 0;
			tempFreq += input[0].getValueI(dataloc++);
			tempFreq += input[0].getValueI(dataloc++) << 8;
			tempFreq += input[0].getValueI(dataloc++) << 16;
			tempFreq += input[0].getValueI(dataloc++) << 24;
			huffTree[i].freq = tempFreq;
//			System.out.println("Huffman Decode : Node No : "+i+" Freq : "+tempFreq);
		}
		
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

		// get Data & Decode
		bitCount = 0;
		inputPointer = dataloc;
		
		for(int i = 0;i < originalDataLength;i++){
			HuffNode temp;
			temp = huffTree[countAllNode];
			while(temp.type != HuffNode.LEAF){
				if(getBit() == 0){
					temp = temp.Low1;
				} else {
					temp = temp.Low2;
				}
			}
			output[0].setValue(temp.code,i);
		}
	}
	
	public int getBit(){
		if(bitCount < 8){
			int inData = input[0].getValueI(inputPointer);
			return (inData >> bitCount++) & 0x00000001;
		} else {
			bitCount = 0;
			inputPointer++;
			int inData = input[0].getValueI(inputPointer);
			return (inData >> bitCount++) & 0x00000001;
		}
	}
}
