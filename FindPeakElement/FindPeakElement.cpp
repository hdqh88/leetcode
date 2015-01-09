//=====================================================================================================================
//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -∞.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//click to show spoilers.
//Note:
//Your solution should be in logarithmic complexity.
//Credits:
//Special thanks to @ts for adding this problem and creating all test cases.
//=======================================================================================================================

class Solution {
public:
    int findPeakElement(const vector<int> &num) {
    int startPt = 0;
    int endPt = num.size() -1;
    int midPt;

    if(endPt < 0)
    { // empty list
        return -1;
    }
    else
    {
        while(startPt < endPt)
        { // binary search, for each iteration, make sure num[startPt-1]< num[startPt] & num[endPt] > num[endPt+1] is true  
            midPt = (endPt + startPt)/2;
            if(num[midPt] < num[midPt + 1])
            { 
                startPt = midPt + 1;
            }
            else
            {
                endPt = midPt;
            }
        }

        return startPt;

    }


}
};
