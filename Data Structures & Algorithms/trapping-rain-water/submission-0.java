class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int area = 0;
        for(int i = 0;i<height.length;i++){
            int curr = height[i];
            if(st.empty()){
                st.push(i);
            } 
            else{
                int base = height[st.peek()];
                if(curr < base) st.push(i);
                else{
                    while(curr > base){
                        st.pop();
                        if(st.empty()) break;
                        int top = st.peek();
                        int ht = Math.min(height[top], curr) - base;
                        int width = i - top - 1;
                        area = area + (ht * width);
                        base = height[top];
                    }
                    st.push(i);
                }
            }
        }
        return area;
    }
}