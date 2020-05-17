import java.lang.reflect.Array;

public class NumberZooPatrol {
    public static void main(String[] args) {
        System.out.println( findMissingNumber(new int[] {30,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}));
    }

    public static int findMissingNumber(int[] numbers) {
        int cont=1;

        while(cont<=numbers.length && contains(numbers,cont)){
            cont++;
        }

        return cont;
    }

    public static boolean contains(int[] numbers, int number){
        int size=numbers.length;

        for(int i=0;i<size-1;i++){
            if(numbers[i]==number){
                return true;
            }

            for(int j=size-1;j>=i;j--){
                if(numbers[j]==number){
                    return true;
                }
            }

        }
        return false;
    }
}
