package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import com.licy.fontscale.widget.FontTextView;

/**
 * FontTextDelegate
 * description: TODO
 *
 * @author : Licy
 * @date : 2019/11/12
 * email ：licy3051@qq.com
 */
@SuppressLint("RestrictedApi")
public class FontTextDelegate extends AppCompatDelegateImpl {


    public FontTextDelegate(Activity activity, AppCompatCallback callback) {
        super(activity, callback);
    }

    public FontTextDelegate(Dialog dialog, AppCompatCallback callback) {
        super(dialog, callback);
    }

    public FontTextDelegate(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    public FontTextDelegate(Context context, Activity activity, AppCompatCallback callback) {
        super(context, activity, callback);
    }

    @Override
    public View createView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        if (name.equals("TextView")) {
            return new FontTextView(context, attrs);
        }
        return super.createView(parent, name, context, attrs);
    }
}
