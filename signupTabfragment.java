package aligoldsmith.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class signupTabfragment extends Fragment {
    EditText email, username,passwoard, cnfrmpass;
    Button signup;
    float v = 0;
    DBHelper DB;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);
        email = root.findViewById(R.id.Email);
        username = root.findViewById(R.id.Username);
        passwoard = root.findViewById(R.id.Password);
        cnfrmpass = root.findViewById(R.id.CnfrmPassword);
        signup = root.findViewById(R.id.signup);

        email.setTranslationY(300);
        username.setTranslationY(300);
        passwoard.setTranslationY(300);
        cnfrmpass.setTranslationY(300);
        signup.setTranslationY(300);

        email.setAlpha(v);
        username.setAlpha(v);
        passwoard.setAlpha(v);
        cnfrmpass.setAlpha(v);
        signup.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        passwoard.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        cnfrmpass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();
        signup.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        return root;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        EditText email = (EditText) getView().findViewById(R.id.Email);
        EditText username = (EditText) getView().findViewById(R.id.Username);
        EditText password = (EditText) getView().findViewById(R.id.Password);
        EditText cnfrmpass = (EditText) getView().findViewById(R.id.CnfrmPassword);
        Button signup = (Button) getView().findViewById(R.id.signup);
        DBHelper DB = new DBHelper(getActivity());
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String cnpass = cnfrmpass.getText().toString();

                if (mail.equals(" ") || user.equals(" ") || pass.equals("") || cnpass.equals(""))
                    Toast.makeText(getActivity(),"please enter all the fields",Toast.LENGTH_SHORT).show();
                else {

                    if(pass.equals(cnpass)){
                        Boolean checkuser = DB.checkusername(mail);
                        if (checkuser==false){
                            Boolean insert =DB.insertData(mail,pass);
                            if (insert==true){
                                email.setText("");
                                username.setText("");
                                password.setText("");
                                cnfrmpass.setText("");

                                Toast.makeText(getActivity(),"SignUp successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getActivity(),"SignUp failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            Toast.makeText(getActivity(),"user already exists please sign in ",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getActivity(),"password not matching",Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });




    }
}
