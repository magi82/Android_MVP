package io.github.magi82.androidmvp.presentation.main;

import io.github.magi82.androidmvp.presentation.BasePresenter;
import io.github.magi82.androidmvp.presentation.BaseView;

/**
 * Created by quse on 2017. 2. 19..
 */

public interface MainContract {

    interface Presenter extends BasePresenter {

        void setUser1Data();

        void setUser2Data();

        void setUser3Data();

        void doToastData();
    }

    interface View extends BaseView<Presenter> {

        void setName(String strName);

        void setAge(String strAge);

        void setAddress(String strAddress);

        void showToast(String strMessage);
    }
}
