package com.example.geminiv2;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
@RestController
@RequestMapping("/gemini/")
public class GeminiController {
    @PostMapping("send")
    public String getGeminiResponse() throws IOException {
        String projectId = "fabled-buckeye-426015-k5";
        String location = "us-central1";
        String modelName = "gemini-1.5-flash-001";
        String textPrompt =
                "What's a good name for a flower shop that specializes in selling bouquets of"
                        + " dried flowers?";

        String output = textInput(projectId, location, modelName, textPrompt);
        System.out.println(output);
        return output;
    }
    public String textInput(
            String projectId, String location, String modelName, String textPrompt) throws IOException {
        // Initialize client that will be used to send requests. This client only needs
        // to be created once, and can be reused for multiple requests.
        GoogleCredentials credentials = CredentialsUtil.getCredentials();
        try (VertexAI vertexAI = new VertexAI(projectId, location,credentials)) {
            GenerativeModel model = new GenerativeModel(modelName, vertexAI);

            GenerateContentResponse response = model.generateContent(textPrompt);
            String output = ResponseHandler.getText(response);
            return output;
        }
    }

}
