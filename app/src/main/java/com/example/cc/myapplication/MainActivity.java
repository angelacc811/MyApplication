package com.example.cc.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import okhttp3.Call;
import okhttp3.Response;
import pl.droidsonroids.gif.GifImageView;
/**
 * @ClassName: MainActivity
 * @Description: 主页
 * @author chun.chen@wonhe.net
 * @date 2017/7/12
 */
public class MainActivity extends Activity implements View.OnClickListener{
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        GifImageView testgif = (GifImageView) findViewById(R.id.testgif);
//        testgif.setImageResource(R.mipmap.giftest);
        Button get=(Button)findViewById(R.id.get);
        Button post=(Button)findViewById(R.id.post);
         show=(TextView)findViewById(R.id.show);
        get.setOnClickListener(this);
        post.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
      switch (view.getId())
      {
          case R.id.get:
              getByOkGo( "http://woc.netcatdisplay.com/Api/Login/getMsg?phone=17091637412");
              break;
          case R.id.post:
              postByOkGo("http://dev.woc.netcatdisplay.com/Api/Login/getMsg");
              break;
      }
    }
    /**
     * @methodName: getByOkGo
     * @Description: get请求
     * @param:  url
     * @return:  void
     * @author chun.chen@wonhe.net
     * @date 2017/7/12
     */
    private void getByOkGo(String url){
        OkGo.get(url)                            // 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        show.setText(s);
                    }
                });
    }
    /**
     * @methodName: postByOkGo
     * @Description: post请求
     * @param:  url
     * @return:  void
     * @author chun.chen@wonhe.net
     * @date 2017/7/12
     */
    private void postByOkGo(String url){
        OkGo.post(url)
                .tag(this)
                .cacheKey("cachePostKey")
                .cacheMode(CacheMode.DEFAULT)
                .params("phone", "17091637412")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        show.setText(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        show.setText(e.getMessage());
                    }
                });

    }
}
//我是个小等等
