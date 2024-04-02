package data.dao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.duchoang.doan.ChiTietSanPham;
import org.duchoang.doan.TrangChu;
import data.model.DienThoai;
import data.model.User;
import org.duchoang.doan.R;
import ui.adapter.DienthoaiAdapter;
import util.Server;
import ui.adapter.UserAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DanhSachUser_Admin extends AppCompatActivity {

    ImageView trove;
    TextView chitiet;
    ListView listView;
    ArrayList<User> userArrayList = new ArrayList<>();
    UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_user_admin);
        listView = findViewById(R.id.mylistview_DanhsachUserAdmin);
        adapter= new UserAdapter(this,userArrayList);
        listView.setAdapter(adapter);
        getdata();

        trove = (ImageView) findViewById(R.id.IV_BackToHome);
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Admin.class);
                finish();
                startActivity(intent);
            }
        });

    }
    public  void getdata(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Server.getalluser, response -> {
            userArrayList.clear();
            int     id = 0;
            String name = "";
            String birthday = "";
            String phone = "";
            String email = "";
            String gender = "";
            String pass = "";
            int type = 0;
            try {
                JSONArray jsonArray = new JSONArray(response);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    id =  jsonObject.getInt("iduser");
                    name = jsonObject.getString("nameuser");
                    birthday = jsonObject.getString("birthday");
                    phone = jsonObject.getString("phone");
                    email= jsonObject.getString("email");
                    gender = jsonObject.getString("gender");
                    pass  = jsonObject.getString("password");
                    type =  jsonObject.getInt("typeuser");
                    userArrayList.add(new User(id,name,birthday,phone,email, gender, pass,type));
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Toast.makeText(getApplicationContext(), "Lỗi " + error.toString(), Toast.LENGTH_SHORT).show());

        requestQueue.add(stringRequest);
    }
    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(),TrangChu.class));
    }
}