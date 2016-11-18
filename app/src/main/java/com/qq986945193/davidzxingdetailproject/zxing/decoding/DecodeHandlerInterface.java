package com.qq986945193.davidzxingdetailproject.zxing.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;

import com.google.zxing.Result;
import com.qq986945193.davidzxingdetailproject.zxing.view.ViewfinderView;

/* @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
public interface DecodeHandlerInterface {

    public static final int RESULT_STATE_OK = 0;

    public void drawViewfinder();

    public ViewfinderView getViewfinderView();

    public Handler getHandler();

    public void handleDecode(Result result, Bitmap barcode);

    public void resturnScanResult(int resultCode, Intent data);

    public void launchProductQuary(String url);
}
