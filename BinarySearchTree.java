
public class BinarySearchTree <E extends Comparable<E>>{
	private BinaryTree<E> root;
	
	public BinarySearchTree (BinaryTree<E> root) {
		this.root = root;
	}
	
	public boolean add (E value) {
		return add(value, root);
	}
	
	public boolean add(E value, BinaryTree<E> tree) {
		if (tree == null) {
			tree = new BinaryTree<E>(value);
			return true;
		}
		
		if (value != null) {
			if (value.compareTo(tree.value) > 0) {
				if (tree.right() == null) {
					tree.setRight(new BinaryTree<E> (value));
					return true;
				}
				return add(value, tree.right());
			}
			else if (value.compareTo(tree.value) < 0){
				if (tree.left() == null) {
					tree.setLeft(new BinaryTree<E> (value));
					return true;
				}
				return add(value, tree.left());
			}
			else return false;
		}
		
		return false;
	}
	
	public boolean addBinaryTree(BinaryTree<E> tree, BinaryTree<E> treeAddition) {
		if (tree == null) {
			tree = treeAddition;
			return true;
		}
		
		if (treeAddition != null) {
			if (treeAddition.getValue().compareTo(treeAddition.value) > 0) {
				if (tree.right() == null) {
					tree.setRight(treeAddition);
					return true;
				}
				return addBinaryTree(tree.right(), treeAddition);
			}
			else if (treeAddition.getValue().compareTo(treeAddition.getValue()) < 0){
				if (tree.left() == null) {
					tree.setLeft(treeAddition);
					return true;
				}
				return addBinaryTree(tree.left(), treeAddition);
			}
			else return false;
		}
		
		return false;
	}
	
	public BinaryTree<E> find (E value) {
		return find(value, root);
	}
	
	public BinaryTree<E> find (E value, BinaryTree<E> tree) {
		if (tree == null || value == null) return null;
		
		if (value.compareTo(tree.getValue()) == 0) {
			return tree;
		}
		else if (value.compareTo(tree.getValue()) < 0) {
			if (tree.left() == null) return null;
			else return find(value, tree.left());
		}
		else if (value.compareTo(tree.getValue()) > 0) {
			if (tree.right() == null) return null;
			else return find(value, tree.right());
		}
		
		return null;
	}
	
	public boolean remove (E value) {
		return remove(value, null, root);
	}
	
	public boolean remove (E value, BinaryTree<E> parent, BinaryTree<E> tree) {
		
		if (tree.getValue().equals(value)) {
			if (tree.left().height() > tree.right().height()) {
				addBinaryTree(tree, tree.right());
			}
			else {
				
			}
		}
		else {
			if (tree.left() != null && value.compareTo(tree.getValue()) < 0) {
				return remove(value, tree, tree.left());
			}
			else if (tree.right() != null && value.compareTo(tree.getValue()) > 0) {
				return remove(value, tree, tree.right());
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	
	public String toString () {
		return root.toString();
	}
}


/*
if (tree == null || tree.isLeaf()) return true;
else if (value.compareTo(tree.getValue()) < 0) {
	if (tree.left() == null) return true;
	else return remove(value, tree, parent.left());
}
else if (value.compareTo(tree.getValue()) > 0) {
	if (tree.right() == null) return true;
	else return remove(value, tree, parent.right());
}
else if (value.compareTo(tree.getValue()) == 0) {
	if (tree.left() != null && tree.right() != null) {
		if (tree.left().height() < tree.right().height()) {
			BinaryTree<E> removedNode = tree;
			if (parent.left().equals(tree)) parent.setLeft(tree.right());
			else parent.setRight(tree.right());
		}
		else {
			BinaryTree<E> removedNode = tree;
			if (parent.left().equals(tree)) parent.setLeft(tree.left());
			else parent.setRight(tree.left());
		}
	}
	else if (tree.left() != null){
		
	}
	else if (tree.right() != null) {
		
	}
	else {
		if (parent.left().equals(tree)) parent.setLeft(null);
		else parent.setRight(null);
	}
}
	
	*/