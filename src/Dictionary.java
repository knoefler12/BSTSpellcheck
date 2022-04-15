//101398801
public class Dictionary {
    private BNode root;
    private int count;

    public Dictionary(){
        count=0;
        root=null;
    }

    public boolean add(String word, String meaning){
        word=word.toLowerCase();
        if(!exists(word)){
            WordInfo wordInfo = new WordInfo(word, meaning);
            BNode newNode = new BNode(wordInfo);
            if(root==null){
                root=newNode;
                count++;
                return true;
            }
            BNode parent, current;
            current=parent=root;
            while(current!=null){
                parent=current;
                if(word.compareTo(current.getData().getWord())<0){
                    current=current.getLeft();
                }
                else{
                    current=current.getRight();
                }
            }
            if(word.compareTo(parent.getData().getWord())<0){
                parent.setLeft(newNode);
            }
            else{
                parent.setRight(newNode);
            }
            count++;
            return true;
        }
        else{
            System.out.println("Word already exists!");
            System.out.println("Word not added!");
            return false;
        }
    }

    public boolean delete(String word){
        word=word.toLowerCase();
        if(exists(word)){
            root = deleteRecursive(root,word);
            System.out.println("Word deleted!");
            count--;
            return true;
        }
        System.out.println("Word not found!");
        return false;
    }

    public BNode deleteRecursive(BNode root, String word){
        if(root==null)return root;

        if(word.compareTo(root.getData().getWord())<0){
            root.setLeft(deleteRecursive(root.getLeft(),word));
        }
        else{
            if(word.compareTo(root.getData().getWord())>0){
                root.setRight(deleteRecursive(root.getRight(),word));
            }
            else{
                //Found node to be deleted
                if(root.getLeft()==null){
                    return root.getRight();
                }
                if(root.getRight()==null){
                    return root.getRight();
                }
                BNode inOrderSuccessor = root.getRight();
                while(inOrderSuccessor.getLeft()!=null){
                    inOrderSuccessor=inOrderSuccessor.getLeft();
                }
                root.setData(inOrderSuccessor.getData());
                root.setRight(deleteRecursive(root.getRight(),inOrderSuccessor.getData().getWord()));
            }
        }
        return root;
    }

    private WordInfo search(String word){
        BNode current=root;
        word = word.toLowerCase();
        if(root==null) return null;
        while(current!=null&&word.compareTo(current.getData().getWord())!=0){
            if(word.compareTo(current.getData().getWord())<0){
                current=current.getLeft();
            }
            else{
                current=current.getRight();
            }
        }
        if(current==null) return null;
        return current.getData();
    }

    public String getMeaning(String word){
        try {
            return search(word).getMeaning();
        }catch (NullPointerException e){
            return null;
        }
    }

    public boolean exists(String word){
        if(search(word)==null) return false;
        return true;
    }

    public int getCount(){
        return count;
    }

    public void printDictionary(){
        dictionaryInOrder(root);
    }

    public void dictionaryInOrder(BNode current){
        if(current==null) return;
        dictionaryInOrder(current.getLeft());
        System.out.println(current.getData()+" ");
        dictionaryInOrder(current.getRight());
    }

    public void printWordList(){
        wordInOrder(root);
    }

    private void wordInOrder(BNode current){
        if(current==null) return;
        wordInOrder(current.getLeft());
        System.out.println(current.getData().getWord()+" ");
        wordInOrder(current.getRight());
    }

    public void loadSortedArrayToBST(WordArray wordList){
        root=sortedArrayToBST(wordList,0, wordList.getCount()-1);
    }

    private BNode sortedArrayToBST(WordArray wordList, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        WordInfo wordInfo = new WordInfo(wordList.getWord(mid),"undefined");
        BNode newBnode = new BNode(wordInfo);
        newBnode.setLeft(sortedArrayToBST(wordList,start,mid-1));
        newBnode.setRight(sortedArrayToBST(wordList,mid+1,end));

        count++;
        return newBnode;
    }
}
