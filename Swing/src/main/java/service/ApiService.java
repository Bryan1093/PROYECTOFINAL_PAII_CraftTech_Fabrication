package service;

import okhttp3.*;

import java.io.IOException;

public class ApiService {
    private final OkHttpClient client = new OkHttpClient();
    private final String BASE_URL = "http://localhost:8080"; // URL of the Spring Boot application

    public String getProducts() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/products")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String placeOrder(String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(BASE_URL + "/orders")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public void processOrder(Long id) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/orders/" + id + "/process")
                .post(RequestBody.create("", MediaType.get("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        }
    }
}