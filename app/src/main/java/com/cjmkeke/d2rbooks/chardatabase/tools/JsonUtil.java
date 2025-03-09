package com.cjmkeke.d2rbooks.chardatabase.tools;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonUtil {

    // 제네릭 메소드 선언
    public static <T> List<T> loadJSONFromAsset(Context context, String fileName, Type typeOfT) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }

}

