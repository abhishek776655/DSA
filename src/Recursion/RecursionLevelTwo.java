package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionLevelTwo {
	
	public static void getSubsequence() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		ArrayList<String> res = subSequenceHelper(str);
		System.out.print(res);
				
	}
	
	private static ArrayList<String> subSequenceHelper(String str) {
		if(str.length()==0) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		
		ArrayList<String> rres = subSequenceHelper(ros); 
		
		ArrayList<String> mres = new ArrayList<String>();
		
		for(String res:rres) {
			mres.add(""+res);
		}
		for(String res:rres) {
			mres.add(ch+res);
		}
		return mres;
		
	}
	
	public static void getKeyPadCombination() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String str = s.next();
		ArrayList<String> res = getKeyPadCombinationHelper(str);
		System.out.print(res);
				
	}
	
	private static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	private static ArrayList<String> getKeyPadCombinationHelper(String str) {
		if(str.length()==0) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> rres = getKeyPadCombinationHelper(ros);
		ArrayList<String> mres = new ArrayList<String>();
		String code = codes[ch-'0'];
		
		for(int i=0;i<code.length();i++) {
			char ctd = code.charAt(i);
		
			for(String res:rres) {
				mres.add(ctd+res);
			}
		}
		return mres;
	}
	
	public static void getStairPaths() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<String> res = getStairPathsHelper(n);
		System.out.print(res);
		
	}
	
	private static ArrayList<String>getStairPathsHelper(int n){

		if(n==0) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;
		}
		else if(n<0) {
			ArrayList<String> result = new ArrayList<String>();
			return result;
		}
		
		
		ArrayList<String> rres1 = getStairPathsHelper(n-1);
		ArrayList<String> rres2 = getStairPathsHelper(n-2);
		ArrayList<String> rres3 = getStairPathsHelper(n-3);
		ArrayList<String> mres = new ArrayList<String>();
		
		for(String res:rres1) {
			mres.add(1+res);
		}
		for(String res:rres2) {
			mres.add(2+res);
		}
		for(String res:rres3) {
			mres.add(3+res);
		}
		return mres;
		
		
	}
	
	public static void getMazePaths() {

		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int  n = s.nextInt();
		int m = s.nextInt();
		ArrayList<String> res = getMazePathsHelper(1,1,n,m);
		System.out.print(res);
				
	}
	
	private static ArrayList<String> getMazePathsHelper(int sr,int sc,int dr,int dc){
		if(sr==dr&&sc==dc) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;	
		}
		
		
		ArrayList<String>hres = new ArrayList<String>();
		ArrayList<String>vres = new ArrayList<String>();
		
		if(sr<dr) {
			vres = getMazePathsHelper(sr+1,sc,dr,dc);
		}
		if(sc<dc) {
			hres = getMazePathsHelper(sr,sc+1,dr,dc);
		}
		
		ArrayList<String>mres = new ArrayList<String>();
		for(String res:hres) {
			mres.add('h'+res);
		}
		for(String res:vres) {
			mres.add('v'+res);
		}
		return mres;
		
		
		
	}
	
	public static void getMazePathsVariableJumps() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int  n = s.nextInt();
		int m = s.nextInt();
		ArrayList<String> res = getMazePathsVarJumpsHelper(1,1,n,m);
		System.out.print(res);
				
	}
	
	private static ArrayList<String>getMazePathsVarJumpsHelper(int sr,int sc,int dr,int dc){
		if(sr==dr&&sc==dc) {
			ArrayList<String> result = new ArrayList<String>();
			result.add("");
			return result;	
			
		}
		ArrayList<String>Paths = new ArrayList<String>();
		
		for(int mh = 1;mh<=dc-sc;mh++) {
			ArrayList<String>hPaths = getMazePathsVarJumpsHelper(sr,sc+mh,dr,dc);
			for(String path:hPaths) {
				Paths.add("h"+mh+path);
			}
		}
		for(int mv = 1;mv<=dr-sr;mv++) {
			ArrayList<String>vPaths = getMazePathsVarJumpsHelper(sr+mv,sc,dr,dc);
			for(String path:vPaths) {
				Paths.add("v"+mv+path);
			}
		}
		for(int md = 1;md<=dc-sc&&md<=dr-sr;md++) {
			ArrayList<String>dPaths = getMazePathsVarJumpsHelper(sr+md,sc+md,dr,dc);
			for(String path:dPaths) {
				Paths.add("d"+md+path);
			}
		}
		return Paths;
	}
}
