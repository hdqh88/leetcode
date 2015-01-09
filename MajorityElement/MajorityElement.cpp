//==========================================================================================================================
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.
//
//==========================================================================================================================

#include <iostream>
#include <vector>


class Solution {
public:
    int majorityElement(vector<int> &num) {
        
    int maj_index = 0, count = 1;
    int i;
    for(i = 1; i < num.size(); i++)
    {
        if(num[maj_index] == num[i])
            count++;
        else
            count--;
        if(count == 0)
        {
            maj_index = i;
            count = 1;
        }
    }
    return num[maj_index];
}
  

};
