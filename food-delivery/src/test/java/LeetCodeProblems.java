import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LeetCodeProblems {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String s:tokens){

            if(s.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            }
            else if(s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(a-b);
            }
            else if(s.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }
            else if(s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else{
                st.push(Integer.parseInt(s));
            }

        }

        return st.pop();
    }

    @Test
    public void evalRPNTest(){

        Assert.assertEquals(evalRPN(new String[]{"2","1","+","3","*"}),9);
        Assert.assertEquals(evalRPN(new String[]{"4","13","5","/","+"}),6);
        Assert.assertEquals(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}),22);
    }
}
