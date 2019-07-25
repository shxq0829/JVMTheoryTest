package com.demo.theory;

/**
 * 虚拟机栈
 * run参数：-Xss256k
 * 测试数据：256k的栈内存，depth：1300
 */
public class StackDemo {
    private static int countter = 0;
    private static final int MAX_RECUR = 2000;

    public static void main(String[] args) {
        // stackOverFlowError
        System.out.println("length:" + recur("test").length() + "   depth:" + countter);

        // oom  不要轻易尝试，会死机^_^
//        StackDemo oom = new StackDemo();
//        oom.stackLeakByThread();
    }


    private static String recur(String str) {
        if (countter > MAX_RECUR) {
            return str;
        }
        String m = str + "plus";
        countter++;

        return recur(m);
    }

    private void dontStop() {
        while (true) {
         }
     }

     //通过不断的创建新的线程使Stack内存耗尽
     public void stackLeakByThread() {
         while (true) {
             Thread thread = new Thread() {
                 @Override
                 public void run() {
                     dontStop();
                 }
             };
             thread.start();
         }
     }
}
