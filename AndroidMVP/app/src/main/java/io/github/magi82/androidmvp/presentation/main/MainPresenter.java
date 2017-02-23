package io.github.magi82.androidmvp.presentation.main;

import io.github.magi82.androidmvp.data.account.AccountRepository;
import io.github.magi82.androidmvp.data.account.model.Account;
import io.github.magi82.androidmvp.domain.UseCase;
import io.github.magi82.androidmvp.domain.usecase.AccountUseCase;

/**
 * Created by quse on 2017. 2. 19..
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private AccountUseCase mAccountUseCase;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mAccountUseCase = new AccountUseCase(AccountRepository.getInstance());
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        setData("JOHN", "36", "LA");
    }

    public void setData(String strName, String strAge, String strAddress) {
        Account sAccountInfo = new Account();
        sAccountInfo.setName(strName);
        sAccountInfo.setAge(strAge);
        sAccountInfo.setAddress(strAddress);

        mAccountUseCase.setAccountInfo(sAccountInfo, new UseCase.UseCaseCallback<Account>() {
            @Override
            public void onSuccess(Account sInfo) {
                if (sInfo != null) {
                    mView.setName(sInfo.getName());
                    mView.setAge(sInfo.getAge());
                    mView.setAddress(sInfo.getAddress());
                }
            }

            @Override
            public void onFail() {
                mView.showToast("Error");
            }
        });
    }

    @Override
    public void setUser1Data() {
        setData("JOHN", "36", "LA");
    }

    @Override
    public void setUser2Data() {
        setData("MAKO", "31", "JAPAN");
    }

    @Override
    public void setUser3Data() {
        setData("Mr.Hwang", "44", "KOREA");
    }

    @Override
    public void doToastData() {
        mAccountUseCase.getAccountInfo(new UseCase.UseCaseCallback<Account>() {
            @Override
            public void onSuccess(Account data) {
                mView.showToast(data.getName() + " / " + data.getAge() + " / " + data.getAddress());
            }

            @Override
            public void onFail() {
                mView.showToast("Error");
            }
        });
    }
}
