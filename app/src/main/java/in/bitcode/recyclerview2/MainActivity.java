package in.bitcode.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCities;
    private ArrayList<City> mListCities;
    private CitiesAdapter mCitiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    private void init() {
        setContentView(R.layout.activity_main);

        mRecyclerCities = findViewById(R.id.recyclerCities);
        mRecyclerCities.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mListCities = new ArrayList<>();
        mListCities.add(new City("Pune", 6000000, R.drawable.img1));
        mListCities.add(new City("Mumbai", 1560000, R.drawable.img2));
        mListCities.add(new City("Nagpur", 500000, R.drawable.img3));
        mListCities.add(new City("Nashik", 6000000, R.drawable.img4));
        mListCities.add(new City("Kolhapur", 6000000, R.drawable.img5));
        mListCities.add(new City("Pimpri", 6000000, R.drawable.img7));
        mListCities.add(new City("Chinchwad", 6000000, R.drawable.img8));
        mListCities.add(new City("Satara", 6000000, R.drawable.img8));
        mListCities.add(new City("Amravati", 6000000, R.drawable.img1));
        mListCities.add(new City("Akola", 6000000, R.drawable.img2));
        mListCities.add(new City("Jalna", 6000000, R.drawable.img3));
        mListCities.add(new City("Sangli", 6000000, R.drawable.img4));
        mListCities.add(new City("Gadhinglaj", 6000000, R.drawable.img5));

        mCitiesAdapter = new CitiesAdapter(this, mListCities);
        mCitiesAdapter.setOnCityClickListener(new MyOnCityClickListener());
        mRecyclerCities.setAdapter(mCitiesAdapter);
    }

    private class MyOnCityClickListener implements CitiesAdapter.OnCityClickListener {
        @Override
        public void onCityImageClick(int position, ImageView imageView) {
            City cityClicked = mListCities.get(position);

            if( cityClicked.isSelected()) {
                imageView.setPadding(0, 0, 0, 0);
                imageView.setBackgroundColor(Color.WHITE);
                Snackbar.make(mRecyclerCities, "City Image clicked...", Snackbar.LENGTH_LONG)
                        .show();
                cityClicked.setSelected(false);
            }
            else {
                imageView.setPadding(20, 20, 20, 20);
                imageView.setBackgroundColor(Color.RED);
                Snackbar.make(mRecyclerCities, "City Image clicked...", Snackbar.LENGTH_LONG)
                        .show();
                cityClicked.setSelected(true);
            }
        }

        @Override
        public void onCityNameClick(int position, TextView textView) {
            textView.setBackgroundColor(Color.GRAY);
            Intent intent = new Intent(MainActivity.this, CityDetailsActivity.class);
            intent.putExtra(City.KEY_CITY, mListCities.get(position));
            startActivity(intent);
        }
    }
}