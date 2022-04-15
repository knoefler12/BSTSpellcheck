//101398801
public class BNode {
    private WordInfo data;
    private BNode left, right;

    public BNode(WordInfo data){
        this.data=data;
        left=right=null;
    }

    public WordInfo getData() {
        return data;
    }

    public void setData(WordInfo data) {
        this.data = data;
    }

    public BNode getLeft() {
        return left;
    }

    public void setLeft(BNode left) {
        this.left = left;
    }

    public BNode getRight() {
        return right;
    }

    public void setRight(BNode right) {
        this.right = right;
    }
}

