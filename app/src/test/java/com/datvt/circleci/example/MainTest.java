package com.datvt.circleci.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.junit.*;
import org.junit.runner.*;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainTest {

    private MainActivity mMainActivity;

    private EditText valueX, valueY;

    private TextView result;

    private Button addButton;


    @Before
    public void setUp() {
        mMainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
        // khởi tạo các thành phần sử dụng trong activity
        valueX = mMainActivity.findViewById(R.id.edt_x);
        valueY = mMainActivity.findViewById(R.id.edt_y);
        result = mMainActivity.findViewById(R.id.tv_sum);
        addButton = mMainActivity.findViewById(R.id.btn_ok);
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(mMainActivity);
        assertNotNull(valueX);
        assertNotNull(valueY);
        assertNotNull(result);
        assertNotNull(addButton);
    }

    // test case kiểm tra giá trị nhập vào là 1 số nguyên
    @Test
    public void testInputValue() throws Exception {
        assertThat(TextUtils.isDigitsOnly(valueX.getText()), equalTo(true));
        assertThat(TextUtils.isDigitsOnly(valueY.getText()), equalTo(true));
    }

    //test case kiểm tra kết quả là chính xác khi nhập (8 + 1  = 7)
    @Test
    public void testResult() throws Exception {
        valueX.setText("8");
        valueY.setText("1");
        addButton.performClick();
        assertThat(result.getText().toString(), equalTo("9"));
    }
}
