//==============================================================================================================================
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
//==============================================================================================================================

class BSTIterator {  
public:  
    BSTIterator(TreeNode *root) {  
        TreeNode *p = root;  
        // 沿左子树下降  
        while(p){  
            s.push(p);  
            p = p->left;  
        }//while  
    }  
    /** @return whether we have a next smallest number */  
    bool hasNext() {  
        if(!s.empty()){  
            return true;  
        }//if  
        return false;  
    }  
  
    /** @return the next smallest number */  
    int next() {  
        TreeNode *p = NULL;  
        // 出栈  
        p = s.top();  
        s.pop();  
        int val = p->val;  
        // 转向右子树  
        if(p->right){  
            p = p->right;  
            // 沿左子树下降  
            while(p){  
                s.push(p);  
                p = p->left;  
            }//while  
        }//if  
        return val;  
    }  
private:  
    stack<TreeNode*> s;  
};  


class BSTIterator {  
stack<TreeNode *> myStack;  
public:  
    BSTIterator(TreeNode *root) {  
        pushAll(root);  
    }  
  
    /** @return whether we have a next smallest number */  
    bool hasNext() {  
        return !myStack.empty();  
    }  
  
    /** @return the next smallest number */  
    int next() {  
        TreeNode *tmpNode = myStack.top();  
        myStack.pop();  
        pushAll(tmpNode->right);  
        return tmpNode->val;  
    }  
  
private:  
    void pushAll(TreeNode *node) {  
        for (; node != NULL; myStack.push(node), node = node->left);  
    }  
};  
