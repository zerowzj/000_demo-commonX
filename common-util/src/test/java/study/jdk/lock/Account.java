package study.jdk.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-28 10:11
 */
public class Account {

    private final Lock lock = new ReentrantLock();

    private double balance = 0;

    public Account(){
    }

    public Account(double balance){
        this.balance = balance;
    }

    /**
     * 查询
     */
    public double getBalance(){
        return balance;
    }

    /**
     * 取款
     */
    public void withdraw(int amount){
        try {
            lock.lock();
            balance = balance - amount;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 存款
     */
    public void deposit(int amount){
        try {
//            lock.lock();
            balance = balance + amount;
        } finally {
//            lock.unlock();
        }
    }
}
