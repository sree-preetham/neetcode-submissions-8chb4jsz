class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(String token : tokens){
            int num1, num2, result, num;
            switch(token){
                case "+" :
                    num1 = st.pop();
                    num2 = st.pop();
                    result = num2 + num1;
                    st.push(result);
                    break;
                case "-":
                    num1 = st.pop();
                    num2 = st.pop();
                    result = num2 - num1;
                    st.push(result);
                    break;
                case "/":
                    num1 = st.pop();
                    num2 = st.pop();
                    result = num2/num1;
                    st.push(result);
                    break;
                case "*":
                    num1 = st.pop();
                    num2 = st.pop();
                    result = num2 * num1;
                    st.push(result);
                    break; 
                default :
                    num = Integer.parseInt(token);
                    st.push(num);
                    break;

            }
        }
        return st.peek();
    }
}