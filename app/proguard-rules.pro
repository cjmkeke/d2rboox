# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Firebase 데이터 모델 클래스 예외 처리
# Firebase 데이터 모델 클래스 예외 처리

-keep class android.util.Log { *; }
-keepclassmembers class com.cjmkeke.d2rbooks.model.Unique {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.Character {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.HaveRune {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.ItemModels {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.Rune {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.RuneWord {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.SetItem {
    <fields>;
    <methods>;
}
-keepclassmembers class com.cjmkeke.d2rbooks.model.WeaponsModels {
    <fields>;
    <methods>;
}

# Firebase 관련 코드 유지
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }
