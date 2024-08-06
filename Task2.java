class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        for(String str:arr){
            if(duplicate.contains(str)){
                continue;
            }
            if(distinct.contains(str)){
                distinct.remove(str);
                duplicate.add(str);
            }else{
                distinct.add(str);
            }
        }
            for(String str : arr){
                if(!duplicate.contains(str)){
                    k--;
                }
                if(k==0){
                    return str;
                }
            }
            return"";
        }
    }


    
