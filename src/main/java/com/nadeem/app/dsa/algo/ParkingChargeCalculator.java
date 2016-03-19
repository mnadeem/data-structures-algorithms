package com.nadeem.app.dsa.algo;

import java.util.List;

public class ParkingChargeCalculator {
	
	private IntervalTreeAVL<Integer> tree;

	public ParkingChargeCalculator(List<Interval> priceRules) {
		tree = new IntervalTreeAVL<Integer>();
		for (Interval interval : priceRules) {
			tree.insert(interval.start, interval.end, interval.weekDayPrice);
		}
	}

	public static class Interval { 
		public int start;
		public int end;
		public int weekDayPrice;
		public int weekEndPrice;
		
		public Interval(int start, int end, int weekDayPrice, int weekEndPrice) {
			this.start = start;
			this.end = end;
			this.weekDayPrice = weekDayPrice;
			this.weekEndPrice = weekEndPrice;
		}
	}

	public int weekDayCharge(int hours) {
		return this.tree.getSum(0, hours);
	}

	public int weekEndCharge(int hours) {
		return this.tree.getSum(0, hours);
	}
	
	private static class IntervalTreeAVL<T extends Integer>{
	    private static class TreeNode<T>{
	        private T low;
	        private T high;
	        private TreeNode<T> left;
	        private TreeNode<T> right;
	        private int sum;
	        private int height;
	        private TreeNode(T l, T h, int sum){
	            this.low=l;
	            this.high=h;
	            this.sum=sum;
	            this.height=1;
	        }
	        
	        @Override
	        public String toString() {
	        	// TODO Auto-generated method stub
	        	return String.format("(%d,%d) %d", low, high, sum);
	        }
	    }
	    private TreeNode<T> root;
	    public void insert(T l, T h, int val){
	        root=insert(root, l, h, val);
	    }
	    private TreeNode<T> insert(TreeNode<T> node, T l, T h, int val){
	        if(node==null){
	            return new TreeNode<T>(l, h, val);
	        }
	        else{
	            int k=((Comparable)node.low).compareTo(l);
	            if(k>0){
	                node.left=insert(node.left, l, h, val);
	            }
	            else{
	                node.right=insert(node.right, l, h, val);
	            }
	            node.height=Math.max(height(node.left), height(node.right))+1;
	            updateSum(node);
	            int hd = heightDiff(node);
	            if(hd<-1){
	                int kk=heightDiff(node.right);
	                if(kk>0){
	                    node.right=rightRotate(node.right);
	                    return leftRotate(node);
	                }
	                else{
	                    return leftRotate(node);
	                }
	            }
	            else if(hd>1){
	                if(heightDiff(node.left)<0){
	                    node.left = leftRotate(node.left);
	                    return rightRotate(node);
	                }
	                else{
	                    return rightRotate(node);
	                } 
	            }
	            else;
	        }
	        return node;
	    }
	    private TreeNode<T> leftRotate(TreeNode<T> n){
	        TreeNode<T> r =  n.right;
	        n.right = r.left;
	        r.left=n;
	        n.height=Math.max(height(n.left), height(n.right))+1;
	        r.height=Math.max(height(r.left), height(r.right))+1;
	        updateSum(n);
	        updateSum(r);
	        return r;
	    }
	    private TreeNode<T> rightRotate(TreeNode<T> n){
	        TreeNode<T> r =  n.left;
	        n.left = r.right;
	        r.right=n;
	        n.height=Math.max(height(n.left), height(n.right))+1;
	        r.height=Math.max(height(r.left), height(r.right))+1;
	        updateSum(n);
	        updateSum(r);
	        return r;
	    }
	    private int heightDiff(TreeNode<T> a){
	        if(a==null){
	            return 0;
	        }
	        return height(a.left)-height(a.right);
	    }
	    private int height(TreeNode<T> a){
	        if(a==null){
	            return 0;
	        }
	        return a.height;
	    }
	    private int updateSum(TreeNode<T> n){
	        if(n.left==null && n.right==null){
	            return n.sum;
	        }
	        else if(n.left==null){
	        	 return n.right.sum;
	        }
	        else if (n.right == null){
	        	 return n.left.sum;
	        }
	        n.sum = updateSum(n.left) + updateSum(n.right);
	        return n.sum;
	    }
	    
	    int getSum(T low, T high) {
	    
	    	
	    	return doGetSum(root, low, high);
	    }

	private int doGetSum(TreeNode<T> node, T low, T high) {
		
			if (node == null) {
				return 0;
			}
			if ( (node.low.compareTo(low) ==0 || node.low.compareTo(low) > 0)  && (node.high.compareTo(high) ==0 || node.high.compareTo(high) < 0)) {
				return node.sum;
			}
			
			if ( node.low.compareTo(high) > 0  && node.high.compareTo(low) < 0) {
				return 0;
			}
			return doGetSum(node.left, low, high) +  doGetSum(node.right, low, high);
		}
	TreeNode intervalSearch(T t1){
	        TreeNode<T> t = root;
	        while(t!=null && !isInside(t, t1)){
	            if(t.left!=null){
	                    if(((Comparable)t.left.sum).compareTo(t1)>0){
	                    t=t.left;
	                }
	                else{
	                    t=t.right;
	                }
	            }
	            else{
	                t=t.right;
	            }
	        }
	        return t;
	    }
	    private boolean isInside(TreeNode<T> node, T t){
	        Comparable cLow=(Comparable)node.low;
	        Comparable cHigh=(Comparable)node.high;
	        int i = cLow.compareTo(t);
	        int j = cHigh.compareTo(t);
	        if(i<=0 && j>=0){
	            return true;
	        }
	        return false;
	    }
	}
}
