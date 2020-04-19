package numbers;

public class MaxArea {
	public int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = (j - i) * Math.min(height[i], height[j]);
				if (area > maxArea)
					maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		MaxArea area = new MaxArea();
		System.out.println(area.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}
}
