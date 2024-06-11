package com.example.geminiv2;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.ResponseHandler;

import javax.annotation.PostConstruct;
import java.io.IOException;

public class QuestionAnswer {
//    @PostConstruct
//
//    public static void main(String[] args) throws Exception {
//        // TODO(developer): Replace these variables before running the sample.
//        String projectId = "fabled-buckeye-426015-k5";
//        String location = "us-central1";
//        String modelName = "gemini-1.5-flash-001";
//
//        String output = simpleQuestion(projectId, location, modelName);
//        System.out.println(output);
//    }
//
//    // Asks a question to the specified Vertex AI Gemini model and returns the generated answer.
//    public static String simpleQuestion(String projectId, String location, String modelName)
//            throws Exception {
//        // Initialize client that will be used to send requests.
//        // This client only needs to be created once, and can be reused for multiple requests.
//        try (VertexAI vertexAI = new VertexAI(projectId, location)) {
//            String output;
//            GenerativeModel model = new GenerativeModel(modelName, vertexAI);
//            // Send the question to the model for processing.
//            GenerateContentResponse response = model.generateContent("Why is the sky blue?");
//            // Extract the generated text from the model's response.
//            output = ResponseHandler.getText(response);
//            return output;
//        }
//    }



    public static void main(String[] args) throws IOException {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "tla-llm";
        String location = "us-central1";
        String modelName = "gemini-1.5-flash-001";
        String textPrompt =
                "What's a good name for a flower shop that specializes in selling bouquets of"
                        + " dried flowers?";

        String output = textInput(projectId, location, modelName, textPrompt);
        System.out.println(output);
    }

    // Passes the provided text input to the Gemini model and returns the text-only response.
    // For the specified textPrompt, the model returns a list of possible store names.
    public static String textInput(
            String projectId, String location, String modelName, String textPrompt) throws IOException {
        GoogleCredentials credentials = CredentialsUtil.getCredentials();
        // Initialize client that will be used to send requests. This client only needs
        // to be created once, and can be reused for multiple requests.
        try (VertexAI vertexAI = new VertexAI(projectId, location, credentials)) {
            GenerativeModel model = new GenerativeModel(modelName, vertexAI);

            GenerateContentResponse response = model.generateContent(textPrompt);
            String output = ResponseHandler.getText(response);
            return output;
        }
    }
}