public class Rule{
private double threshold;
private boolean leaf;
private String final_decision;
public Rule(double treshold){
threshold = treshold;
leaf = false;
final_decision = "";
}
public Rule(String s){
   threshold = 0;
   leaf = true;
   final_decision = s;

}

public String decide(double input){
if(leaf)
   return final_decision;
else{
   if(input < threshold)
      return null;
   else return "";
}
}


}