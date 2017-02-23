package io.github.magi82.androidmvp.domain.usecase;

import io.github.magi82.androidmvp.data.account.AccountDataSource;
import io.github.magi82.androidmvp.data.account.AccountRepository;
import io.github.magi82.androidmvp.data.account.model.Account;
import io.github.magi82.androidmvp.domain.UseCase;

/**
 * Created by magi on 2017. 2. 23..
 */

public class AccountUseCase implements UseCase {

    private final AccountRepository mRepository;

    public AccountUseCase(AccountRepository sRepository) {
        mRepository = sRepository;
    }

    public void setAccountInfo(Account sInfo, final UseCase.UseCaseCallback<Account> callback) {
        if (sInfo != null) {
            mRepository.setAccount(sInfo, new AccountDataSource.ResultCallback<Account>() {
                @Override
                public void onResultLoaded(Account data) {
                    callback.onSuccess(data);
                }

                @Override
                public void onResultNotAvailble() {
                    callback.onFail();
                }
            });
        }
    }

    public void getAccountInfo(final UseCase.UseCaseCallback<Account> callback) {
        mRepository.getAccount(new AccountDataSource.ResultCallback<Account>() {
            @Override
            public void onResultLoaded(Account data) {
                callback.onSuccess(data);
            }

            @Override
            public void onResultNotAvailble() {
                callback.onFail();
            }
        });
    }
}
