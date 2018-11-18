// @author Shkarin Konstantin

package Lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // сортировка Bubble подсчет времени массива arr
        MyArray arr = new MyArray(1000);
        for (int i = 0; i < 1000; i++) {
            int r = (int) (Math.random()*arr.getSize());
            arr.add(r);
        }
        long start = System.nanoTime();
        arr.sortBubble();
        long finish = System.nanoTime();
        long delta = finish-start;
        TimeUnit.NANOSECONDS.toMillis(delta);
        System.out.print("Bubble "+delta);
        System.out.println(" ");

        // сортировка Select подсчет времени массива arr1
        MyArray arr1 = new MyArray(1000);
        for (int i = 0; i < 1000; i++) {
            int r = (int) (Math.random()*arr.getSize());
            arr1.add(r);
        }
        start = System.nanoTime();
        arr1.sortSelect();
        finish = System.nanoTime();
        delta = finish-start;
        TimeUnit.NANOSECONDS.toMillis(delta);
        System.out.print("Select "+ delta);
        System.out.println(" ");

        // сортировка Insert подсчет времени массива arr2
        MyArray arr2 = new MyArray(1000);
        for (int i = 0; i < 1000; i++) {
            int r = (int) (Math.random()*arr.getSize());
            arr2.add(r);
        }
        start = System.nanoTime();
        arr.sortBubble();
        finish = System.nanoTime();
        delta = finish-start;
        TimeUnit.NANOSECONDS.toMillis(delta);
        System.out.print("Insert "+delta);
    }
}

class MyArray {
    private int[] arr;
    private int size;

    public MyArray(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int getSize() {
        return size;
    }


    public void add(int i) {
        this.arr[this.size] = i;
        this.size++;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append("]");
        return sb.toString();

    }

    public boolean binaryFind(int value){
        int low = 0;
        int high = this.size-1;
        int mid;
        while(low<high){
            mid = (low+high)/2;
            if (value == this.arr[mid]){
                return true;
            }
            else {
                if (value < this.arr[mid]){
                    high = mid;
                } else {
                    low = mid+1;
                }
            }
        }
        return false;
    }

    public boolean find(int value){
        int i;
        for(i=0;i<this.size;i++){
            if (this.arr[i] == value) break;
        }
        if (i==this.size)
            return false;
        else
            return true;
    }

    public void delete(int value){
        int i=0;
        for(i=0;i<this.size;i++){
            if (this.arr[i] == value) break;
        }

        for (int j=i;j<this.size-1; j++){
            this.arr[j] = this.arr[j+1];
        }
        this.size--;
    }

    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;

    }


    public void sortSelect(){
        int out, in, mark;
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.arr[in]< this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortInsert(){
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in-1] >=temp){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
    }
}

