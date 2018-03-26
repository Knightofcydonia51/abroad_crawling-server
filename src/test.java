
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class test {
    public static void main(String[] args) {
 
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
 
        // 9 2 4 1 6 8
        arrayList.add(9);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(6);
        arrayList.add(8);
 
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
        System.out.println();
 
        // 내림차순 정렬
        Descending descending = new Descending();
        Collections.sort(arrayList, descending);
 
        System.out.print("내림차순 - ");
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
        System.out.println();
 
        // 오름차순 정렬
        Ascending ascending = new Ascending();
        Collections.sort(arrayList, ascending);
 
        System.out.print("오름차순 - ");
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
 
}
 
// 내림차순
class Descending implements Comparator<Integer> {
 
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
 
}
 
// 오름차순
class Ascending implements Comparator<Integer> {
 
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
 
}



