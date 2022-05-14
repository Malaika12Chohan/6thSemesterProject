package aligoldsmith.com;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularimageview.CircularImageView;

import aligoldsmith.com.Database.OrderContract;

public class InfoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    CircularImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, drinnkName, coffeePrice;
    CheckBox addPolish, addOthers;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        drinnkName = findViewById(R.id.NameinInfo);
        coffeePrice = findViewById(R.id.jwPrice);
        addPolish = findViewById(R.id.addPolish);
        addtoCart = findViewById(R.id.addtocart);
        addOthers = findViewById(R.id.addOthers);

        // setting the name of drink

        drinnkName.setText("Silver Items");

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, Thankyou.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 50;
                quantity++;
                displayQuantity();
                int coffePrice = basePrice * quantity;
                String setnewPrice = String.valueOf(coffePrice);
                coffeePrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = CalculatePrice(addOthers, addPolish);
                coffeePrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 50;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(InfoActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int coffePrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(coffePrice);
                    coffeePrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(addOthers, addPolish);
                    coffeePrice.setText("$ " + ifCheckBox);
                }
            }
        });


    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = drinnkName.getText().toString();
        String price = coffeePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (addOthers.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_POLISH, "Has Other Services: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_POLISH, ":Has Polish NO");

        }

        if (addPolish.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_OTHER, "Has Polish: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_OTHER, "Has Other Services: NO");

        }

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox Polish, CheckBox Other) {

        int basePrice = 50;

        if (Polish.isChecked()) {
            // add the cream cost $2
            basePrice = basePrice + 20;
        }

        if (Other.isChecked()) {
            // topping cost is $3
            basePrice = basePrice + 30;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_POLISH,
                OrderContract.OrderEntry.COLUMN_OTHER
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int polish = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_POLISH);
            int other = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_OTHER);


            String nameofjwel = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);
            String Polish = cursor.getString(polish);
            String Other = cursor.getString(other);

            drinnkName.setText(nameofjwel);
            coffeePrice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        drinnkName.setText("");
        coffeePrice.setText("");
        quantitynumber.setText("");

    }
}