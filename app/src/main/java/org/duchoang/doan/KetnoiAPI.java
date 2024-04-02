package org.duchoang.doan;

import ui.constract.APIService;
import ui.presenter.APIClient;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KetnoiAPI extends AppCompatActivity {

    private APIService apiService;
    private TextView textResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);

        // Khởi tạo ApiService
        apiService = APIClient.getClient().create(APIService.class);

        // Ánh xạ TextView
        textResponse = findViewById(R.id.text_response);
        if (textResponse != null) {
            // Gọi yêu cầu API
            Call<String> call = apiService.connectDB();
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        // Xử lý dữ liệu trả về ở đây
                        String responseData = response.body();
                        textResponse.setText("Response from API: " + responseData);
                    } else {
                        // Xử lý khi có lỗi
                        textResponse.setText("Error: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    // Xử lý khi có lỗi
                    textResponse.setText("Error: " + t.getMessage());
                }
            });
        } else {

        }
    }
    }