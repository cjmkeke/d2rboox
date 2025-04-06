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

# Bow1 및 내부 클래스 보존
# Gson이 generic type info를 유지할 수 있도록

-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-keepattributes *Annotation*

# skillUpdate 메서드 보존 (모든 하위 클래스 포함)
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

# *_end 형태의 필드 보존 (예: bowSkill1_end, defenseSkill2_end 등)
-keepclassmembers class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.** {
    public static java.lang.String *;
}

 # 아마존
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.bow.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.javelin.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.amazon.passive.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 어쌔신
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.martial** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.shadow** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.assassin.traps** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 바바리안
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.combat** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.masteries** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.barbarian.warcries** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 드루이드
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.druid.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 네크로맨서
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.necromancer.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 팔라딘
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.paladins.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}

 # 소서리스
-keep class com.cjmkeke.d2rbooks.chardatabase.character_skill_tab.sorceress.** {
    public static void skillUpdate(int, android.widget.TextView, android.content.Context, android.content.SharedPreferences);
}
-keep class com.cjmkeke.d2rbooks.chardatabase.tools.JsonModels {
    *;
}

# Gson 관련 타입 어댑터 유지
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# TypeToken 및 리플렉션 기반 라이브러리 사용 시 필요한 정보
-keepattributes Signature
-keepattributes *Annotation*

# 모델 클래스들 유지
-keepclassmembers class com.cjmkeke.d2rbooks.model.** {
    <fields>;
    <methods>;
}

# Firebase 관련 클래스들 유지
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }


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
