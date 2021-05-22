package in.bitcode.recyclerview2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CityDetailsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        City city = (City) getIntent().getSerializableExtra(City.KEY_CITY);
        Toast.makeText(this, city.getName() + " " + city.getPopulation(), Toast.LENGTH_LONG).show();
    }
}
