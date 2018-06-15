package com.camera.sirusgoorhuis.camera_app.retrospective;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class Security {
    private static final String ENCRYPTION_PASSWORD = "FilmRoll";

    public static void encrypt(byte[] image) {
        try {
            SecretKeySpec key = generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = cipher.doFinal(image);
            String encryptedImage = Base64.encodeToString(encVal, Base64.DEFAULT);
            RetrospectiveActivity.addEncryptedPhoto(encryptedImage);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Bitmap decrypt(String image) {
        try {
            SecretKeySpec key = generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decValue = cipher.doFinal(Base64.decode(image, Base64.DEFAULT));
            return BitmapFactory.decodeByteArray(decValue, 0, decValue.length);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static SecretKeySpec generateKey() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = ENCRYPTION_PASSWORD.getBytes("UTF-8");
            digest.update(bytes, 0, bytes.length);
            byte[] key = digest.digest();
            return new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
