package Recursion;
import java.util.Scanner;

public class RecursionLevelThree {
	public static void printSubsequence() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printSubSequenceHelper(str,"");
				
	}
	
	private static void printSubSequenceHelper(String ques, String ans) {
		
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		printSubSequenceHelper(ros,ans+"");
		printSubSequenceHelper(ros,ans+ch);
		
		
		
	}

	public static void printKeyPadCombination() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printKeyPadCombinationHelper(str,"");	
	}
	
	private static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	private static void printKeyPadCombinationHelper(String ques,String ans) {
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		
		char ch = ques.charAt(0);
		String roi = ques.substring(1);
		
		String CodeString = codes[ch-'0'];
		for(int i=0;i<CodeString.length();i++) {
			printKeyPadCombinationHelper(roi,ans+CodeString.charAt(i));
		}
		
	}
	
	public static void printStairPaths() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		printStairPathsHelper(n,"");
		
	}
	
	private static void printStairPathsHelper(int n, String ans) {
		if(n==0) {
			System.out.print(ans+" ");
			return;
		}
		if(n<0) {
			return;
		}
			
		printStairPathsHelper(n-1,ans+'1');
		printStairPathsHelper(n-2,ans+'2');
		printStairPathsHelper(n-3,ans+'3');
		
	}
	
	public static void printMazePaths() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int  n = s.nextInt();
		int m = s.nextInt();
		printMazePathsHelper(1,1,n,m,"");
		
	}
	
	private static void printMazePathsHelper(int sr, int sc,int dr,int dc,String ans) {
		if(sr==dr&&sc==dc) {
			System.out.println(ans);
			return;
		}
		if(sr>dr||sc>dc) {
			return;
		}
		
		printMazePathsHelper(sr+1,sc,dr,dc,ans+"h->");
		
		printMazePathsHelper(sr,sc+1,dr,dc,ans+"v->");	
		
		
	}
	
	public static void printMazePathsVarJump() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int  n = s.nextInt();
		int m = s.nextInt();
		printMazePathsVarJumpHelper(1,1,n,m,"");
		
	}
	
	private static void printMazePathsVarJumpHelper(int sr, int sc,int dr,int dc,String ans) {

		if(sr==dr&&sc==dc) {
			System.out.println(ans);
			return;
		}
		if(sr>dr||sc>dc) {
			return;
		}
		
		for(int i=1;i<=dr-sr;i++) {
		 printMazePathsVarJumpHelper(sr+i,sc,dr,dc,ans+"h"+i+"->");
		}
		for(int i=1;i<=dc-sc;i++) {
		printMazePathsVarJumpHelper(sr,sc+i,dr,dc,ans+"v"+i+"->");
			}
		for(int i=1;i<=dr-sr&&i<=dc-sc;i++) {
		printMazePathsVarJumpHelper(sr+i,sc+i,dr,dc,ans+"d"+i+"->");
			}
		
	}
	
	public static void printPermutations() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		printPermutationsHelper(str,"");
				
	}
	
	private static void printPermutationsHelper(String ques, String ans) {
		
		if(ques.length()==0) {
			System.out.println(ans);
			return;
		}
		for(int i=0;i<ques.length();i++) {
			char ch = ques.charAt(i);
			String roiLeft = ques.substring(0,i);
			String roiRight = ques.substring(i+1);
			String roi = roiLeft+roiRight;
			printPermutationsHelper(roi,ans+ch);
		}

		
		
		
	}
	
	public static void encoding() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		encodingHelper(str,"");
	}
	
	private static void encodingHelper(String ques,String ans) {
		if(ques.length()==0) {
			System.out.println(ans);
			return;
		}
		if(ques.length()==1) {
			char ch = ques.charAt(0);
			String roq = ques.substring(1);
			if(ch=='0') {
				return;
			}
			else {
				int chInt = ch-'0';
				char code = (char)('a'+chInt-1);
				encodingHelper(roq,ans+code);
			}
		}
		else {
			char ch = ques.charAt(0);
			String roq = ques.substring(1);
			if(ch=='0') {
				return;
			}
			else {
				int chInt = ch-'0';
				char code = (char)('a'+chInt-1);
				encodingHelper(roq,ans+code);
			}
			String ch12 = ques.substring(0,2);
			String roq12 = ques.substring(2);
			int ch12Int = Integer.parseInt(ch12);
			if(ch12Int<26) {
				char code = (char)('a'+ch12Int-1);
				encodingHelper(roq12,ans+code);
			}
			
		}
		
		
		
		
	}
}
