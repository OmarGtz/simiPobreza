package extrema.pobreza.simi.simipobrezaextrema;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class ScannerActivity extends AppCompatActivity {

    private CodeScannerView codeScannerView;
    private CodeScanner codeScanner;

    private BottomSheetBehavior mBottomSheet;
    private View vBottomSheet;

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

                //Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initViews(){
        codeScannerView = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this,codeScannerView);
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
}