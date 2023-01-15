@file:Suppress("UnstableApiUsage")

plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")

}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
//        versionCode = 1
//        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
//    implementation(libs.googlemaps.maps)
//    implementation(libs.androidx.appcompat)
//    implementation "androidx.core:core-ktx:$core_ktx_version"
//    implementation "androidx.appcompat:appcompat:$appcompat_version"
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.appcompat)

    //retrofit
//    api "com.squareup.retrofit2:retrofit:$retrofit_version"
//    api "com.squareup.retrofit2:converter-gson:$retrofit_version"
    api(libs.retrofit)
    api(libs.retrofit.converter.gso)

    //okHttp
//    api "com.squareup.okhttp3:okhttp:$okhttp_version"
    implementation(libs.okhttp3)
    //paging3
//    api "androidx.paging:paging-runtime:$paging_version"
//    api "androidx.paging:paging-compose:$paging_compose_version"
    implementation(libs.androidx.paging)
    implementation(libs.androidx.paging.compose)

    //数据保存，这里用于cookie持久化
//    api "androidx.datastore:datastore-preferences:$datastore_version"
    implementation(libs.androidx.datastore)
}