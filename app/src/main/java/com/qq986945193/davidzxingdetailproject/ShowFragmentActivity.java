package com.qq986945193.davidzxingdetailproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.qq986945193.davidzxingdetailproject.zxing.fragment.CaptureFragment;

/* @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

/**
 * fragment中集成二维码的功能
 */
public class ShowFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_fragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                new DavidFragment()).commit();
        //
        // CaptureFragment fragment = new CaptureFragment();
        // FragmentTransaction fragmentTransaction = getSupportFragmentManager()
        // .beginTransaction();
        // fragmentTransaction.replace(R.id.container, fragment, "");
        // fragmentTransaction.commit();
        //
        // MyBrodcast brodcast = new MyBrodcast();
        // IntentFilter intentFilter = new IntentFilter(
        // CaptureFragment.SCAN_RESULT_ACTION);
        // registerReceiver(brodcast, intentFilter);
    }

    public class MyBrodcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(CaptureFragment.SCAN_RESULT_ACTION)) {

                Toast.makeText(context, intent.getExtras().getString("result"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
