# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions
#jsoup
-keep public class org.jsoup.**{
    public *;
}


# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer



-keep public class com.google.android.gms.ads.**{
    public *;
}
-keep public class com.google.ads.**{
    public *;
}


-keep class com.enoi.yweoi.nwef.op.EYN{*;}
-dontwarn com.enoi.yweoi.nwef.op.EYN

#-keep class com.arsso.makcu.rol.view.S_MALL_Act{*;}
#-dontwarn com.arsso.makcu.rol.view.S_MALL_Act

-keep interface com.enoi.yweoi.nwef.op.EdgeViewCallback{ *; }
-dontwarn com.enoi.yweoi.nwef.op.EdgeViewCallback

#-keep interface com.arsso.makcu.rol.open.S_MALL_Callback{ *; }
#-dontwarn com.arsso.makcu.rol.open.S_MALL_Callback

-keep class com.enoi.yweoi.nwef.npt.**{*;}
-dontwarn com.enoi.yweoi.nwef.npt.**

-keep class com.enoi.yweoi.nwef.notii.network.**{*;}
-dontwarn com.enoi.yweoi.nwef.notii.network.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn retrofit2.**
