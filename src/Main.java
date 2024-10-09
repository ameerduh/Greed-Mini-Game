import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static String black="\u001b[30m";
	static String red="\u001b[31m";
	static String green="\u001b[32m";
	static String yellow="\u001b[33m";
	static String blue="\u001b[34m";
	static String magneta="\u001b[35m";
	static String cyan="\u001b[36m";
	static String Bright_Blue="\u001b[34;1m";
	static String reset="\u001b[0m";
	
	static String back="\u001b[47;1m";
	
	static Scanner scanner	= new Scanner(System.in);
	
	static void play() throws IOException {

		
		File file = new File("records.txt");                //file handling
		
		
		
		
		
		
		
		Random random = new Random();
		
		
		System.out.print("Enter the Width: ");        //getting the width from user
		final int x = scanner.nextInt();	
		final int y = 3*x;
		System.out.println();
		
		String[][] num = new String[x][y];                                                //an array of numbers according to the project
		
		
		int i = 0 ,j = 0;                                                                //indexes of Matrix
		
		while(i < x) {										       //catching the random numbers							
			while(j < y) {		 
				num[i][j] = Integer.toString(random.nextInt(9)+1);
				j++;
			}
			i++;
			j = 0;
		}
		
		i = 0;								                              //resetting the indexes
		j = 0;
		
		int a = x/2;											         //"@" sign location Axis
		int b = y/2;										         
	    num[a][b] = "@"; 											//implementing the "@" sign
			
		
		int t; 												 //index of movement
		int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0;
		
		int score = 0; 									           //initial score
		boolean W=true ,S=true,A=true,D=true,Q=true,E=true,Z=true,C=true;           //state of each 8 movements  
		
		String choice;                                   //chosen movement
		
		Date thisDate = new Date();	
		
		SimpleDateFormat minute = new SimpleDateFormat("mm");				//catching minutes
		int Nminute = Integer.parseInt(minute.format(thisDate));
		
		
		SimpleDateFormat second = new SimpleDateFormat("ss");
		int Nsecond = Integer.parseInt(second.format(thisDate));	//catching seconds
		Nsecond=Nsecond+Nminute*60;
		
   		while(true) {                                                                  	          //main process of presenting remains of the Matrix
   			
			if(a == 0) W=false;											//Up movement check-ups
			if(a-1<0) W=false;
			else if(num[a-1][b].equals(" ")) W=false;
			else {t1 = Integer.parseInt(num[a-1][b]); if(t1>a) W=false;}
			
			
			if(a == (x-1)) S=false;											//Down movement check-ups
			if(a+1>x-1) S=false;
			else if(num[a+1][b].equals(" "))S=false;
			else {t2 = Integer.parseInt(num[a+1][b]); if(t2 > (x-(a+1))) S=false;}
			
			
			if(b==0) A=false;												//Left movement check-ups
			if(b-1<0) A=false;
			else if(num[a][b-1].equals(" ")) A=false;
			else {t3 = Integer.parseInt(num[a][b-1]); if(t3 > b) A=false;}
			
			
			if(b==(y-1)) D=false;											//Right movement check-ups
			if(b+1>y-1) D=false;
			else if(num[a][b+1].equals(" ")) D=false;
			else {t4 = Integer.parseInt(num[a][b+1]); if(t4 > (y-1)-b) D=false;}
			
			
			if(b==0 || a==0) Q=false;										//Up-Left movement check-ups
			if(a-1<0 || b-1<0) Q=false;
			else if(num[a-1][b-1].equals(" ")) Q=false;
			else {t5 = Integer.parseInt(num[a-1][b-1]); if(t5 > Integer.min(a,b)) Q=false;}
			
			
			if(a==0 || b==(y-1)) E=false;									      //Up-Right movement check-ups
			if(a-1<0 || b+1>y-1) E=false;
			else if(num[a-1][b+1].equals(" ")) E=false;
			else {t6 = Integer.parseInt(num[a-1][b+1]); if(a-t6<0 || b+t6>y-1) E=false;}
			
			
			if(b==0 || a==(x-1)) Z=false;									      //Down-Left movement check-ups
			if(a+1>x-1 || b-1<0) Z=false;
			else if(num[a+1][b-1].equals(" ")) Z=false;
			else {t7 = Integer.parseInt(num[a+1][b-1]); if(a+t7>x-1 || b-t7<0) Z=false;}
			
			
			if(b==y-1 || a==x-1) C=false;									     //Down-Right movement check-ups
			if(b+1>y-1 || a+1>x-1) C=false;      
			else if(num[a+1][b+1].equals(" ")) C=false;
			else {t8 = Integer.parseInt(num[a+1][b+1]); if(a+t8>x-1 || b+t8>y-1)C=false;}
			
			System.out.println("------------------------------------------------------------------------------------------------------------");
			  
   			System.out.println();
   			
   			while(i<x) {											       //printing the remains of the Matrix with colorful numbers and backgrounds
   				while(j<y) {
   					
   					t=1;
   				
   					if(W && j==b && i<a && i>=a-t1) System.out.print(back);							//background color Check-ups
   					if(S && j==b && i>a && i<=a+t2) System.out.print(back);
   					if(A && i==a && j<b && j>=b-t3) System.out.print(back);
   					if(D && i==a && j>b && j<=b+t4)  System.out.print(back);
   					
   					
   					
   					if(Q) {
   						while(t<=t5) {
   							if(a-t==i && b-t==j) System.out.print(back);
   							t++;
   						}
   						t=1;
   					}
   					
   					if(E) {
   						while(t<=t6) {
   							if(a-t==i && b+t==j) System.out.print(back);
   							t++;
   						}
   						t=1;
   					}
   					
   					if(Z) {
   						while(t<=t7) {
   							if(a+t==i && b-t==j) System.out.print(back);
   							t++;
   						}
   						t=1;
   					}
   					
   					if(C) {
   						while(t<=t8) {
   							if(a+t==i && b+t==j) System.out.print(back);
   							t++;
   						}
   						t=1;
   					}
   					
   					
   					
   					if(num[i][j].equals("@"))System.out.print(num[i][j]+" "+reset);								//numbers' color check-up
   					else if(num[i][j].equals(" ")) System.out.print(num[i][j]+" "+reset);
   					
   					else if(Integer.parseInt(num[i][j])==1) System.out.print(black+num[i][j]+" "+reset);
					else if(Integer.parseInt(num[i][j])==2)System.out.print(red+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==3)System.out.print(green+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==4)System.out.print(yellow+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==5)System.out.print(blue+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==6)System.out.print(magneta+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==7)System.out.print(cyan+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==8)System.out.print(Bright_Blue+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==9)System.out.print(num[i][j]+" "+reset);
   					
   					
   					
   					
   					
   					j++;
   				}
   				System.out.println();
   				j=0;
   				i++;
   			}
   			i=0;
			
			if(W==false && S==false && A==false && D==false && Q==false && E==false && Z==false && C==false) break;     //Ending point condition
			
			System.out.println("Current Score: "+score); //printing score of every moment
			System.out.println("[W to up]..[S to down]..[A to left]..[D to right]..[Q to up-left]..[E to up-right]..[Z to down-left]..[C to down-right]");
			choice = scanner.next().toUpperCase();      //accepting both capital and small letters
	
			
			if(choice.equals("W")) {									//moving UP
				if(W) {
						t = Integer.parseInt(num[a-1][b]);
						num[a][b]=" ";
							
						while(i < t) {
							a--;
							
							if(!num[a][b].equals(" ")) {
								num[a][b]=" "; 
								score++;
							}
							
							i++;
						}
						i=0;
						num[a][b]="@";
						W=S=A=D=Q=E=Z=C=true;
				}
		
			}
		
		
		
			
			else if(choice.equals("S")) {									//moving DOWN
				if(S) {
						t = Integer.parseInt(num[a+1][b]);
						num[a][b]=" ";
						
						while(i < t) {
							a++;
							
							if(!num[a][b].equals(" ")) {
								num[a][b]=" "; 
								score++;
								}
							
							i++;
						  }
						
						i=0;
						num[a][b]="@";
						W=S=A=D=Q=E=Z=C=true;
					}
				}
		
		
		
		
		
				else if(choice.equals("A")) {								//moving LEFT
					if(A) {
							t = Integer.parseInt(num[a][b-1]);
							num[a][b]=" ";
							
							while(i < t) {
								b--;
								
								if(!num[a][b].equals(" ")) {
									num[a][b]=" ";
									score++;
								}
								
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true;	
					}
				}
		
		
		
		
		
				else if(choice.equals("D")) {								//moving RIGHT
					if(D) {
							t = Integer.parseInt(num[a][b+1]);
							num[a][b]=" ";
							
							while(i < t) {
								b++;
								
								if(!num[a][b].equals(" ")) {
									num[a][b]=" "; 
								    score++;
								}
								
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true;
					}
				}
			
			
			
			
			
			
			
				else if(choice.equals("Q")) {							//moving UP-LEFT
					if(Q) {
							t = Integer.parseInt(num[a-1][b-1]);
						    num[a][b]=" ";
						    
							while(i < t) {
								a--;
								b--;
								
								if(!num[a][b].equals(" ")) {
									num[a][b]=" "; 
									score++;
									}
								
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true;
							
					}
			
				}
			
			
			
			
			
			
			
				else if(choice.equals("E")) {							//moving UP-RIGHT
					if(E) {
							t = Integer.parseInt(num[a-1][b+1]);
							num[a][b]=" ";
							
							while(i < t) {
								a--;
								b++;
								if(!num[a][b].equals(" ")) {
									num[a][b]=" "; 
									score++;
									}
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true; 
							
							
					}
			
				}
				
				
				
				else if(choice.equals("Z")) {								//moving DOWN-LEFT
					if(Z) {
							t = Integer.parseInt(num[a+1][b-1]);
							num[a][b]=" ";
							while(i < t) {
								a++;
								b--;
								if(!num[a][b].equals(" ")) {
									num[a][b]=" ";
									score++;
									}
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true; 
						
							
					}
			
				}
			
			
			
			
			
			
			
				else if(choice.equals("C")) {	                                        //moving DOWN-RIGHT
					if(C) {
							t = Integer.parseInt(num[a+1][b+1]);
							num[a][b]=" ";
							while(i < t) {
								a++;
								b++;
								if(!num[a][b].equals(" ")) {
									num[a][b]=" ";
									score++;
									}
								i++;
							}
							i=0;
							num[a][b]="@";
							W=S=A=D=Q=E=Z=C=true; 	
					}
			
				}
		
				
   	}
   		System.out.println("------------------------------------------------------------------------------------------------------------");
   		
   		System.out.println();
   		
			while(i<x) {                                                          //the final remains of the Matrix
				while(j<y) {
					if(num[i][j].equals("@"))System.out.print(num[i][j]+" ");
					else if(num[i][j].equals(" ")) System.out.print(num[i][j]+" ");
					else if(Integer.parseInt(num[i][j])==1)System.out.print(black+num[i][j]+" "+reset);
					else if(Integer.parseInt(num[i][j])==2)System.out.print(red+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==3)System.out.print(green+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==4)System.out.print(yellow+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==5)System.out.print(blue+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==6)System.out.print(magneta+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==7)System.out.print(cyan+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==8)System.out.print(Bright_Blue+num[i][j]+" "+reset);
   					else if(Integer.parseInt(num[i][j])==9)System.out.print(reset+num[i][j]+" "+reset);
   					
					
					j++;
				}
				System.out.println();
				j=0;
				i++;
			}
			i=0;	
			
			Date thendate = new Date();	
			int fminute = Integer.parseInt(minute.format(thendate));			 //catching final minutes
			int fsecond = Integer.parseInt(second.format(thendate));			//catching final seconds
			fsecond=fsecond+fminute*60;
			
			System.out.print("Time of gameplay: "); 
			System.out.print((fsecond-Nsecond)/60);
			System.out.print(":");
			System.out.println((fsecond-Nsecond)%60);
			
			
			
			System.out.println("Game Is Over!");
			System.out.println("Your Final Score: "+score);               //the final Score
			
			scanner.nextLine();
			System.out.println("What's your name? ");                    //catching user's name
			String name = scanner.nextLine();
					
			FileWriter writer = new FileWriter("records.txt", true);	//writing on the file	
			writer.write(name+" "+score+" "+(fsecond-Nsecond)/60+":"+(fsecond-Nsecond)%60+"\n");										//writing name + score + time
			writer.close();
	
	
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		a: while(true) {
			System.out.println("------------------------------------------------");
			System.out.println("1:play\n"+"2:exit");
			int c = scanner.nextInt();
			scanner.nextLine();
			if (c==1) play();
			else break a;
		}
	}
	
	
 }	
	
	
	

