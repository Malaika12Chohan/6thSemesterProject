package aligoldsmith.com;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactUs extends AppCompatActivity {


    EditText et_To,et_subject,et_Message;
    Button btSend;
    String sEmail,sPassword;
    private android.app.ProgressDialog ProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        et_To=findViewById(R.id.et_To);
        et_subject=findViewById(R.id.et_subject);
        et_Message=findViewById(R.id.et_Message);
        btSend=findViewById(R.id.btSend);

        sEmail="amgb922@gmail.com";
        sPassword="Pakistan3637";


        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Properties properties=new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");


                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });

                try {
                    Message message= new MimeMessage(session);

                    message.setFrom(new InternetAddress(sEmail));

                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(et_To.getText().toString().trim()));

                    message.setText(et_Message.getText().toString().trim());

                    message.setSubject(et_subject.getText().toString().trim());

                    new SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }


            }
        });




    }

    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            ProgressDialog = ProgressDialog.show(ContactUs.this
                    ,"please wait","Sending Mail---",true,false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {

                e.printStackTrace();
                return "Error";
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ProgressDialog.dismiss();
            if (s.equals("Success")){


                AlertDialog.Builder builder=new AlertDialog.Builder(ContactUs.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setMessage("Mail send successfully.");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        et_To.setText("");
                        et_subject.setText("");
                        et_Message.setText("");
                        Intent intent = new Intent(ContactUs.this, Thankyou.class);
                        startActivity(intent);

                    }
                });

                builder.show();
            }else {
                Toast.makeText(getApplicationContext()
                        , "something went wrong?", Toast.LENGTH_SHORT).show();
            }
        }
    }
}