package za.co.example.admin.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
            Toast.makeText(this, "We take orders in 100s", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(this, "Please order atleast one coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }



    /**
     * This method displays and confirm the price.
     */
    public void submitOrder(View view) {
            EditText txtname=(EditText)findViewById(R.id.editxt_name) ;
            String name = txtname.getText().toString();
        CheckBox wc = (CheckBox) findViewById(R.id.whip_cream_chechBox);
        boolean hasWhippedcream = wc.isChecked();

        CheckBox cl = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = cl.isChecked();

        double price = calculatePrice(quantity);
        String message = "ORDER SUMMARY\n";
        message += "\nName: " + name  ;
        if (hasWhippedcream) {
            message += "\nAdd whipped cream.";
            price*=1.3;
        }
        if (hasChocolate) {
            message += "\nAdd chocolate.";
            price*=1.7;
        }
        message+= "\nQuantity: "+ quantity;
        message += "\nTotal: R" + price;
        message += "\nThank you!";
        display(quantity);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        String mess = ""+number;
        quantityTextView.setText(mess);
    }

    /**
     * This method calculates the price.
     */
    private double calculatePrice(double num) {
        double discount = 0;

        if(quantity<10){
        discount=0;}
        if (quantity>=10&&quantity<25){
            discount=0.08;}
        if(quantity>=25&&quantity<50){
            discount=0.15;}
        if (quantity>=50) {
            discount=0.2;}

        double price = quantity*8.50;
        num= price-(price*discount);
        return num;
    }


}
