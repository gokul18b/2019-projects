package com.kgfsl.ecampusstudent.Activity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.kgfsl.ecampusstudent.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher {
    private EditText one, two, three, four, five, six, seven, eight, nine, ten;
    private EditText mPinHiddenEditText;
    Button next;

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void hideSoftKeyboard(EditText editText) {
        if (editText == null)
            return;

        InputMethodManager imm = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void init() {
        one = (EditText) findViewById(R.id.n_1);
        two = (EditText) findViewById(R.id.n_2);
        three = (EditText) findViewById(R.id.n_3);
        four = (EditText) findViewById(R.id.n_4);
        five = (EditText) findViewById(R.id.n_5);
        six = (EditText) findViewById(R.id.n_6);
        seven = (EditText) findViewById(R.id.n_7);
        eight = (EditText) findViewById(R.id.n_8);
        nine = (EditText) findViewById(R.id.n_9);
        ten = (EditText) findViewById(R.id.n_10);
        mPinHiddenEditText = (EditText) findViewById(R.id.pin_hidden_edittext);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, OtpActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(new MainLayout(this, null));

        init();
        setPINListeners();
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        final int id = v.getId();
        switch (id) {
            case R.id.n_1:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;

            case R.id.n_2:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;

            case R.id.n_3:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;

            case R.id.n_4:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;

            case R.id.n_5:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            case R.id.n_6:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            case R.id.n_7:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            case R.id.n_8:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            case R.id.n_9:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            case R.id.n_10:
                if (hasFocus) {
                    setFocus(mPinHiddenEditText);
                    showSoftKeyboard(mPinHiddenEditText);
                }
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            final int id = v.getId();
            switch (id) {
                case R.id.pin_hidden_edittext:
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        if (mPinHiddenEditText.getText().length() == 10)
                            ten.setText("");
                        else if (mPinHiddenEditText.getText().length() == 9)
                            nine.setText("");
                        else if (mPinHiddenEditText.getText().length() == 8)
                            eight.setText("");
                        else if (mPinHiddenEditText.getText().length() == 7)
                            seven.setText("");
                        else if (mPinHiddenEditText.getText().length() == 6)
                            six.setText("");
                        else if (mPinHiddenEditText.getText().length() == 5)
                            five.setText("");
                        else if (mPinHiddenEditText.getText().length() == 4)
                            four.setText("");
                        else if (mPinHiddenEditText.getText().length() == 3)
                            three.setText("");
                        else if (mPinHiddenEditText.getText().length() == 2)
                            two.setText("");
                        else if (mPinHiddenEditText.getText().length() == 1)
                            one.setText("");

                        if (mPinHiddenEditText.length() > 0)
                            mPinHiddenEditText.setText(mPinHiddenEditText.getText().subSequence(0, mPinHiddenEditText.length() - 1));

                        return true;
                    }

                    break;

                default:
                    return false;
            }
        }

        return false;
    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        setDefaultPinBackground(one);
        setDefaultPinBackground(two);
        setDefaultPinBackground(three);
        setDefaultPinBackground(four);
        setDefaultPinBackground(five);
        setDefaultPinBackground(six);
        setDefaultPinBackground(seven);
        setDefaultPinBackground(eight);
        setDefaultPinBackground(nine);
        setDefaultPinBackground(ten);



        if (s.length() == 0) {
            setFocusedPinBackground(one);
            one.setText("");
        } else if (s.length() == 1) {
            setFocusedPinBackground(two);
            one.setText(s.charAt(0) + "");
            two.setText("");
            three.setText("");
            four.setText("");
            five.setText("");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 2) {
            setFocusedPinBackground(three);
            two.setText(s.charAt(1) + "");
            three.setText("");
            four.setText("");
            five.setText("");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 3) {
            setFocusedPinBackground(four);
            three.setText(s.charAt(2) + "");
            four.setText("");
            five.setText("");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 4) {
            setFocusedPinBackground(five);
            four.setText(s.charAt(3) + "");
            five.setText("");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 5) {
            setFocusedPinBackground(six);
            five.setText(s.charAt(4) + "");
            six.setText("");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 6) {
            setFocusedPinBackground(seven);
            six.setText(s.charAt(5) + "");
            seven.setText("");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 7) {
            setFocusedPinBackground(eight);
            seven.setText(s.charAt(6) + "");
            eight.setText("");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 8) {
            setFocusedPinBackground(nine);
            eight.setText(s.charAt(7) + "");
            nine.setText("");
            ten.setText("");
        } else if (s.length() == 9) {
            setFocusedPinBackground(ten);
            nine.setText(s.charAt(8) + "");
            ten.setText("");
        } else if (s.length() == 10) {
            setDefaultPinBackground(ten);
            ten.setText(s.charAt(9) + "");
            hideSoftKeyboard(ten);
        }
    }

    private void setDefaultPinBackground(EditText editText) {
        setViewBackground(editText, getResources().getDrawable(R.drawable.edit_default));
    }

    public static void setFocus(EditText editText) {
        if (editText == null)
            return;

        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

    private void setFocusedPinBackground(EditText editText) {
        setViewBackground(editText, getResources().getDrawable(R.drawable.edit_focus));
    }

    private void setPINListeners() {
        mPinHiddenEditText.addTextChangedListener(this);

        one.setOnFocusChangeListener(this);
        two.setOnFocusChangeListener(this);
        three.setOnFocusChangeListener(this);
        four.setOnFocusChangeListener(this);
        five.setOnFocusChangeListener(this);
        six.setOnFocusChangeListener(this);
        seven.setOnFocusChangeListener(this);
        eight.setOnFocusChangeListener(this);
        nine.setOnFocusChangeListener(this);
        ten.setOnFocusChangeListener(this);

        one.setOnKeyListener(this);
        two.setOnKeyListener(this);
        three.setOnKeyListener(this);
        four.setOnKeyListener(this);
        five.setOnKeyListener(this);
        six.setOnKeyListener(this);
        seven.setOnKeyListener(this);
        eight.setOnKeyListener(this);
        nine.setOnKeyListener(this);
        ten.setOnKeyListener(this);
        mPinHiddenEditText.setOnKeyListener(this);
    }

    public void setViewBackground(View view, Drawable background) {
        if (view == null || background == null)
            return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    public void showSoftKeyboard(EditText editText) {
        if (editText == null)
            return;

        InputMethodManager imm = (InputMethodManager) getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, 0);
    }


    public class MainLayout extends LinearLayout {

        public MainLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.activity_forgot_password, this);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            final int proposedHeight = MeasureSpec.getSize(heightMeasureSpec);
            final int actualHeight = getHeight();

            Log.d("TAG", "proposed: " + proposedHeight + ", actual: " + actualHeight);

            if (actualHeight >= proposedHeight) {
                // Keyboard is shown
                if (mPinHiddenEditText.length() == 0)
                    setFocusedPinBackground(one);
                else
                    setDefaultPinBackground(one);
            }

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
