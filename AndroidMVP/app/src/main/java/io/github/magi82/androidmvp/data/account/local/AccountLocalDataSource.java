package io.github.magi82.androidmvp.data.account.local;

import io.github.magi82.androidmvp.data.account.AccountDataSource;
import io.github.magi82.androidmvp.data.account.model.Account;

/**
 * Created by magi on 2017. 4. 5..
 */

public class AccountLocalDataSource implements AccountDataSource {

    private static AccountLocalDataSource INSTANCE = null;

    private Account mAccount = null;

    public static AccountLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountLocalDataSource();
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
