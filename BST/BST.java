class TreeNode
{
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TreeStruct
{
    public TreeNode head;

    public TreeNode insertNode(TreeNode treeNode, int data)
    {
        if(treeNode == null)
        {
            treeNode = new TreeNode(data);
        }
        else if(treeNode.data > data)
        {
            treeNode.left = this.insertNode(treeNode.left, data);
        }
        else if(treeNode.data < data)
        {
            treeNode.right = this.insertNode(treeNode.right, data);
        }
        else
        {
            System.out.println("Given data already exists in the tree");
        }

        return treeNode;
    }

    public void preOrderTraversal(TreeNode treeNode)
    {
        if(treeNode == null)
            return;

        System.out.println(treeNode.data);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    public void postOrderTraversal(TreeNode treeNode)
    {
        if(treeNode == null)
            return;

        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.println(treeNode.data);
    }

    public void inOrderTraversal(TreeNode treeNode)
    {
        if(treeNode == null)
            return;

        inOrderTraversal(treeNode.left);
        System.out.println(treeNode.data);
        inOrderTraversal(treeNode.right);
    }

    public TreeStruct()
    {
        this.head = null;
    }
}

class BST
{
    public static void main(String[] args) 
    {
        TreeStruct tree = new TreeStruct();

        tree.head = tree.insertNode(tree.head,0);
        tree.head = tree.insertNode(tree.head,2);
        tree.head = tree.insertNode(tree.head,7);
        tree.head = tree.insertNode(tree.head,3);

        System.out.println("PreOrder Traversal");
        tree.preOrderTraversal(tree.head);
        System.out.println();

        System.out.println("PostOrder Traversal");
        tree.postOrderTraversal(tree.head);
        System.out.println();

        System.out.println("InOrder Traversal");
        tree.inOrderTraversal(tree.head);
        System.out.println();
    }
}