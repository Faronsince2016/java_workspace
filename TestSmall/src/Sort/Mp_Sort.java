package Sort;
//冒泡排序
public class Mp_Sort {
	public static void main(String[] args) {
		int[] array = {4,1,5,7,13,25,2,6};
		BubbleSort(array);
		show(array);

}
	public static int[] BubbleSort(int[] array)
	{
	    int length = array.length;
	    for (int i = 0; i <= length - 1; i++)
	    {
	        for (int j = length - 1; j > i; j--)
	        {
	            if (array[j] < array[j - 1])
	            {
	                int temp = array[j];
	                array[j] = array[j - 1];
	                array[j - 1] = temp;
	            }
	        }
	    }
	    return array;
	}
	public static void show(int[] array){
		System.out.println(array);
		
	}
}
