package search.exercises;

import arrays.SliceArray;

public class MinimumAndMaxmimum {

	static class Data {
		int min;
		int max;

		public Data(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		public Data() {
			super();
		}
	}

	public static Data minAndMax(int[] array) {
		if (array.length == 0) {
			return null;
		} else if (array.length == 2) {
			Data data;
			if (array[0] < array[1])
				data = new Data(array[0], array[1]);
			else
				data = new Data(array[1], array[0]);
			return data;
		} else if (array.length == 1) {
			return new Data(array[0], array[0]);
		} else {
			int middle = array.length / 2;
			Data data1 = minAndMax(SliceArray.slice(array, 0, middle));
			Data data2 = minAndMax(SliceArray.slice(array, middle, array.length));
			Data data = new Data(Math.min(data1.min, data2.min), Math.max(data1.max, data2.max));
			return data;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 2,4,5,6,-1,19};
		Data data = minAndMax(array);
		System.out.println(data.min + "," + data.max);
	}
}
