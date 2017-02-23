package io.github.magi82.androidmvp.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.github.magi82.androidmvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Presenter
        new MainPresenter(this);

        if (mPresenter != null) {
            mPresenter.start();
        }

        Button btnUser1 = (Button) findViewById(R.id.user1);
        if (btnUser1 != null) {
            btnUser1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.setUser1Data();
                }
            });
        }

        Button btnUser2 = (Button) findViewById(R.id.user2);
        if (btnUser2 != null) {
            btnUser2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.setUser2Data();
                }
            });
        }

        Button btnUser3 = (Button) findViewById(R.id.user3);
        if (btnUser3 != null) {
            btnUser3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.setUser3Data();
                }
            });
        }

        Button btnToast = (Button) findViewById(R.id.toast);
        if (btnToast != null) {
            btnToast.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPresenter.doToastData();
                }
            });
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setName(String strName) {
        TextView tvName = (TextView) findViewById(R.id.name);
        if (tvName != null) {
            tvName.setText(strName);
        }
    }

    @Override
    public void setAge(String strAge) {
        TextView tvAge = (TextView) findViewById(R.id.age);
        if (tvAge != null) {
            tvAge.setText(strAge);
        }
    }

    @Override
    public void setAddress(String strAddress) {
        TextView tvAddress = (TextView) findViewById(R.id.address);
        if (tvAddress != null) {
            tvAddress.setText(strAddress);
        }
    }

    @Override
    public void showToast(String strMessage) {
        Toast.makeText(this, strMessage, Toast.LENGTH_SHORT).show();
    }
}
