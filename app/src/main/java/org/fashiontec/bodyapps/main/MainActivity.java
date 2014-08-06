/*
 * Copyright (c) 2014, Fashiontec (http://fashiontec.org)
 * Licensed under LGPL, Version 3
 */

package org.fashiontec.bodyapps.main;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.fashiontec.bodyapps.managers.UserManager;

/**
 * Landing Screen of the app. All the functions will start from here.
 */

public class MainActivity extends Activity implements OnClickListener {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 67241c0... Formatted the code.
    private Button create;
    private Button saved;
    private Button settings;
    private Button exit;
<<<<<<< HEAD
=======
	private Button create;
	private Button saved;
	private Button settings;
	private Button exit;
=======
>>>>>>> 67241c0... Formatted the code.
    private static AlertDialog alertDialog;
>>>>>>> 113b835... Disabled "saved" and "create" if user is not logged in.

    public static final String AUTHORITY = "org.fashiontec.bodyapps.sync.provider";
    public static final String ACCOUNT_TYPE = "fashiontec.org";
    public static final String ACCOUNT = "dummyaccount";
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 67241c0... Formatted the code.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        exit=(Button)findViewById(R.id.main_btn_exit);
        exit.setOnClickListener(this);
        saved=(Button)findViewById(R.id.main_btn_saved);
        saved.setOnClickListener(this);
        settings=(Button)findViewById(R.id.main_btn_settings);
        settings.setOnClickListener(this);
        create=(Button)findViewById(R.id.main_btn_create);
        create.setOnClickListener(this);
=======
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		exit=(Button)findViewById(R.id.main_btn_exit);
		exit.setOnClickListener(this);
		saved=(Button)findViewById(R.id.main_btn_saved);
		saved.setOnClickListener(this);
		settings=(Button)findViewById(R.id.main_btn_settings);
		settings.setOnClickListener(this);
		create=(Button)findViewById(R.id.main_btn_create);
		create.setOnClickListener(this);
        if(UserManager.getInstance(getBaseContext().getApplicationContext()).getCurrent()==null){
            dialog("Login", "Go to \"Settings\" and sign in to continue.");
        }
>>>>>>> 113b835... Disabled "saved" and "create" if user is not logged in.
        if(UserManager.getInstance(getBaseContext().getApplicationContext()).getAutoSync()) {
=======
        exit = (Button) findViewById(R.id.main_btn_exit);
        exit.setOnClickListener(this);
        saved = (Button) findViewById(R.id.main_btn_saved);
        saved.setOnClickListener(this);
        settings = (Button) findViewById(R.id.main_btn_settings);
        settings.setOnClickListener(this);
        create = (Button) findViewById(R.id.main_btn_create);
        create.setOnClickListener(this);
        if (UserManager.getInstance(getBaseContext().getApplicationContext()).getCurrent() == null) {
            dialog("Login", "Go to \"Settings\" and sign in to continue.");
        }
        if (UserManager.getInstance(getBaseContext().getApplicationContext()).getAutoSync()) {
>>>>>>> 67241c0... Formatted the code.
            Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
            AccountManager accountManager = (AccountManager) this.getSystemService(ACCOUNT_SERVICE);
            accountManager.addAccountExplicitly(newAccount, null, null);
            ContentResolver.setSyncAutomatically(newAccount, AUTHORITY, true);
            ContentResolver.requestSync(newAccount, "org.fashiontec.bodyapps.sync.provider", Bundle.EMPTY);
        }
    }

    @Override
    public void onClick(View v) {
        //Handles the clicks of every Button
        Intent intent;
        switch (v.getId()) {
        case R.id.main_btn_create:
            intent=new Intent(MainActivity.this, CreateActivity.class);
            startActivity(intent);
            break;
        case R.id.main_btn_saved:
            intent=new Intent(MainActivity.this, SavedActivity.class);
            startActivity(intent);
            break;
        case R.id.main_btn_settings:
            intent=new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            break;
        case R.id.main_btn_exit:
            finish();
            break;
        }

<<<<<<< HEAD
    }
    @Override
    public void onBackPressed() {
        finish();
    }
=======
    @Override
    protected void onResume() {
        super.onResume();
        if (UserManager.getInstance(getBaseContext().getApplicationContext()).getCurrent() == null) {
            saved.setEnabled(false);
            create.setEnabled(false);
        } else {
            saved.setEnabled(true);
            create.setEnabled(true);
        }
    }

    @Override
<<<<<<< HEAD
	public void onClick(View v) {
		//Handles the clicks of every Button
		Intent intent;
		switch (v.getId()) {
		case R.id.main_btn_create:
			intent=new Intent(MainActivity.this, CreateActivity.class);
			startActivity(intent);
			break;
		case R.id.main_btn_saved:
			intent=new Intent(MainActivity.this, SavedActivity.class);
			startActivity(intent);
			break;
		case R.id.main_btn_settings:
			intent=new Intent(MainActivity.this, SettingsActivity.class);
			startActivity(intent);
			break;
		case R.id.main_btn_exit:
			finish();
			break;
		}
		
	}
	@Override
	public void onBackPressed() {
		finish();
	}
>>>>>>> 113b835... Disabled "saved" and "create" if user is not logged in.

    public void dialog(String title, String message){
=======
    public void onClick(View v) {
        //Handles the clicks of every Button
        Intent intent;
        switch (v.getId()) {
            case R.id.main_btn_create:
                intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_saved:
                intent = new Intent(MainActivity.this, SavedActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_exit:
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void dialog(String title, String message) {
>>>>>>> 67241c0... Formatted the code.

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.warning)
                .setCancelable(false)
                .setNegativeButton("Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        }
                );

        alertDialog = builder.create();
        alertDialog.show();
    }
}
