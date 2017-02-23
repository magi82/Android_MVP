package io.github.magi82.androidmvp.data;

/**
 * Created by magi on 2017. 2. 23..
 */

public interface DataSource {

    interface ResultCallback<T> {

        void onResultLoaded(T data);

        void onResultNotAvailble();
    }
}
