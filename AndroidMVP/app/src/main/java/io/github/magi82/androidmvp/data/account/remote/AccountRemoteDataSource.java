package io.github.magi82.androidmvp.data.account.remote;

import io.github.magi82.androidmvp.data.account.AccountDataSource;
import io.github.magi82.androidmvp.data.account.model.Account;

/**
 * Created by magi on 2017. 4. 5..
 */

public class AccountRemoteDataSource implements AccountDataSource {

    private static AccountRemoteDataSource INSTANCE = null;

    private Account mAccount = null;

    public static AccountRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountRemoteDataSource();
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
