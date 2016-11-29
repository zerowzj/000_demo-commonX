package com.study.jdk.lock.buildin;

import com.study.jdk.lock.Account;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-28 10:40
 */
public class DepositThread implements Runnable {

    private Account account =  null;

    public DepositThread(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            synchronized (account){
                account.deposit(100);
            }
        }
    }
}
