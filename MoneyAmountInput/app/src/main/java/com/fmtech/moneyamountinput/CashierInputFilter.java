package com.fmtech.moneyamountinput;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ==================================================================
 * Copyright (C) 2016 FMTech All Rights Reserved.
 *
 * @author Drew.Chiang
 * @version v1.0.0
 * @create_date 16/7/11 10:54
 * @description ${todo}
 * <p/>
 * Modification History:
 * Date            Author            Version         Description
 * -----------------------------------------------------------------
 * 16/7/11 10:54  Drew.Chiang       v1.0.0          create
 * <p/>
 * ==================================================================
 */
public class CashierInputFilter implements InputFilter {

    Pattern mPattern;

    //输入的最大金额
//    private static final int MAX_VALUE = Integer.MAX_VALUE;//2147483647
    private static final long MAX_VALUE = Long.MAX_VALUE;//

    //小数点后的位数
    private static final int POINTER_LENGTH = 2;

    private static final String POINTER = ".";

    private static final String ZERO = "0";

    public CashierInputFilter() {
        mPattern = Pattern.compile("([0-9]|\\.|\\,)*");
    }

    /**
     * @param source    新输入的字符串
     * @param start     新输入的字符串起始下标，一般为0
     * @param end       新输入的字符串终点下标，一般为source长度-1
     * @param dest      输入之前文本框内容
     * @param dstart    原内容起始坐标，一般为0
     * @param dend      原内容终点坐标，一般为dest长度-1
     * @return          输入内容
     */
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String sourceText = source.toString();
        String destText = dest.toString();

        //验证删除等按键
        if (TextUtils.isEmpty(sourceText)) {
            return "";
        }

        Matcher matcher = mPattern.matcher(source);
        //已经输入小数点的情况下，只能输入数字
        if(destText.contains(POINTER)) {
            if (!matcher.matches()) {
                return "";
            } else {
                if (POINTER.equals(source)) {  //只能输入一个小数点
                    return "";
                }
            }

            //验证小数点精度，保证小数点后只能输入两位
            int index = destText.indexOf(POINTER);
            int length = (destText.length() - 1) - index;

            if (length >= POINTER_LENGTH && dstart > index) {
                return dest.subSequence(dstart, dend);
            }
        } else {
            //没有输入小数点的情况下，只能输入小数点和数字，但首位不能输入小数点和0
            if (!matcher.matches()) {
                return "";
            } else {
//                if ((POINTER.equals(source) || ZERO.equals(source)) && TextUtils.isEmpty(destText)) {
                if ((POINTER.equals(source)) && TextUtils.isEmpty(destText)) {
                    return "";
                }
            }
        }

        //验证输入金额的大小
//        double sumText = Double.parseDouble(destText + sourceText);
        CharSequence sum = destText + sourceText;
        double sumText = Double.parseDouble(delComma(sum.toString()));
        if (sumText > MAX_VALUE) {
//            return dest.subSequence(dstart, dend);
            return formatMoneyAmount(MAX_VALUE);
        }
        return dest.subSequence(dstart, dend) + sourceText;
    }


    private String formatMoneyAmount(double amount){
        DecimalFormat formatVal =new DecimalFormat("###,###.00");
        return formatVal.format(amount);
    }

    private String delComma(String s) {
        String formatString = "";
        if (s != null && s.length() >= 1) {
            formatString = s.replaceAll(",", "");
        }

        return formatString;
    }

}