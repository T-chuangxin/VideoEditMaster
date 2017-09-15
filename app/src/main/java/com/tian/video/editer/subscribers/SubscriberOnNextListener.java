package com.tian.video.editer.subscribers;

public interface SubscriberOnNextListener<T> {

    void onNext(T t);
    void onError(Throwable errorMessage);

}
