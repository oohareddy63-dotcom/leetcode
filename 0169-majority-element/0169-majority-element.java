class Solution{
    public static int majorityElement(int num[]){
    int maj=num[0];
    int votes=1; 
    for(int i=1;i<num.length;i++){
        if(votes==0){
        maj=num[i];
        votes++; 
    }else if(maj==num[i]){
        votes++;
    }else{
        votes--;
    }
    }
    return maj;
    }
}

