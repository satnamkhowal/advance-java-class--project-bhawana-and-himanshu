

package com.myplatform;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.security.MessageDigest;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {

    public static String hashPassword(String password)
            throws Exception {

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        KeySpec spec = new PBEKeySpec(
            password.toCharArray(),
            salt,
            210000,
            256
        );

        SecretKeyFactory factory =
            SecretKeyFactory.getInstance(
                "PBKDF2WithHmacSHA256"
            );

        byte[] hash = factory.generateSecret(spec).getEncoded();

        return "PBKDF2$210000$"
            + Base64.getEncoder().encodeToString(salt)
            + "$"
            + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPassword(
            String password, String storedPassword)
            throws Exception {

        String[] parts = storedPassword.split("\\$");

        if (parts.length != 4 ||
            !parts[0].equals("PBKDF2")) {
            return false;
        }

        int iterations = Integer.parseInt(parts[1]);

        if (iterations != 210000) {
            return false;
        }

        byte[] salt = Base64.getDecoder()
                            .decode(parts[2]);

        byte[] originalHash = Base64.getDecoder()
                                    .decode(parts[3]);

        KeySpec spec = new PBEKeySpec(
            password.toCharArray(),
            salt,
            iterations,
            originalHash.length * 8
        );

        SecretKeyFactory factory =
            SecretKeyFactory.getInstance(
                "PBKDF2WithHmacSHA256"
            );

        byte[] newHash =
            factory.generateSecret(spec).getEncoded();

        return MessageDigest.isEqual(
            originalHash, newHash
        );
    }
}

