package com.droidfactory.skp.realmsamples.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.droidfactory.skp.realmsamples.R;
import com.droidfactory.skp.realmsamples.db.User;
import com.droidfactory.skp.realmsamples.pref.SharedPrefUtils;
import com.droidfactory.skp.realmsamples.view.movie.TopRatedMovieListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "Stetho_Sample";

    @BindView(R.id.edit_text_name)
    EditText editTextName;

    @BindView(R.id.edit_text_age)
    EditText editTextAge;

    @BindView(R.id.btn_save)
    Button btnSave;

    @BindView(R.id.check_box_pref)
    CheckBox checkBoxPref;

    @BindView(R.id.btn_movie_service_call)
    Button btnTestServiceCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);
        Realm.init(MainActivity.this);
    }

    @OnClick(R.id.btn_save)
    public void saveData(View view) {

        Realm realm = Realm.getDefaultInstance();

        final User obj = new User();
        obj.setName(editTextName.getText().toString());
        obj.setAge(Integer.parseInt(editTextAge.getText().toString()));

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealmOrUpdate(obj);
            }
        });
    }

    @OnClick(R.id.check_box_pref)
    public void updatePref(View view) {
        boolean currentPrefValue = (Boolean) SharedPrefUtils.getPreferenceValue(MainActivity.this,
                SharedPrefUtils.CHECK_BOX_PREF,
                false);
        SharedPrefUtils.updatePreferenceValue(MainActivity.this,
                SharedPrefUtils.CHECK_BOX_PREF,
                !currentPrefValue);
    }

    @OnClick(R.id.btn_movie_service_call)
    public void callMovieListScreen(View view) {
        Intent intent = new Intent(this, TopRatedMovieListActivity.class);
        startActivity(intent);
    }
}
