package com.example.zemikone.retrofit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zemikone.retrofit.Interface.DataResultInterface;
import com.example.zemikone.retrofit.Model.ApiResponse;
import com.example.zemikone.retrofit.Repository.Repository;

public class Home extends AppCompatActivity implements DataResultInterface {

    EditText responseText, ingredientText;
    Button btnDownload;
    String names;
    DataResultInterface dataResultInterface;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataResultInterface = this;
        responseText = (EditText) findViewById(R.id.textRespone);
        ingredientText = (EditText) findViewById(R.id.textIngredients);
        btnDownload = (Button) findViewById(R.id.buttonDownlaod);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                names = ingredientText.getText().toString();
                Repository repository=new Repository();
                repository.setContext(getApplicationContext());
                repository.getRecipesList(dataResultInterface,names);
            }
        });
    }

    @Override
    public void dataReceived(ApiResponse apiResponse) {
        responseText.setText(String.valueOf(apiResponse.recipes.get(0).getTitle()));
    }

    @Override
    public void dataFailed() {
        Toast.makeText(getApplicationContext(),"Download Failed",Toast.LENGTH_LONG);
    }
}
