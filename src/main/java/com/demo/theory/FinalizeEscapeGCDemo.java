package com.demo.theory;

public class FinalizeEscapeGCDemo {
    public static FinalizeEscapeGCDemo SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGCDemo.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException{
        SAVE_HOOK = new FinalizeEscapeGCDemo();

        // 第一次执行，拯救成功
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead!");
        }

        //第二次执行，拯救失败。
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead!");
        }
    }
}
