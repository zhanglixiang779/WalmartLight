package com.financial.gavin.walmartlight.data;

import com.financial.gavin.walmartlight.data.api.ApiHelperInterface;
import com.financial.gavin.walmartlight.data.cashe.PrefsHelperInterface;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by gavin on 1/10/18.
 */

public interface DataManagerInterface extends PrefsHelperInterface, ApiHelperInterface {

}
