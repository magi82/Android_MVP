package io.github.magi82.androidmvp.data.account;

import io.github.magi82.androidmvp.data.DataSource;
import io.github.magi82.androidmvp.data.account.model.Account;

/**
 * Created by magi on 2017. 2. 23..
 */

public interface AccountDataSource extends DataSource {

    void getAccount(ResultCallback<Account> callback);

    void setAccount(Account sInfo, ResultCallback<Account> callback);
}
