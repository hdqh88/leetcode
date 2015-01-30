//============================================================================
// Given n non-negative integers a1, a2, ..., an, where each represents a
// point at coordinate (i, ai). n vertical lines are drawn such that the two
// endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
// together with x-axis forms a container, such that the container contains
// the most water.
//
// Note: You may not slant the container.
// 
// Complexity:
// O(n) time
//============================================================================

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int maxArea(vector<int> &height) {
        int i = 0, j = height.size() - 1, res = 0;
        while (i < j) {
            res = max(res, min(height[i], height[j])*(j - i));
            if (height[i] <= height[j]) {
                do { i++; } while (i < j && height[i] <= height[i - 1]);
            }
            else {
                do { j--; } while (i < j && height[j] <= height[j + 1]);
            }
        }
        return res;
    }
    
    
    
    // Hao Ding
    int maxArea2(vector<int> &height){
        if(height.size() < 2)
            return 0;
        int left = 0;
        int right = height.size() - 1;
        int area_max = INT_MIN;
        while(left < right){
            int area = min(height[right], height[left]) * (right - left);
            area_max = max(area_max, area);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return area_max;
    }
};

int main() {
    return 0;
}
