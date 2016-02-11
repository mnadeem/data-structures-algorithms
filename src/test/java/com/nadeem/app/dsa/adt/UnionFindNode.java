package com.nadeem.app.dsa.adt;

public class UnionFindNode<T extends Comparable<? super T>> {

	private T data;
	int rank;
	private UnionFindNode<T> parent;

	public UnionFindNode(T newData) {
		this.data = newData;
		this.rank = 0;
		this.parent = this;
	}

	public UnionFindNode<T> findRepresentative(T item) {
		if (parent != this) {
			this.parent = parent.findRepresentative(item);
		}
		return parent;
	}

	public UnionFindNode<T> union(T x, T y) {
		UnionFindNode<T> xRep = this.findRepresentative(x);
		UnionFindNode<T> yRep = this.findRepresentative(y);
		
		UnionFindNode<T> result;
		
		if (xRep.rank < yRep.rank) {
			xRep.parent = yRep;
			result = yRep;
		} else {
			if (xRep.rank == yRep.rank) {
				xRep.rank++;
			}
			yRep.parent = xRep;
			result = xRep;
		}
		return result;		
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getData());
	}
}
