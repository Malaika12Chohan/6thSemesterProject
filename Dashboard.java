package aligoldsmith.com;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Dashboard extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        CardView about = (CardView) getActivity().findViewById(R.id.aboutus);
        CardView category = (CardView) getActivity().findViewById(R.id.Category);
        CardView contact = (CardView) getActivity().findViewById(R.id.Contact);
        CardView review = (CardView) getActivity().findViewById(R.id.cardreview);
        CardView shop = (CardView) getActivity().findViewById(R.id.Shop);
        CardView home = (CardView) getActivity().findViewById(R.id.home1);
        CardView cart = (CardView) getActivity().findViewById(R.id.addTOcart);
        CardView favour = (CardView) getActivity().findViewById(R.id.favr);





        about.setOnClickListener(this);
        category.setOnClickListener(this);
        contact.setOnClickListener(this);
        review.setOnClickListener(this);
        shop.setOnClickListener(this);
        home.setOnClickListener(this);
        cart.setOnClickListener(this);
        favour.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aboutus:
                Intent intent1 = new Intent(getActivity(), aboutuspage.class);
                startActivity(intent1);
                break;
            case R.id.Category:
                Intent i2 = new Intent(getActivity(), Categories.class);
                startActivity(i2);

                break;
            case R.id.Contact:
                Intent in3 = new Intent(getActivity(), ContactUs.class);
                startActivity(in3);

                break;
            case R.id.cardreview:
                Intent inte4 = new Intent(getActivity(), Review.class);
                startActivity(inte4);

                break;
            case R.id.Shop:
                Intent iIntent5 = new Intent(v.getContext(), MainActivity.class);
                startActivity(iIntent5);

                break;
            case R.id.home1:
                Intent iIntenty6 = new Intent(v.getContext(), MainActivity1.class);
                startActivity(iIntenty6);
                break;
            case R.id.addTOcart:
                Intent iIntenty7 = new Intent(v.getContext(), SummaryActivity.class);
                startActivity(iIntenty7);
                break;
            case R.id.favr:
                Intent iIntenty8 = new Intent(v.getContext(), fav.class);
                startActivity(iIntenty8);



        }

    }
}
