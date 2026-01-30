public class TwoSum{
	
	private static int[] arr = {1, -3, 12, -9, -1, 9, -12, 4, 7, 54, 34, 65, -65};
	private static int[][] result = new int[arr.length][2];
	private static int founds;
	
	public static void main(String[] args){
		int rIndex = 0;
		
		for(int i = 0; i < arr.length; i++){
			int curr = arr[i];
			for(int j = 0; j < arr.length; j++){
				if((curr + arr[j]) == 0){
					
					result[rIndex++] = new int[]{curr, arr[j]};
					founds++;
					break;
				}
			}
		}
		
		result = resize();
		
		int[][] newResult = new int [founds / 2][2];
		int nIndex = 0;
		
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < newResult.length; j++){
				if(Math.abs(result[nIndex][0]) != Math.abs(newResult[j][0])){
					newResult[nIndex] = result[nIndex];
					break;
				}
			}
		}
		
		for(int i = 0; i < founds / 2; i++){
			System.out.println(result[i][0] + " <-> " + result[i][1]);
		}
	}
	
	private static int[][] resize(){
		int[][] newArr = new int[founds][2];
		System.arraycopy(result, 0, newArr, 0, founds);
		return newArr;
	}
}