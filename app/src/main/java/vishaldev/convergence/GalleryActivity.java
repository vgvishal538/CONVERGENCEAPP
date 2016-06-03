package vishaldev.convergence;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    private ImageView selectedImageView;

    private ImageView leftArrowImageView;

    private ImageView rightArrowImageView;

    private Gallery gallery;

    private int selectedImagePosition = 0;

    private List<Drawable> drawables;

    private GalleryImageAdapter galImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("GALLERY");
        mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.backnew);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getDrawablesList();
        setupUI();
    }

    private void setupUI() {

        selectedImageView = (ImageView) findViewById(R.id.selected_imageview);
        leftArrowImageView = (ImageView) findViewById(R.id.left_arrow_imageview);
        rightArrowImageView = (ImageView) findViewById(R.id.right_arrow_imageview);
        gallery = (Gallery) findViewById(R.id.gallery);

        leftArrowImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (selectedImagePosition > 0) {
                    --selectedImagePosition;

                }

                gallery.setSelection(selectedImagePosition, false);
            }
        });

        rightArrowImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (selectedImagePosition < drawables.size() - 1) {
                    ++selectedImagePosition;

                }

                gallery.setSelection(selectedImagePosition, false);

            }
        });

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                selectedImagePosition = pos;

                if (selectedImagePosition > 0 && selectedImagePosition < drawables.size() - 1) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_enabled));
                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_enabled));

                } else if (selectedImagePosition == 0) {

                    leftArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_left_disabled));

                } else if (selectedImagePosition == drawables.size() - 1) {

                    rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
                }

                changeBorderForSelectedImage(selectedImagePosition);
                setSelectedImage(selectedImagePosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        galImageAdapter = new GalleryImageAdapter(this, drawables);

        gallery.setAdapter(galImageAdapter);

        if (drawables.size() > 0) {

            gallery.setSelection(selectedImagePosition, false);

        }

        if (drawables.size() == 1) {

            rightArrowImageView.setImageDrawable(getResources().getDrawable(R.drawable.arrow_right_disabled));
        }

    }

    private void changeBorderForSelectedImage(int selectedItemPos) {

        int count = gallery.getChildCount();

        for (int i = 0; i < count; i++) {

            ImageView imageView = (ImageView) gallery.getChildAt(i);
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.image_border));
            imageView.setPadding(3, 3, 3, 3);

        }

        ImageView imageView = (ImageView) gallery.getSelectedView();
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.selected_image_border));
        imageView.setPadding(3, 3, 3, 3);
    }

    private void getDrawablesList() {

        drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.pic16));
        drawables.add(getResources().getDrawable(R.drawable.pic23));
        drawables.add(getResources().getDrawable(R.drawable.pic17));
        drawables.add(getResources().getDrawable(R.drawable.pic4));
        drawables.add(getResources().getDrawable(R.drawable.pic5));
        drawables.add(getResources().getDrawable(R.drawable.pic6));
        drawables.add(getResources().getDrawable(R.drawable.pic7));
        drawables.add(getResources().getDrawable(R.drawable.pic19));
        drawables.add(getResources().getDrawable(R.drawable.pic20));
        drawables.add(getResources().getDrawable(R.drawable.pic10));
        drawables.add(getResources().getDrawable(R.drawable.pic22));
        drawables.add(getResources().getDrawable(R.drawable.pic12));
        drawables.add(getResources().getDrawable(R.drawable.pic13));
//        drawables.add(getResources().getDrawable(R.drawable.pic14));
//        drawables.add(getResources().getDrawable(R.drawable.pic15));
//        drawables.add(getResources().getDrawable(R.drawable.pic17));
//        drawables.add(getResources().getDrawable(R.drawable.pic18));
//        drawables.add(getResources().getDrawable(R.drawable.pic19));
//        drawables.add(getResources().getDrawable(R.drawable.pic20));
//        drawables.add(getResources().getDrawable(R.drawable.pic21));
//        drawables.add(getResources().getDrawable(R.drawable.pic22));
//        drawables.add(getResources().getDrawable(R.drawable.pic23));

    }

    private void setSelectedImage(int selectedImagePosition) {

        BitmapDrawable bd = (BitmapDrawable) drawables.get(selectedImagePosition);
        Bitmap b = Bitmap.createScaledBitmap(bd.getBitmap(), (int) (bd.getIntrinsicHeight() * 0.9), (int) (bd.getIntrinsicWidth() * 0.7), false);
        selectedImageView.setImageBitmap(b);
        selectedImageView.setScaleType(ImageView.ScaleType.FIT_XY);

    }


    public void onBackPressed() {
        super.onBackPressed();

    }


}
