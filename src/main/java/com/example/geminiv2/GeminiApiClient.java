package com.example.geminiv2;

import java.io.IOException;

public class GeminiApiClient {
    public static void main(String[] args) throws IOException {

        // Tạo GoogleCredentials từ tệp JSON
        GoogleCredentials credentials = CredentialsUtil.getCredentials();

        // Tạo GeminiClient từ GoogleCredentials
        GeminiClient geminiClient = GeminiClient.create(credentials);

        // Tạo yêu cầu dự đoán
        String modelId = "your-model-id";
        String endpointId = "your-endpoint-id";
        PredictRequest predictRequest = PredictRequest.newBuilder()
                .setEndpoint(endpointId)
                .setPayload(Value.newBuilder().build())
                .build();

        // Gửi yêu cầu dự đoán và nhận kết quả
        PredictResponse predictResponse = geminiClient.predict(modelId, predictRequest);
        System.out.println(predictResponse);

        // Đóng kết nối với GeminiClient
        geminiClient.close();
    }
}