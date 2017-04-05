package io.github.magi82.androidmvp.data.account;

import io.github.magi82.androidmvp.data.account.local.AccountLocalDataSource;
import io.github.magi82.androidmvp.data.account.model.Account;
import io.github.magi82.androidmvp.data.account.remote.AccountRemoteDataSource;

/**
 * Created by magi on 2017. 2. 23..
 */

public class AccountRepository implements AccountDataSource {

    private static AccountRepository INSTANCE = null;

    public static AccountRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountRepository(AccountLocalDataSource.getInstance(), AccountRemoteDataSource.getInstance());
        }

        return INSTANCE;
    }

    private final AccountDataSource mAccountLocalDataSource;
    private final AccountDataSource mAccountRemoteDataSource;

    private AccountRepository(AccountDataSource accountLocalDataSource, AccountDataSource accountRemoteDataSource) {
        mAccountLocalDataSource = accountLocalDataSource;
        mAccountRemoteDataSource = accountRemoteDataSource;
    }

    @Override
    public void getAccount(final ResultCallback<Account> callback) {
        mAccountLocalDataSource.getAccount(new ResultCallback<Account>() {
            @Override
            public void onResultLoaded(Account data) {
                callback.onResultLoaded(data);
            }

            @Override
            public void onResultNotAvailble() {
                mAccountRemoteDataSource.getAccount(new ResultCallback<Account>() {
                    @Override
                    public void onResultLoaded(Account data) {
                        callback.onResultLoaded(data);
                    }

                    @Override
                    public void onResultNotAvailble() {
                        callback.onResultNotAvailble();
                    }
                });
            }
        });
    }

    @Override
    public void setAccount(Account sInfo, ResultCallback<Account> callback) {
        mAccountLocalDataSource.setAccount(sInfo, callback);
        mAccountRemoteDataSource.setAccount(sInfo, callback);
    }
}
