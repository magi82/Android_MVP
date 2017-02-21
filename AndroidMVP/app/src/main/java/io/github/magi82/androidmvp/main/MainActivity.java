package io.github.magi82.androidmvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.magi82.androidmvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setPresenter(new MainPresenter(this));
        mPresenter.start();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setName(String strName) {
        ((TextView) findViewById(R.id.name)).setText(strName);
    }

    @Override
    public void setAge(String strAge) {
        ((TextView) findViewById(R.id.name)).setText(strAge);
    }

    @Override
    public void setAddress(String strAddress) {
        ((TextView) findViewById(R.id.name)).setText(strAddress);
    }
}
