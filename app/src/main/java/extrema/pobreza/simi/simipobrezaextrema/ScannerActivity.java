package extrema.pobreza.simi.simipobrezaextrema;

import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import extrema.pobreza.simi.simipobrezaextrema.dialog.WriteFolioDialog;

public class ScannerActivity extends AppCompatActivity implements detailScaner.OnDetailListener {

    private CodeScannerView codeScannerView;
    private CodeScanner codeScanner;
    private BottomSheetBehavior mBottomSheet;
    private View vBottomSheet;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        initViews();
        configBottomSheetNotification();
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });

                //Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();ç
            }
        });
        setToolbar();
    }
    public void initViews(){
        codeScannerView = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this,codeScannerView);
        toolbar = findViewById(R.id.scaner_toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scaner_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }




    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        codeScanner.releaseResources();
    }

    public void setToolbar(){
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Escanear");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.scaner_meni_write:
                showWriteFolioDialog();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    public void configBottomSheetNotification(){
        vBottomSheet = findViewById(R.id.content_scan_result);
        mBottomSheet = BottomSheetBehavior.from(vBottomSheet);
        mBottomSheet.setPeekHeight(0);
        mBottomSheet.setHideable(true);
        mBottomSheet.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_scan_result,new detailScaner())
                                .commit();
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:

                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        codeScanner.startPreview();
                        break;
                }
            }



            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public AlertDialog showWriteFolioDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_write_folio,null);
        builder.setView(v);
        builder.setCancelable(false);


        builder.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mBottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.create();
        return builder.show();
    }


    public void showWriteDialog(){
        WriteFolioDialog folioDialog = new WriteFolioDialog();

        folioDialog.show(getFragmentManager(),"dialog");

    }

    @Override
    public void onClose() {
        mBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}