package com.example.geminiv2;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class CredentialsUtil {

    public static GoogleCredentials getCredentials() throws IOException {
        ClassPathResource resource = new ClassPathResource("credentials.json");
        InputStream inputStream = resource.getInputStream();
        return GoogleCredentials.fromStream(inputStream);
    }
}