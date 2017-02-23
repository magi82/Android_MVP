package io.github.magi82.androidmvp.domain;

import io.github.magi82.androidmvp.data.account.model.Account;

/**
 * Created by magi on 2017. 2. 23..
 */

public interface UseCase {

    interface UseCaseCallback<T> {

        void onSuccess(T data);

        void onFail();
    }
}
