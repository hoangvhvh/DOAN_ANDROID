package ui.constract;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("connectdb.php")
    Call<String> connectDB();
}
