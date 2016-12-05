package tree;

public class VerifyPreorderSequenceinBST {
	public boolean verifyPreorder(int[] preorder) {
		if(preorder == null || preorder.length == 0) return true;
		return verify(preorder, 0, preorder.length - 1);
	}
	
	public boolean verify(int[] preorder, int start, int end){
		if(start >= end) return true;
		
		int bigger = -1;
		for(int i = start + 1;i <= end; i++){
			if(bigger == -1 && preorder[i] > preorder[start]) bigger = i;
			if(bigger != -1 && preorder[i] < preorder[start]) return false; 
		}
		
		if(bigger == -1){
			return verify(preorder, start + 1, end);
		}else{
			return verify(preorder, start + 1, bigger -1) && verify(preorder, bigger, end);
		}
	}
	
	public boolean verifyPreorder2(int[] preorder){
		int low = Integer.MIN_VALUE, i = -1;
		for(int p : preorder){
			if(p < low){
				return false;
			}
			while(i >= 0 && p > preorder[i]){
				low = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}
	
	public static void main(String args[]){
		int[] preorder = {10,5,3,7,20, 18, 11, 19};
		VerifyPreorderSequenceinBST vbst = new VerifyPreorderSequenceinBST();
		vbst.verifyPreorder2(preorder);
	}
}
