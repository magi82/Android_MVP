package io.github.magi82.androidmvp.data.account;

import io.github.magi82.androidmvp.data.account.model.Account;

/**
 * Created by magi on 2017. 2. 23..
 */

public class AccountRepository implements AccountDataSource {

    private static AccountRepository INSTANCE = null;

    private Account mAccount = null;

    public static AccountRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountRepository();
        }

        return INSTANCE;
    }

    @Override
    public void getAccount(ResultCallback<Account> callback) {
        if (mAccount != null) {
            callback.onResultLoaded(mAccount);
        } else {
            callback.onResultNotAvailble();
        }
    }

    @Override
    public void setAccount(Account sInfo, ResultCallback<Account> callback) {
        if (sInfo != null) {
            mAccount = sInfo;
            callback.onResultLoaded(mAccount);
        } else {
            callback.onResultNotAvailble();
        }
    }
}
