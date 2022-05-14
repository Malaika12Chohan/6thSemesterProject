package aligoldsmith.com;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import aligoldsmith.com.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView Name, Polish, Other, price, quantity;


        Name = view.findViewById(R.id.NameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        Polish = view.findViewById(R.id.hasPolish);
        Other = view.findViewById(R.id.hasOther);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        int nameofjwell = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofjwell = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofjwell = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int haspolish = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_POLISH);
        int hasother = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_OTHER);


        String nameofjwellss = cursor.getString(nameofjwell);
        String pricesofjwells = cursor.getString(priceofjwell);
        String quantitysofjwells = cursor.getString(quantityofjwell);
        String yeshaspolish = cursor.getString(haspolish);
        String yeshasother = cursor.getString(hasother);



        Name.setText(nameofjwellss);
        price.setText(pricesofjwells);
        quantity.setText(quantitysofjwells);
        Polish.setText(yeshaspolish);
        Other.setText(yeshasother);



    }
}
