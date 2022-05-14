package aligoldsmith.com;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class loginTabfragment extends Fragment {
    EditText email, passwoard, forgotpass;
    Button login;
    float v = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        email = root.findViewById(R.id.Email);
        passwoard = root.findViewById(R.id.Password);
        forgotpass = root.findViewById(R.id.forgot);
        login = root.findViewById(R.id.loginn);

        email.setTranslationY(300);
        passwoard.setTranslationY(300);
        forgotpass.setTranslationY(300);
        login.setTranslationY(300);

        email.setAlpha(v);
        passwoard.setAlpha(v);
        forgotpass.setAlpha(v);
        login.setAlpha(v);
        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwoard.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotpass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(100).start();

        View rootView = inflater.inflate(R.layout.login_tab_fragment, container,
                false);

        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        EditText email = (EditText) getView().findViewById(R.id.Email);
        EditText password = (EditText) getView().findViewById(R.id.Password);
        Button login = (Button) getView().findViewById(R.id.loginn);
        DBHelper DB = new DBHelper(getActivity());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String mail=email.getText().toString();
                String pass = password.getText().toString();


                if(mail.equals("")||pass.equals(""))
                    Toast.makeText(getActivity(),"please enter all the fields",Toast.LENGTH_SHORT).show();


                else{
                    Boolean checkuserpass =DB.checkusernamepassword(mail,pass);
                    {
                        if(checkuserpass==true){
                            email.setText("");
                            password.setText("");
                            Toast.makeText(getActivity(),"sign in successfull",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), NavigationBar.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(getActivity(),"invalid credential",Toast.LENGTH_SHORT).show();

                        }
                    }
                }

            }
        });


    }

}






