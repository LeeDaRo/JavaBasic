package day0614;
import util.ArrayUtil;

public class Ex01ArrayUtil {
    public static void main(String[] args) {
        // 1. int[]
        int [] arr = new int[3];
        arr[0] = 20;
        arr[1] = 2;
        arr[2] = 20;


        // A. size()
        System.out.println("ArrayUtil.size(arr) : " + ArrayUtil.size(arr));

        // B. isEmpty
        System.out.println("isEmpty(arr) : " + ArrayUtil.isEmpty(arr));

        // C. get()
        System.out.println("get(arr, 1) : "+ ArrayUtil.get(arr,1));

        // D. contains()
        System.out.println("contains(arr, 20) : " + ArrayUtil.contains(arr,20));
        System.out.println("contains(arr, 30) : " + ArrayUtil.contains(arr,30));

        // E. indexOf()
        System.out.println("indexOf(arr, 20) : " + ArrayUtil.indexOf(arr,20));
        System.out.println("indexOf(arr, 30) : " + ArrayUtil.indexOf(arr,30));

        // F lastIndexOf()
        System.out.println("lastIndexOf(arr, 20) : " + ArrayUtil.lastIndexOf(arr,20));
        System.out.println("lastIndexOf(arr, 30) : " + ArrayUtil.lastIndexOf(arr,30));

        // G. add() 배열의 길이를 키워 요소를 추가할때
        System.out.println("add() 전 size : " + ArrayUtil.size(arr));
        System.out.println("add() 전 contains(50) : " + ArrayUtil.contains(arr, 50));
        arr = ArrayUtil.add(arr, 50);
        System.out.println("add() 후 size : " + ArrayUtil.size(arr));
        System.out.println("add() 후 contains(50) : " + ArrayUtil.contains(arr, 50));

        // H. add() 특정 인덱스에 새로운 요소를 추가할때
        System.out.println("add() 전 size : " + ArrayUtil.size(arr));
        System.out.println("add() 전 get(50) : " + ArrayUtil.get(arr, 2));
        arr = ArrayUtil.add(arr, 2, 99);
        System.out.println("add() 후 size : " + ArrayUtil.size(arr));
        System.out.println("add() 후 get(50) : " + ArrayUtil.get(arr, 2));

        // I. set()
        System.out.println("set() 전 get(2) : " + ArrayUtil.get(arr, 2));
        int temp = ArrayUtil.set(arr,2, 88);
        System.out.println("set() 후 get(2) : " + ArrayUtil.get(arr, 2));
        System.out.println("set() 전 기존 값 : " + temp);

        // J. removeByIndex()
        System.out.println("removeByIndex() 전 size : " + ArrayUtil.size(arr));
        System.out.println("removeByIndex() 전 indexOf(88) : " + ArrayUtil.indexOf(arr, 88));
        arr = ArrayUtil.removeByIndex(arr, 2);
        System.out.println("removeByIndex() 후 size : " + ArrayUtil.size(arr));
        System.out.println("removeByIndex() 후 indexOf(88) : " + ArrayUtil.indexOf(arr, 88));

        // K. removeByElement()
        System.out.println("removeByElement() 전 size : " + ArrayUtil.size(arr));
        System.out.println("removeByElement() 전 indexOf(50) : " + ArrayUtil.indexOf(arr, 50));
        arr = ArrayUtil.removeByElement(arr, 50);
        System.out.println("removeByElement() 후 size : " + ArrayUtil.size(arr));
        System.out.println("removeByElement() 후 indexOf(50) : " + ArrayUtil.indexOf(arr, 50));

    }
}
