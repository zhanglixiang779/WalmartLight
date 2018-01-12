package com.financial.gavin.walmartlight.rx;

import com.financial.gavin.walmartlight.data.DataManager;
import com.financial.gavin.walmartlight.data.api.model.Product;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by gavin on 1/10/18.
 */

public class RxManager<T> {
	private static RxManager instance;
	private DisposableObserver<T> observer;
	
	private RxManager() {}
	
	public static synchronized RxManager getInstance() {
		if (instance == null) {
			instance = new RxManager();
		}
		
		return instance;
	}
	
	public void setObserver(DisposableObserver<T> observer) {
		this.observer = observer;
	}
	
	public void post(T t) {
		getObservable(t).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(observer);
	}
	
	private Observable<T> getObservable(T t) {
		return Observable.just(t);
	}
}
