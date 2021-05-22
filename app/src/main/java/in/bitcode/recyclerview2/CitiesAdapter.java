package in.bitcode.recyclerview2;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private Context mContext;
    private ArrayList<City> mListCities;

    public CitiesAdapter(Context context, ArrayList<City> listCities) {
        mContext = context;
        mListCities = listCities;
    }

    class CityViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mContainer;
        ImageView mImgCity;
        TextView mTxtCityName, mTxtCityPopulation;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = (RelativeLayout) itemView;
            mImgCity = mContainer.findViewById(R.id.imgCity);
            mTxtCityName = mContainer.findViewById(R.id.txtCityName);
            mTxtCityPopulation = mContainer.findViewById(R.id.txtCityPopulation);

            mImgCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(
                            view,
                            "Nice Image: " + mListCities.get(getAdapterPosition()).getName(),
                            Snackbar.LENGTH_LONG
                    ).show();
                }
            });

            mTxtCityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, CityDetailsActivity.class);
                    intent.putExtra(City.KEY_CITY, mListCities.get(getAdapterPosition()) );
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mListCities == null) {
            return 0;
        }

        return mListCities.size();
    }

    @NonNull

    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.city_view, null);

        return new CityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CitiesAdapter.CityViewHolder holder, int position) {
        City city = mListCities.get(position);

        holder.mImgCity.setImageResource(city.getImageId());
        holder.mTxtCityName.setText(city.getName());
        holder.mTxtCityPopulation.setText(city.getPopulation() + "");
    }
}
