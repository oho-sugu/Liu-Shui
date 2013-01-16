// Huffman Tree's Node Class for Huffman Encode Decode Routine
// Copyright 2002 Oho Suguru
// 2002 / 09 / 08
// Sub Processing Node for MuDAS-LiuShui(Tentative Name)

package liushuiEngine.dataprocess;


class HuffNode {
	public int freq;
	public int code;
	public int bit;
	public int type;
	// type  0:Leaf 1:Branch 2:Root
	public static final int LEAF = 0;
	public static final int BRANCH = 1;
	public static final int ROOT = 2;
	
	public HuffNode Low1,Low2;
	public HuffNode Up;
//	public HuffNode Right,Left;

	public HuffNode(){
		freq = 0;
	}
}
