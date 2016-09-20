package za.co.example.admin.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * global variables.
     */
    int quantity = 1;
    String setxt;

    /**
     * This method increment the quantity of coffee ordered.
     */
    public void increment(View view) {
        if (quantity == 100.0) {
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method decrement the quantity of coffee ordered.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays and confirm the price.
     */
    public void submitOrder(View view) {
        String name=displayName(setxt);
        CheckBox wc = (CheckBox) findViewById(R.id.whip_cream_chechBox);
        boolean hasWhippedcream = wc.isChecked();

        CheckBox cl = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = cl.isChecked();

        double price = calculatePrice(quantity);
        String message = "ORDER SUMMARY\n\n";
        message += "\nName: " + name  ;
        if (hasWhippedcream) {
            message += "\nAdd whipped cream.";
        }
        if (hasChocolate) {
            message += "\nAdd chocolate.";
        }
        message+= "\nQuantity: "+ quantity;
        message += "\nTotal: R" + price;
        message += "\nThank you!";
        display(quantity);
        displayMessage(message);
    }

    /**
     * This method is used to display the price.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("" + number);
    }

    /**
     * This method calculates the price.
     */
    private double calculatePrice(double num) {
        double givprice = quantity * 3.24;
        return givprice;
    }

    /**
     * This method is used to display the name of the person placing an order.
     */
    private String displayName(String nam) {
        EditText txtname=(EditText)findViewById(R.id.editxt_name) ;

        setxt = txtname.getText().toString();
        return setxt;
    }
}
