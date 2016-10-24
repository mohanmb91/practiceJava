package BinarySearchTree;

public class EmptyBst<D extends Comparable> implements Tree<D>{

	public EmptyBst(){
		
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int cardinality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean member(D elt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NonEmptyBST<D> add(D elt) {
		// TODO Auto-generated method stub
		return new NonEmptyBST<D>(elt);
	}

}
