package com.gridmi.weather_test.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gridmi.weather_test.R;
import com.gridmi.weather_test.dtos.CityDto;
import com.gridmi.weather_test.tools.API;

import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setAdapter(new RecyclerViewAdapter());

    }

    public static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RV> {

        private static final ArrayList<String> cities = new ArrayList<String>() {{
            add("Ahmedabad");
            add("Alexandria");
            add("Atlanta");
            add("Baghdad");
            add("Bangalore");
            add("Bangkok");
            add("Barcelona");
            add("Beijing");
            add("Belo Horizonte");
            add("Bogotá");
            add("Buenos Aires");
            add("Cairo");
            add("Chengdu");
            add("Chennai");
            add("Chicago");
            add("Chongqing");
            add("Dalian");
            add("Dallas");
            add("Dar es Salaam");
            add("Delhi");
            add("Dhaka");
            add("Dongguan");
            add("Foshan");
            add("Fukuoka");
            add("Guadalajara");
            add("Guangzhou");
            add("Hangzhou");
            add("Harbin");
            add("Ho Chi Minh City");
            add("Hong Kong");
            add("Houston");
            add("Hyderabad");
            add("Istanbul");
            add("Jakarta");
            add("Jinan");
            add("Johannesburg");
            add("Karachi");
            add("Khartoum");
            add("Kinshasa");
            add("Kolkata");
            add("Kuala Lumpur");
            add("Lagos");
            add("Lahore");
            add("Lima");
            add("London");
            add("Los Angeles");
            add("Luanda");
            add("Madrid");
            add("Manila");
            add("Mexico City");
            add("Miami");
            add("Moscow");
            add("Mumbai");
            add("Nagoya");
            add("Nanjing");
            add("New York City");
            add("Osaka");
            add("Paris");
            add("Philadelphia");
            add("Pune");
            add("Qingdao");
            add("Rio de Janeiro");
            add("Riyadh");
            add("Saint Petersburg");
            add("Santiago");
            add("São Paulo");
            add("Seoul");
            add("Shanghai");
            add("Shenyang");
            add("Shenzhen");
            add("Singapore");
            add("Surat");
            add("Suzhou");
            add("Tehran");
            add("Tianjin");
            add("Tokyo");
            add("Toronto");
            add("Washington, D.C.");
            add("Wuhan");
            add("Xi'an");
            add("Yangon");
        }};

        @NonNull
        @Override
        public RV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RV(View.inflate(parent.getContext(), R.layout.activity_item, null));
        }

        @Override
        public void onBindViewHolder(@NonNull final RV holder, int position) {
            API.loadForName(cities.get(position), item -> {
                holder.cityView.setText(item.getName());
                holder.temperatureView.setText(String.format(Locale.getDefault(), "%.2f °F", item.getMain().getTemp()));
            }, error -> {
                holder.cityView.setText(cities.get(position));
                holder.temperatureView.setText(error.toString());
            });
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }

        public static class RV extends RecyclerView.ViewHolder {

            private final TextView cityView;
            private final TextView temperatureView;

            public RV(@NonNull View itemView) {
                super(itemView);
                cityView = itemView.findViewById(R.id.city);
                temperatureView = itemView.findViewById(R.id.temperature);
            }

        }

    }



}