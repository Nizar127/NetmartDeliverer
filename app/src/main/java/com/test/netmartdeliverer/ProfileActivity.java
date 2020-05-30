package com.test.netmartdeliverer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    CardView helpProfile, inboxProfile, accountProfile, bankAccountProfile;
    TextView totalMoneyMade, totalJobComplete, rankingProfile, usernameProfile;
    CircleImageView profileImg;
    FirebaseAuth fireAuth;
    FirebaseFirestore fStore;
    FirebaseStorage fStorage;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameProfile    = findViewById(R.id.usernameProfile);
        totalMoneyMade     = findViewById(R.id.totalMoneyMadeProfile);
        totalJobComplete   = findViewById(R.id.TotalJobCompletedProfile);
        rankingProfile     = findViewById(R.id.RankingProfile);
        profileImg         = findViewById(R.id.profileImgCircle);
        helpProfile        = findViewById(R.id.helpProfile);
        inboxProfile       = findViewById(R.id.inboxProfile);
        accountProfile     = findViewById(R.id.accountProfile);
        bankAccountProfile = findViewById(R.id.bankAccountProfile);
        fireAuth           = FirebaseAuth.getInstance();
        fStore             = FirebaseFirestore.getInstance();
        fStorage           = FirebaseStorage.getInstance();

       // userID = fireAuth.getCurrentUser().getProviderId();

        //check ths signin method
        for(UserInfo user: FirebaseAuth.getInstance().getCurrentUser().getProviderData()){
            if(user.getProviderId().equals("google.com")){
                //take the login data from google
                GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
                if(signInAccount != null){
                    //take username as well as profile image
                    usernameProfile.setText(signInAccount.getDisplayName());
                    Picasso.get().load(signInAccount.getPhotoUrl()).placeholder(R.drawable.logo).into(profileImg);
                }
            }else if(user.getProviderId().equals("password")){
                userID = fireAuth.getCurrentUser().getUid();
                if(userID != null){
                    DocumentReference documentReference= fStore.collection("Users").document(userID);
                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            usernameProfile.setText(documentSnapshot.getString("User Name"));
                            //Picasso.get().load(userID)
                        }
                    });
                }
//                fireAuth.getCurrentUser().getUid();
//                DocumentReference documentReference = fStore.collection("Users").document(userID);
//                documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                        usernameProfile.setText(documentSnapshot.getString("User Name"));
//                        Picasso.get().load()
//                    }
//                });
            }
        }



        //DocumentReference documentReference = fStore.collection("Users").document(userID);
        //documentReference.addSnapshotListener(this, (document))
    }
}
