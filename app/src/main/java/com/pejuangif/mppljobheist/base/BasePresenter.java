package com.pejuangif.mppljobheist.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter extends ViewModel {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public void addDisposible(Disposable disposable) {
        this.disposable.add(disposable);
    }
}
