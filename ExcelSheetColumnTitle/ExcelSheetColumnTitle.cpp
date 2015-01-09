//===========================================================================================================================
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//For example:
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//===========================================================================================================================

class Solution {
public:
    string convertToTitle(int n) {
    string str;  // To store result (Excel column name)

    while (n>0)
    {
        // Find remainder
        int rem = n%26;
 
        // If remainder is 0, then a 'Z' must be there in output
        if (rem==0)
        {
            str += 'Z';
            n = (n/26)-1;
        }
        else // If remainder is non-zero
        {
            str+= (rem-1) + 'A';
            n = n/26;
        }
    }

    // Reverse the string and print result
        string result;  
        for(int i=str.size()-1;i>=0;i--){  
            result+=str[i];  
        }  
        return result;  
    }
};
