package io.github.magi82.androidmvp.main;

import io.github.magi82.androidmvp.core.BasePresenter;
import io.github.magi82.androidmvp.core.BaseView;

/**
 * Created by quse on 2017. 2. 19..
 */

public interface MainContract {

    interface Presenter extends BasePresenter {
    }

    interface View extends BaseView<Presenter> {

        void setName(String strName);

        void setAge(String strAge);

        void setAddress(String strAddress);
    }
}
