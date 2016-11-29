package study.jdk.lock.displayed;

import study.jdk.lock.Account;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-28 10:56
 */
public class DisplayedMain {

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++){
            test();
        }
    }

    public static void test(){
        Account account = new Account(2000);
        Thread t1 = new Thread(new WithdrawThread(account));
        Thread t2 = new Thread(new WithdrawThread(account));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println(account.getBalance());
    }
}
