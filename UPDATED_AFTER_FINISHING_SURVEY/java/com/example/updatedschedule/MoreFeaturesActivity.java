package com.example.updatedschedule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MoreFeaturesActivity extends AppCompatActivity {
    private Button Subscription, YourTherapist, MyAccount, Faq, ContactUs, Terms, Privacy, Logout;
    private ImageView navChat, navCalendar, navGroup, navMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_features);

        // Initialize Buttons
        Subscription = findViewById(R.id.button_subscription);
        YourTherapist = findViewById(R.id.your_therapist);
        MyAccount = findViewById(R.id.button_my_account);
        Faq = findViewById(R.id.button_faq);
        ContactUs = findViewById(R.id.button_contact_us);
        Terms = findViewById(R.id.button_terms_conditions);
        Privacy = findViewById(R.id.button_privacy_policy);
        Logout = findViewById(R.id.button_logout);

        // Set Click Listeners for Navigation
        Subscription.setOnClickListener(v -> openActivity(SubscriptionActivity.class));
        YourTherapist.setOnClickListener(v -> openActivity(YourTherapistActivity.class));
        MyAccount.setOnClickListener(v -> openActivity(MyAccountActivity.class));
        Faq.setOnClickListener(v -> openActivity(FaqActivity.class));
        ContactUs.setOnClickListener(v -> openActivity(ContactUsActivity.class));
        Terms.setOnClickListener(v -> openActivity(TermsActivity.class));
        Privacy.setOnClickListener(v -> openActivity(PrivacyPolicyActivity.class));

        // Logout Button Click
        Logout.setOnClickListener(v -> {
            Intent intent = new Intent(MoreFeaturesActivity.this, PrivateMessageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        setupBottomNavigation();
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    private void setupBottomNavigation() {
        navChat = findViewById(R.id.nav_chat);
        navCalendar = findViewById(R.id.nav_calendar);
        navGroup = findViewById(R.id.nav_group);
        navMore = findViewById(R.id.nav_more);

        navChat.setOnClickListener(v -> startActivity(new Intent(this, PrivateMessageActivity.class)));
        navCalendar.setOnClickListener(v -> startActivity(new Intent(this, ScheduleActivity.class)));
        navGroup.setOnClickListener(v -> startActivity(new Intent(this, GroupSessionActivity.class)));
        navMore.setOnClickListener(v -> startActivity(new Intent(this, MoreFeaturesActivity.class)));
    }
}
