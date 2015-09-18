package at.mg.androidstudiosandbox;

import android.app.Application;

//import com.facebook.stetho.Stetho;

/**
 * Application class :)
 * <p/>
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
    }

}

