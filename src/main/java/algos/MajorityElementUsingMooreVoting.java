package algos;


class MajorityElementUsingMooreVoting{
    public static void main(String[] args){
        int[] a = {4, 4, 4, 3, 4, 1};
        int majorityElement = majorityElement(a);
        System.out.println(majorityElement);
    }


    public static int majorityElement(int[] nums){
        
       int majorityElement = findCandidate(nums);
       boolean isMajorityElement = verifyMajorityElement(nums, majorityElement);
    
       return (isMajorityElement) ? majorityElement:-1;
    }

    private static int findCandidate(int[] a){
        int majorityElement = a[0];
        int count = 1;

        for(int i=1; i < a.length; i++){
            
            int currentElement = a[i];

           if(majorityElement != currentElement){

                if(count == 1){
                    majorityElement = currentElement;
                }else{
                    count--;
                }
            }
            else{
                count++;
            }
        }

        return majorityElement;
    }

    private static boolean verifyMajorityElement(int[] a, int majorityElement){

        int count = 0;
        int majority = (a.length >> 1)+1;

        for(int element : a){

            if(element == majorityElement)
                count++;
            
            if(count >= majority)
            return true;    
        }

        

        
        return false;
    }
}