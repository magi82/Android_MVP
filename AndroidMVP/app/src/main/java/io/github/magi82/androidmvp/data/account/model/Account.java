package io.github.magi82.androidmvp.data.account.model;

/**
 * Created by quse on 2017. 2. 19..
 */

public class Account {
    private String mName;
    private String mAge;
    private String mAddress;

    public String getName() {
        return mName;
    }

    public void setName(String strName) {
        this.mName = strName;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String strAge) {
        this.mAge = strAge;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String strAddress) {
        this.mAddress = strAddress;
    }
}
