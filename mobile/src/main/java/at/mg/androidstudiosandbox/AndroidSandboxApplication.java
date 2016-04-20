package at.mg.androidstudiosandbox;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

//import com.facebook.stetho.Stetho;

/**
 * Application class :)
 * <p>
 * Created by Markus on 17.07.2015.
 */
public class AndroidSandboxApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        if (BuildConfig.DEBUG) {
//            // http://facebook.github.io/stetho/
//            Stetho.initialize(
//                    Stetho.newInitializerBuilder(this)
//                            .enableDumpapp(
//                                    Stetho.defaultDumperPluginsProvider(this))
//                            .enableWebKitInspector(
//                                    Stetho.defaultInspectorModulesProvider(this))
//                            .build());
//        }


        rxSandbox();
    }

    private void rxSandbox() {

        Log.i("RX", "Example1:");
        Observable
                .from(new Integer[]{1, 2, 3, 4, 5, 6})
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed Observable.");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("Whoops: " + throwable.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Got: " + integer);
                    }
                });

        Log.i("RX", "Example2:");
        Observable
                .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 0)
                .subscribe(System.out::println);

        Log.i("RX", "Example3:");
        Observable
                .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(integer -> Log.i("RX", " -- " + integer));

        Log.i("RX", "Example4:");
        Observable
                .just(1, 2, 3, 4, 5)
                .groupBy(integer -> integer % 2 == 0 ? "jo" : "na").subscribe(grouped -> {
            grouped.toList().subscribe(integers -> {
                Log.i("RX", integers + " (Even: " + grouped.getKey() + ")");
            });
        });

        Log.i("RX", "Example4:");
        Observable
                .just(1, 2, 3, 4, 5)
                .take(2)
                .subscribe(integer -> Log.i("RX", "first 2: " + integer));

        Log.i("RX", "Example5:");
        Observable
                .just(1, 2, 3, 4, 5)
                .first()
                .subscribe(integer -> Log.i("RX", "First: " + integer));

        Log.i("RX", "Example6:");
        Observable
                .just(1, 2, 3, 4, 5)
                .last()
                .subscribe(integer -> Log.i("RX", "Last: " + integer));

        Log.i("RX", "Example7:");
        Observable
                .just("Hello", "Hi", "Guten Tag", "Hello", "Hi", "Guck")
                .distinct()
                .subscribe(result -> Log.i("RX", "Destinct: " + result));

        Log.i("RX", "Example8:");
        Observable.just("Hello world!")
                .map(s -> s.hashCode())
                .subscribe(hashCode -> Log.i("RX", "hash: " + hashCode));

        List<User> users = new ArrayList<>();

        users.add(new User("jon snow"));
        users.add(new User("tyrion lannister"));

        Observable
                .just(users)
                .concatMap(Observable::from)
                .observeOn(Schedulers.io())
                .subscribe(user -> {
                    Log.i("RX", user.name);
                    Log.i("RX", "currentThread " + Thread.currentThread().getName());
                });


    }


    private class User {
        public String name;

        User(String name) {
            this.name = name;
        }
    }
}

