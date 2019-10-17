package g.edu.alexu.csd.oop.calculator;
	import java.util.Scanner;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import java.io.*;
	public class calc implements calculator {
		public static String expression,result,expressions[]=new String[5],store;
	    double ans,answers[]=new double[5];
	    int index=0,iter;
		public void input(String s) {
			expression="";
		int j=0,k=0,n=s.length();
		while(s.charAt(j)=='-') {j++;}
		if(j%2==1) {expression+='-';}
		while(j<n&&s.charAt(j)!='-') {
			expression+=s.charAt(j++);}
		if(j<n) {
			if(!(s.charAt(j-1)=='+'||s.charAt(j-1)=='*'||s.charAt(j-1)=='/')){expression+=s.charAt(j++);}
		while(j<n&&s.charAt(j)=='-') {
			k++;
			j++;
		}
		if(k%2==1){expression+='-';}
		while(j<n) {expression+=s.charAt(j++);}
		}
			
			if(index<5) {expressions[index++]=expression;}
			else {
				for(int i=0;i<4;i++) {
					expressions[i]=expressions[i+1];
					answers[i]=answers[i+1];
				}
				expressions[4]=expression;
				index=5;
			}
		iter=index;
			String p="(-?\\d+(\\.\\d+)?)([-+*/])(-?\\d+(\\.\\d+)?)";
			Pattern check=Pattern.compile(p);
			Matcher m=check.matcher(expression);
			if(m.matches()) {
				ans=Evaluate(Double.parseDouble(m.group(1)),m.group(3).charAt(0),Double.parseDouble(m.group(4)));
				answers[index-1]=ans;
			}
			
		}
		public boolean  match(String s) {
			String p="((-+)?\\d+(\\.\\d+)?)([-+*/])((-+)?\\d+(\\.\\d+)?)";
			Pattern check=Pattern.compile(p);
			Matcher m=check.matcher(s);
			return m.matches();
		}
		
		public String getResult() {
			result=expression+'='+ans;
			return result;
		}
		public String current () {
			return expression;
		}
		public double Evaluate(double p1,char c,double p2) {
			double answer;
			if(c=='+') {answer=p1+p2;}
			else if(c=='*') {answer=p1*p2;}
			else if(c=='-') {answer=p1-p2;}
			else{answer=p1/p2;}
			return answer;
		}
		public void save() {
			try {
				FileWriter save=new FileWriter("memory.text");
				String s="";
				for(int i=0;i<index;i++) {s=s+expressions[i]+" "+answers[i]+" ";}
				save.write(s);
				save.close();
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		public void load() {
			try {
				FileReader read=null;
			read=new FileReader("memory.text");
			int i,j=0;
			store="";
			while((i=read.read())!=-1) {
			      store+=(char)i;}
			String temp="";
			int n=store.length();
			for(i=0;i<n;i++) {
				if(store.charAt(i)!=' ') {temp+=store.charAt(i);
						continue;}
				i++;
				expressions[j]=temp;
				temp="";
			while(i<n&&store.charAt(i)!=' ') {
				temp+=store.charAt(i++);
			}
			answers[j++]=Double.parseDouble(temp);
			temp="";
	}
			index=iter=j;
			
			read.close();}
			catch(Exception e) {System.out.println(e);}
			
		}
		public String prev() {
			expression=expressions[--iter];
			ans=answers[iter];
			return expression;
		}
		public String next() {
			expression=expressions[++iter];
			ans=answers[iter];
			return expression;
		}
	
	}


