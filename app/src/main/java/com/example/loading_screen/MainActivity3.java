package com.example.loading_screen;





import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;





import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Properties;




public class MainActivity3 extends AppCompatActivity {
    Spinner spinner_city2, spinner_truck;
    LottieAnimationView proceedloading;
    Button proceedbtn;
    ImageView availableimg, people1, notfound;
    LinearLayout below_bc, piaggio, jeeto, leyland;
    String nameoduser;
    String dateofpick;
    String locality_pick;
    String usermail;
    String userphnum;
    EditText edit_date;
    String pickvehicle;
    AutoCompleteTextView locality, pickupaddress, dropaddress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        spinner_truck = findViewById(R.id.spinner_truck);
        spinner_city2 = findViewById(R.id.spinner_city2);
        proceedloading = findViewById(R.id.proceedloading);
        proceedbtn = findViewById(R.id.proceedbtn);
        locality = findViewById(R.id.locality);
        below_bc = findViewById(R.id.below_bc);
        pickupaddress = findViewById(R.id.pickupaddress);
        dropaddress = findViewById(R.id.dropaddress);
        piaggio = findViewById(R.id.piaggio);
        jeeto = findViewById(R.id.jeeto);
        leyland = findViewById(R.id.leyland);
        availableimg = findViewById(R.id.availableimg);
        people1 = findViewById(R.id.people1);
        notfound = findViewById(R.id.notfound);
        edit_date = findViewById(R.id.edit_date);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String storedEmail = sharedPreferences.getString("email", null);
        String storedname = sharedPreferences.getString("name", null);
        String storedphnum=sharedPreferences.getString("phnum",null);

        if (storedname != null) {
            nameoduser = storedname;
            usermail = storedEmail;

        }
        usermail = storedEmail;
        userphnum=storedphnum;

        ArrayList<String> spinnerarray_city = new ArrayList<>();
        spinnerarray_city.add("Telangana");
        spinnerarray_city.add("Andhra Pradesh");
        spinnerarray_city.add("Bihar");
        spinnerarray_city.add("Gujarat");
        spinnerarray_city.add("TamilNadu");
        spinnerarray_city.add("Haryana");
        spinnerarray_city.add("Kerala");
        spinnerarray_city.add("Maharashtra");
        spinnerarray_city.add("Uttar Pradesh");
        spinnerarray_city.add("Rajasthan");
        spinnerarray_city.add("Madhya Pradesh");
        ArrayAdapter<String> spinnerarrayadapter = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, spinnerarray_city);
        spinner_city2.setAdapter(spinnerarrayadapter);
        ArrayList<String> arraylist_vehicle = new ArrayList<>();

        arraylist_vehicle.add("None");
        arraylist_vehicle.add("Piaggio Porter 600 Mini Truck");
        arraylist_vehicle.add("Tata Ace");
        arraylist_vehicle.add("Mahindra Jeeto");
        arraylist_vehicle.add("Ashok Leyland Dost+");
        arraylist_vehicle.add("Ashok Leyland BADA DOST");
        arraylist_vehicle.add("Mahindra Bolero Maxx Pik-Up");
        arraylist_vehicle.add("Tata Yodha Pickup");
        arraylist_vehicle.add("Tata 407 Gold SFC");
        arraylist_vehicle.add("Tata 1512 LPT");
        arraylist_vehicle.add("Tata 709g LPT");
        arraylist_vehicle.add("Mahindra Alfa Plus");
        arraylist_vehicle.add("Mahindra Furio 7 Cargo");
        arraylist_vehicle.add("Mahindra Blazo X 42 Truck");
        ArrayAdapter<String> spinnerarrayadapter2 = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, arraylist_vehicle);
        spinner_truck.setAdapter(spinnerarrayadapter2);
        proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locality_pick = locality.getText().toString();

  dateofpick=edit_date.getText().toString();

                availableimg.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        proceedloading.setVisibility(View.GONE);

                        String vehiclespinneritems = spinner_truck.getSelectedItem().toString();
                        if (vehiclespinneritems.equals(("Tata Ace"))) {
                            below_bc.setVisibility(View.VISIBLE);
                            piaggio.setVisibility(View.GONE);
                            jeeto.setVisibility(View.GONE);
                            notfound.setVisibility(View.GONE);
                            leyland.setVisibility(View.GONE);
                        } else if (vehiclespinneritems.equals(("Piaggio Porter 600 Mini Truck"))) {
                            below_bc.setVisibility(View.GONE);
                            piaggio.setVisibility(View.VISIBLE);
                            jeeto.setVisibility(View.GONE);
                            leyland.setVisibility(View.GONE);
                            notfound.setVisibility(View.GONE);
                        } else if (vehiclespinneritems.equals(("Mahindra Jeeto"))) {
                            below_bc.setVisibility(View.GONE);
                            piaggio.setVisibility(View.GONE);
                            jeeto.setVisibility(View.VISIBLE);
                            leyland.setVisibility(View.GONE);
                            notfound.setVisibility(View.GONE);
                        } else if (vehiclespinneritems.equals(("Ashok Leyland Dost+"))) {
                            below_bc.setVisibility(View.GONE);
                            piaggio.setVisibility(View.GONE);
                            jeeto.setVisibility(View.GONE);
                            leyland.setVisibility(View.VISIBLE);
                            notfound.setVisibility(View.GONE);
                        } else if (vehiclespinneritems.equals(("None"))) {
                            below_bc.setVisibility(View.GONE);
                            piaggio.setVisibility(View.GONE);
                            jeeto.setVisibility(View.GONE);
                            leyland.setVisibility(View.GONE);
                            notfound.setVisibility(View.GONE);
                            Toast.makeText(MainActivity3.this, "Please choose a vehicle", Toast.LENGTH_SHORT).show();
                        } else {
                            below_bc.setVisibility(View.GONE);
                            piaggio.setVisibility(View.GONE);
                            jeeto.setVisibility(View.GONE);
                            leyland.setVisibility(View.GONE);
                            notfound.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity3.this, "Not available", Toast.LENGTH_SHORT).show();
                        }
                        pickvehicle= spinner_truck.getSelectedItem().toString();

                        /* if (vehiclespinneritems.equals("Tata Ace")){
                            below_bc.setVisibility(View.VISIBLE);
                        }  else{
                            below_bc.setVisibility(View.GONE);
                        }

                        if (vehiclespinneritems.equals("Piaggio Porter 600 Mini Truck")) {
                            piaggio.setVisibility(View.VISIBLE);
                        }else {
                            piaggio.setVisibility(View.GONE);
                        }
                        if (vehiclespinneritems.equals("Mahindra Jeeto")) {
                            jeeto.setVisibility(View.VISIBLE);
                        }else {
                            jeeto.setVisibility(View.GONE);
                        }
                        if (vehiclespinneritems.equals("Ashok Leyland Dost+")) {
                            leyland.setVisibility(View.VISIBLE);
                        }else {
                            leyland.setVisibility(View.GONE);
                        }*/

                    }
                }, 3500);
                proceedloading.setVisibility(View.VISIBLE);
            }
        });
        ArrayList<String> autotext_locality = new ArrayList<>();
        autotext_locality.add("Hyderabad");
        autotext_locality.add("Jubilee Hills");
        autotext_locality.add("Banjara Hills");
        autotext_locality.add("Cherial Municipality");
        autotext_locality.add("Gajwel Municipality");
        autotext_locality.add("Siddipet Municipality");
        autotext_locality.add("Dubbak Municipality");
        autotext_locality.add("Adambakkam");
        autotext_locality.add("IIT Madras");
        autotext_locality.add("Ameerpet");
        autotext_locality.add("Tirumalgiri");
        autotext_locality.add("Secundrabad");

        ArrayAdapter<String> autotxtarrayadpter1 = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, autotext_locality);
        locality.setAdapter(autotxtarrayadpter1);
        locality.setThreshold(1);

        ArrayList<String> autotext_pickup = new ArrayList<>();

        autotext_pickup.add("Hyderabad");
        autotext_pickup.add("Jubilee Hills");
        autotext_pickup.add("Banjara Hills");
        autotext_pickup.add("Cherial Municipality");
        autotext_pickup.add("Gajwel Municipality");
        autotext_pickup.add("Siddipet Municipality");
        autotext_pickup.add("Dubbak Municipality");
        autotext_pickup.add("Adambakkam");
        autotext_pickup.add("IIT Madras");
        autotext_pickup.add("Ameerpet");
        autotext_pickup.add("Tirumalgiri");
        autotext_pickup.add("kodakandla");
        autotext_pickup.add("Gajwel");
        autotext_pickup.add("pregnapur");
        autotext_pickup.add("tankbund");
        autotext_pickup.add("kodangal");
        autotext_pickup.add("kamareddy");
        autotext_pickup.add("Narsapur");
        autotext_pickup.add("Jeedimetla");
        autotext_pickup.add("Manikonda");
        autotext_pickup.add("paradise");
        autotext_pickup.add("patny");
        autotext_pickup.add("Rasulpoora");
        autotext_pickup.add("kompally");
        autotext_pickup.add("Secundrabad");

        ArrayAdapter<String> autotxtarrayadpter2 = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, autotext_pickup);
        pickupaddress.setAdapter(autotxtarrayadpter2);
        pickupaddress.setThreshold(1);

        ArrayAdapter<String> autotxtarrayadpter3 = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, autotext_pickup);
        dropaddress.setAdapter(autotxtarrayadpter3);
        dropaddress.setThreshold(1);

        below_bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        piaggio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        jeeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        leyland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        dateofpick = edit_date.getText().toString();

        notfound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.setType("message/rfc822");
                mail.setPackage("com.google.android.gm");
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{"Shiftservices@eamil.com", "Shiftindia@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, " Regading fewer Vehicles");
                mail.putExtra(Intent.EXTRA_TEXT, "I hope this email finds you well. I wanted to bring to your attention a concern regarding the fewer Choice  of Vehicles for Transporting my logistics   at " + " " + locality_pick +
                        "I kindly request a review and consideration to improve the vehicles frequency Thank you for your attention to this matter. I look forward to hearing from you soon regarding the steps being taken to address this concern.  ");
                startActivity(Intent.createChooser(mail, "SHARE"));

            }
        });

    }

    public void dialog() {
        final Dialog c_dialog = new Dialog(this);
        c_dialog.setContentView(R.layout.custom_dialog_layout);
        ImageView call_dialog = c_dialog.findViewById(R.id.call_dialog);
        ImageView message_dialog = c_dialog.findViewById(R.id.message_dialog);
        ImageView booknow_dialog = c_dialog.findViewById(R.id.booknow_dialog);
        LottieAnimationView bookedsuccess = c_dialog.findViewById(R.id.bookedsuccess);
        c_dialog.setCancelable(true);
        call_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity3.this, "call", Toast.LENGTH_SHORT).show();
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:+987654321"));
                startActivity(call);
            }
        });
        message_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity3.this, "message", Toast.LENGTH_SHORT).show();
                Intent message = new Intent(Intent.ACTION_SENDTO);
                message.setData(Uri.parse("smsto:" + Uri.encode("+91987654321")));
                message.putExtra(Intent.EXTRA_TEXT, "Hello!I'm" + " " + nameoduser + " ," + "would like to Book  your Vehicle on " + " " + dateofpick);
                startActivity(message);
            }
        });
        booknow_dialog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UnlocalizedSms")
            @Override
            public void onClick(View v) {
                String phoneNumber =userphnum ; // Replace with the recipient's phone number
                String message = "Congratulations! "+" " + nameoduser +" Your booking with Shift has been successfully confirmed. ";
                String message2="Thank you for choosing Shift;Contact/Track your Vehicle here:"+" https://www.temporary-url.com/EB4B";
                        //"https://www.temporary-url.com/A14335";
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber,null,message,null,null);
                    smsManager.sendTextMessage(phoneNumber,null,message2,null,null);

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Some fields is Empty",Toast.LENGTH_LONG).show();
                }
                bookedsuccess.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                                              @Override
                                              public void run() {
                                                  Toast.makeText(MainActivity3.this, "booked Successfully", Toast.LENGTH_SHORT).show();
                                                  bookedsuccess.setVisibility(View.GONE);
                                                  c_dialog.dismiss();
                                dialogg();
                        //Intent in = new Intent(MainActivity3.this, mailempty.class);
                        //startActivity(in);
                    }
                }, 2500);
                booknow_dialog.setVisibility(View.GONE);


            }
        });
        c_dialog.show();


    }
    public void dialogg() {
        final Dialog d_dialog = new Dialog(this);
        d_dialog.setContentView(R.layout.custom_dialog_layout2);
        TextView txtview= d_dialog.findViewById(R.id.txtview);
        txtview.setText("Shift into ease with Shift! Your booking for porter services is confirmed MR/MS "+nameoduser+ " "+" Your vehicle("+ pickvehicle +") will arrive on"+" "+dateofpick +".Our team is geared up to provide top-notch support for your move. Sit back and relax while we take care of the heavy lifting. Thank you for choosing Shift ,Your satisfaction is our priority.");
        ImageView call_dialog = d_dialog.findViewById(R.id.call_dialog);
        d_dialog.setCancelable(true);
        d_dialog.show();
    }

}
