## Steps to integrate ChatSDK into a new project
1. In order to build a Kotlin project with Gradle, you should apply the Kotlin Gradle plugin to your project
```
  ext.kotlin_version = '1.6.0'
  dependencies {
	  classpath 'com.android.tools.build:gradle:4.0.2'
	  classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
	  classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
  }
```
2. Apply Kotlin plugins in the app/build.gradle file
```
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'
```
3. You need to enable Java 8
```
 compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
kotlinOptions {
        jvmTarget = '1.8'
    }
```
4. You also need to create at least 2 build variants like this:
```
 flavorDimensions "default"
    productFlavors {
        prod {
            dimension "default"
//            signingConfig signingConfigs.production
        }
        dev {
            dimension "default"
            applicationIdSuffix ".dev"
            versionName "-dev"
        }
    }
```

5. Import chat module to app/build.gradle - add this to your dependencies area:
```
implementation("com.ripbull.coresdk:ripbull-chat-sdk:1.1.1.release-rc1@aar"){
       transitive = true
    } 
```
6. Make sure you’ve added the following to your gradle.properties file.
```
android.useAndroidX=true
```
7. AndroidX, Appcompat and Material libraries also need import to your dependencies area:
```
  implementation "androidx.core:core-ktx:1.2.0"
  implementation 'androidx.appcompat:appcompat:1.1.0'
  implementation 'com.google.android.material:material:1.6.1'
```
8. ChatSDK is dealing with asynchronous task based on Rx, you also need import RxJava & RxAndroid to your dependencies area:
```
 implementation "io.reactivex.rxjava2:rxandroid:2.1.0"
 implementation "io.reactivex.rxjava2:rxjava:2.0.1"
```

9. To work with ChatSDK please follow documentation here: https://inappchat.io/documentation/android