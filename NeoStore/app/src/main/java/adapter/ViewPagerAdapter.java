package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.neostore.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] imgid = new int[]
            {
                    R.drawable.slider_img1,
                    R.drawable.slider_img2,
                    R.drawable.slider_img3,
                    R.drawable.slider_img4
            };

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return imgid.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imgid[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
