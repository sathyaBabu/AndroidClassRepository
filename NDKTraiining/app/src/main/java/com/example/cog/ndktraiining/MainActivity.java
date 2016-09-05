package com.example.cog.ndktraiining;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

 /*
      Goto terminal : change path to main as follows

      Sathyas-MacBook-Pro:MyApplication malsneha$ cd ../
Sathyas-MacBook-Pro:NDK_STUDIO malsneha$ cd MyApplication/
Sathyas-MacBook-Pro:MyApplication malsneha$ cd app
Sathyas-MacBook-Pro:app malsneha$ cd src
Sathyas-MacBook-Pro:src malsneha$ cd main
Sathyas-MacBook-Pro:main malsneha$ pwd
/Users/malsneha/AndroidStudioProjects/NDK_STUDIO/MyApplication/app/src/main
Sathyas-MacBook-Pro:main malsneha$



     */

public class MainActivity extends Activity {


    public native String HelloJNI();  // This will create intermediates folder - classes debug com example cog ndktrainingThat will have MainActivity.classs

    static {
        System.loadLibrary("HelloJNI");        //  make sure to rebuild the project here this creates necessary lib internally
    }                                           //

    // 3 .. run terminal command
    //  javah -d jni -classpath /Users/malsneha/Library/Android/sdk/platforms/android-19/android.jar:../../build/intermediates/classes/debug com.example.cog.ndktraiining.MainActivity
    // That in turn creates an JNI folder with a header file copy and paste that as .c file as myJNIfun.c


    //3.a  :
/*
    javah -d jni  --> we created a JNI dir

    -classpath /Users/malsneha/Library/Android/sdk/platforms/android-19/android.jar  -->  sdk path
    :  ----> to seperate options from sdk path to mainActivity.class path

    ../../build/intermediates/classes/debug com.example.cog.ndk_studio.MainActivity   ------> MainActivity.class path
*/



    //4 err
    // copy the following line to gradelproperties
    // android.useDeprecatedNdk=true

   // goto gradle module insert the following line at the end of dependency

    /*
    ndk
                {
                    moduleName "HelloJNI"

                }


    // click on build make module ndktraining, app
    // then click on runn button..
    // JNI layer is ready now....

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText(HelloJNI());
        setContentView(tv);


    }
}


