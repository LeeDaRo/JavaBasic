package util;
// 배열을 다룰 때 도움이 되는 다양한 메소드를 정의한다
// ArrayUtill 클래스

import java.util.Random;
import struct.Student;

public class ArrayUtil {
    // 1. int[]
    // A. 현재 배열의 길이를 리턴하는
    //  size()
    public static int size(int [] arr){
        return arr.length;
    }

    // B. 현재 배열이 비어있는지 체크하는
    // isEmpty()
    public static boolean isEmpty(int [] arr){
        return size(arr) == 0;
    }

    // C. 현재 배열에 특정 인덱스 값을 리턴하는
    // get()
    public static int get(int [] arr, int index){
        return arr[index];
    }

    // D. 현재 배열에 특정 요소가 있는지 체크하는
    // contains()
    public static boolean contains(int [] arr, int element){
        for (int i = 0; i < size(arr); i++){
            if (get(arr,i) == element){
                return true;
            }
        }

        return false;
    }

    // E. 현재 배열에서 특정 요소의 가장 먼저 등장하는 인덱스를 리턴하는
    // indexOf()
    public static int indexOf(int [] arr, int element){
        for (int i = 0; i < size(arr); i++){
            if (get(arr,i) == element){
                return i;
            }
        }

        return -1;
    }

    // F. 현재 배열에서 특정 요소의 가장 마지막에 등장하는 인덱스를 리턴하는
    // lastIndexOf()
    public static int lastIndexOf(int [] arr, int element){
        for (int i = size(arr) - 1 ; i >= 0; i--){
            if (get(arr,i) == element){
                return i;
            }
        }

        return -1;
    }

    // G. 배열에 새로운 요소를 추가하여
    // 크기가 증가된 배열을 리턴하는
    // add()
    public static int[] add(int [] arr, int element){
        // 1. 현재 배열보다 크기가 1 더 큰 int[]를 만들어 준다.
        int [] temp = new int[size(arr) + 1];
        // 2. 현재 배열의 내용을 차례대로 임시 배열에 넣어준다.
        for (int i = 0; i < size(arr); i++){
            temp[i] = get(arr, i);
        }
        // 3. 임시 배열의 가장 마지막 칸에 element를 넣어준다.
        temp[size(temp) - 1] = element;
        // 4. 임시 배열을 리턴한다.
        return temp;
    }

    // H. 특정 인덱스에 새로운 요소를 추가하는
    // add()
    public static int[] add(int[] arr, int index, int element){
        int [] temp = new int[0];
        for (int i = 0; i < index; i++){
            temp = add(temp, get(arr, i));
        }
        temp = add(temp, element);
        for (int i = index; i < size(arr); i++){
            temp = add(temp, get(arr, i));
        }

        return temp;
    }

    // I. 특정 인덱스의 값을 새로운 값으로 바꾸는
    // set()
    // 단, 기존의 값은 다른 곳에서 사용 할 수도 있으므로
    // 그 값을 호출된 곳으로 리턴해준다.
    public static int set(int [] arr, int index, int element){
        int temp =  get(arr, index);
        arr[index] = element;

        return temp;
    }

    // J. 특정 인덱스의 값을 삭제 하는
    // removeByIndex()
    public static int [] removeByIndex(int [] arr, int index){
        if (index < 0 || index >= size(arr)){
            return arr;
        }
        int [] temp = new int[0];
        for (int i = 0; i < size(arr); i++){
            if (i != index){
                temp = add(temp, get(arr, i));
            }
        }
        return temp;
    }

    // K. 배열의 특정 엘리먼트를 삭제하는
    // removeByElement
    public static int [] removeByElement(int [] arr, int element){
        return removeByIndex(arr, indexOf(arr, element));
    }

    // 1. String[]
    // A. 현재 배열의 길이를 리턴하는
    //  size()
    public static int size(String[] arr){

        return arr.length;
    }

    // B. 현재 배열이 비어있는지 체크하는
    // isEmpty()
    public static boolean isEmpty(String [] arr){

        return size(arr) == 0;
    }


    // C. 현재 배열에 특정 인덱스 값을 리턴하는
    // get()
    public static String get(String [] arr, int index){

        return arr[index];
    }


    // D. 현재 배열에 특정 요소가 있는지 체크하는
    // contains()
    public static boolean contains(String [] arr, String str){
        for (int i = 0; i < size(arr); i++){
            if (get(arr, i) .equals(str)){

                return true;
            }
        }

        return false;
    }


    // E. 현재 배열에서 특정 요소의 가장 먼저 등장하는 인덱스를 리턴하는
    // indexOf()
    public static int indexOf(String [] arr, String str){
        for (int i = 0; i < size(arr); i++){
            if (get(arr, i) .equals(str)){

                return i;
            }
        }

        return -1;
    }


    // F. 현재 배열에서 특정 요소의 가장 마지막에 등장하는 인덱스를 리턴하는
    // lastIndexOf()
    public static int lastIndexOf(String [] arr, String str){
        for (int i = size(arr)-1; i <=0; i--){
            if (get(arr,i) .equals(str)){

                return i;
            }
        }

        return -1;
    }


    // G. 배열에 새로운 요소를 추가하여
    // 크기가 증가된 배열을 리턴하는
    // add()
    public static String[] add(String [] arr, String str){
        // 1. 현재 배열보다 크기가 1 더 큰 String[]를 만들어 준다.
        String [] temp = new String[size(arr) + 1];

        // 2. 현재 배열의 내용을 차례대로 임시 배열에 넣어준다.
        for (int i = 0; i < size(arr); i++){
            temp[i] = get(arr, i);
        }
        // 3. 임시 배열의 가장 마지막 칸에 str 넣어준다.
        temp[size(arr)] = str;

        // 4. 임시 배열을 리턴한다.
        return temp;
    }



    // H. 특정 인덱스에 새로운 요소를 추가하는
    // add()
    public static String [] add(String [] arr, int index, String str){
        String [] temp = new String[0];
        // temp 배열에 특정 인덱스 전까지의 기존의 값을 넣어준다.
        for (int i = 0;  i < index; i++){
            temp = add(temp, get(arr, i));
        }
        temp = add(temp, str);
        // temp 배열에 특정 인덱스에 추가할 요소를 넣어주고 그뒤에 기존의 남은 값을 차례대로 넣어준다.
        for (int i = index; i < size(arr); i++){
            temp = add(temp, get(arr, i));
        }

        return temp;
    }

    // I. 특정 인덱스의 값을 새로운 값으로 바꾸는
    // set()
    // 단, 기존의 값은 다른 곳에서 사용 할 수도 있으므로
    // 그 값을 호출된 곳으로 리턴해준다.
    public static String set(String [] arr, int index, String str){
        String temp = get(arr, index);
        arr[index] = str;

        return temp;
    }


    // J. 특정 인덱스의 값을 삭제 하는
    // removeByIndex()
    public static String [] removeByIndex(String [] arr, int index){
        if (index < 0 || index >= size(arr)){

            return arr;
        }

        String [] temp = new String[0];
        for (int i = 0 ; i < size(arr); i++){
            if (i != index){
                temp = add(temp, get(arr, i));
            }
        }

        return temp;
    }


    // K. 배열의 특정 엘리먼트를 삭제하는
    // removeByElement
    public static String [] removeByElement(String [] arr, String str){

        return removeByIndex(arr, indexOf(arr, str));
    }


    // 3. student[]
    // A. size()
    public static int size(Student [] arr){
        return arr.length;
    }

    // B. iEmpty
    public static boolean isEmpty(Student [] arr){
        return size(arr) == 0;
    }

    // C. get()
    public static Student get(Student [] arr, int index){
        return arr[index];
    }

    // D. equals()
    public static boolean equals(Student s1, Student s2){
        return s1.id == s2.id;
    }

    // E. contains()
    public static boolean contains(Student [] arr, Student element){
        for(Student s : arr){
            if (equals(s,element)){
                return true;
            }
        }
        return false;
    }

    // F. indexOf
    public static int indexOf(Student [] arr, Student element){
        for (int i= 0; i < size(arr); i++){
            if (equals(get(arr, i), element)){
                return i;
            }
        }
        return -1;
    }

    // G. lastIndexOf
    public static int lastIndexOf(Student [] arr, Student element){
        for (int i = size(arr) -1; i >= 0; i++){
            if (equals(get(arr, i), element)){
                return i;
            }
        }

        return -1;
    }

    // H. add()
    public static Student [] add(Student [] arr, Student element){
        Student [] temp = new Student[size(arr) + 1];
        for (int i = 0; i < size(arr); i++){
            temp[i] = get(arr, i);

        }
        temp[size(temp) -1] = element;

        return temp;
    }

    // I. add()
    public static Student[] add(Student [] arr, int index , Student element){
        Student [] temp = new Student[0];
        for (int i = 0; i < index; i++){
            temp = add(temp, get(arr,i));
        }
        temp = add(temp, element);
        for (int i = index; i <size(arr); i++){
            temp = add(temp, get(arr,i));
        }
        return temp;
    }

    // J. set()
    public static Student set(Student [] arr, int index, Student element){
        Student temp = get(arr, index);
        arr[index] = element;
        return temp;
    }

    // K. remove()
    public static Student [] remove(Student [] arr, int index){
        if (index < 0 || index >= size(arr)){
            return arr;
        }
        Student [] temp = new Student[0];
        for (int i = 0; i < size(arr); i++){
            if (i != index){
                temp = add(temp, get(arr, i));
            }
        }
        return temp;
    }

    //L. remove()
    public static Student [] remove(Student [] arr, Student element){
        return remove(arr, indexOf(arr, element));
    }
}
