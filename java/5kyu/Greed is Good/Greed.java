public class Greed{

    public static int greedy(int[] dice) {
      int nums[] = new int[6];
      for (int d : dice){
        nums[d-1]++;
      }
      return nums[0]/3*1000 + nums[0]%3*100 
        + nums[1]/3*200 
        + nums[2]/3*300 
        + nums[3]/3*400 
        + nums[4]/3*500 + nums[4]%3*50 
        + nums[5]/3*600;
    }
  }