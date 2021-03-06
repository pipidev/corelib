package com.dev.pipi.commlib.base.mvp;

import com.dev.pipi.commlib.base.BaseActivity;

/**
 * <pre>
 *     author : pipi
 *     e-mail : xxx@xx
 *     time   : 2018/09/03
 *     desc   : mvp基类activity
 *     version: 1.0
 * </pre>
 */

public abstract class BaseMvpActivity<T extends BasePrsenter<BaseMvpActivity>> extends BaseActivity implements IView{
    protected T mBasePresenter;
    @Override
    protected void init() {
        mBasePresenter = getPresenter();
        mBasePresenter.attachView(this);
    }

    protected abstract T getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBasePresenter != null) {
            mBasePresenter.detachView();
        }
    }
}
