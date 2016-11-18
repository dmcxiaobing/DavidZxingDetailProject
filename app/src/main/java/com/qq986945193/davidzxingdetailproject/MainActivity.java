package com.qq986945193.davidzxingdetailproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.qq986945193.davidzxingdetailproject.zxing.activity.CaptureActivity;
import com.qq986945193.davidzxingdetailproject.zxing.encoding.EncodingHandler;

/* @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private EditText qrStrEditText;
    private ImageView qrImgImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        /**
         * 进入fragment进行扫描
         */
        Button startBarCodeFragmentBtn = (Button) findViewById(R.id.btn_scan_barcode_fragment);
        startBarCodeFragmentBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,
                        ShowFragmentActivity.class));
            }
        });

        /**
         * 直接在activity中打开摄像头
         */
        Button scanBarCodeButton = (Button) this
                .findViewById(R.id.btn_scan_barcode);
        scanBarCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 打开扫描界面扫描条形码或二维码
                Intent openCameraIntent = new Intent(MainActivity.this,
                        CaptureActivity.class);
                startActivityForResult(openCameraIntent, 0);
            }
        });
        /**
         * 点击生成二维码
         */
        Button generateQRCodeButton = (Button) this
                .findViewById(R.id.btn_add_qrcode);
        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String contentString = qrStrEditText.getText().toString();
                    if (!contentString.equals("")) {
                        // 根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                        Bitmap qrCodeBitmap = EncodingHandler.createQRCode(
                                contentString, 350);
                        qrImgImageView.setImageBitmap(qrCodeBitmap);
                    } else {
                        Toast.makeText(MainActivity.this,
                                "内容为空了", Toast.LENGTH_SHORT)
                                .show();
                    }

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理扫描结果（在界面上显示）
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            resultTextView.setText(scanResult);
        }
    }
}
