package io.github.magi82.androidmvp.main;

import io.github.magi82.androidmvp.model.AccountInfo;

/**
 * Created by quse on 2017. 2. 19..
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private AccountInfo mAccountInfo;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void start() {
        mAccountInfo = new AccountInfo();
        mAccountInfo.setName("HBK");
        mAccountInfo.setAge("36");
        mAccountInfo.setAddress("Korea");

        mView.setName(mAccountInfo.getName());
        mView.setAge(mAccountInfo.getAge());
        mView.setAddress(mAccountInfo.getAddress());
    }
}
