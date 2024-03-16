public class WU01162020{
public static void main(String[] args){
double a = .25;
double b = .25;
double c = .25;
double d = .25;
double countA = 0;
double countB = 0;
double countC = 0;
double countD = 0;
double e = Math.random();
System.out.println(e);
if(e < a)
   System.out.println("A");
else if(e < (a+b))
   System.out.println("B");
else if(e < (a+b+c))
   System.out.println("C");
else
   System.out.println("B");
// for(int a = 0; a < 1000; a++){
// double e = Math.random();
// System.out.println(e);
// if(e < a)
//    countA++;
// else if(e < (a+b))
//    countB++;
// else if(e < (a+b+c))
//    countC++;
// else
//    countD++;
// }
// System.out.println("A: " + countA);
// System.out.println("B: " + countB);
// System.out.println("C: " + countC);
// System.out.println("D: " + countD);

}

}