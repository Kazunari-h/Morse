package com.hal2016.kazunari.tweetapp05;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kazu on 15/04/11.
 */
public class Morse {

    /**
     * モールスクラス
     *
     */

    ArrayList<String> array = new ArrayList<String>();

    final String errConv = "-1";
    final char Zero = '0';
    final char One = '1';
    final char Two = '2';

    final String morseZero = "つー";
    final String morseOne = "と";
    final String morseOneLast = "っ";
    final String morseTwo = " ";

    private HashMap<String,String> map = new HashMap<String,String>();
    private HashMap<String,String> mapKana = new HashMap<String,String>();

    /**
     * 変換テーブルの設定。
     */
    Morse(){

        map.put("a", "102");
        map.put("b", "01112");
        map.put("c", "01012");
        map.put("d", "0112");
        map.put("e", "12");
        map.put("f", "11012");
        map.put("g", "0012");
        map.put("h", "11112");
        map.put("i", "112");
        map.put("j", "10002");
        map.put("k", "0102");
        map.put("l", "10112");
        map.put("m", "002");
        map.put("n", "012");
        map.put("o", "0002");
        map.put("p", "10012");
        map.put("q", "00102");
        map.put("r", "1012");
        map.put("s", "1112");
        map.put("t", "02");
        map.put("u", "1102");
        map.put("v", "11102");
        map.put("w", "1002");
        map.put("x", "01102");
        map.put("y", "01002");
        map.put("z", "00112");

        map.put(".", "1010102");
        map.put(",", "0011002");
        map.put("?", "1100112");
        map.put("-", "0111102");
        map.put("/", "011012");
        map.put("@", "1001012");

        map.put("イ","102");
        map.put("ロ","10102");
        map.put("ハ","01112");
        map.put("ニ","01012");
        map.put("ホ","0112");
        map.put("ヘ","12");
        map.put("ト","110112");
        map.put("チ","11012");
        map.put("リ","0012");
        map.put("ヌ","11112");
        map.put("ル","010012");
        map.put("ヲ","10002");
        map.put("ワ","0102");
        map.put("カ","10112");
        map.put("ヨ","002");
        map.put("タ","012");
        map.put("レ","0002");
        map.put("ソ","00012");
        map.put("ツ","10012");
        map.put("ネ","00102");
        map.put("ナ","1012");
        map.put("ラ","1112");
        map.put("ム","02");
        map.put("ウ","1102");
        map.put("ヰ","101102");
        map.put("ノ","11002");
        map.put("オ","101112");
        map.put("ク","11102");
        map.put("ヤ","1002");
        map.put("マ","01102");
        map.put("ケ","01002");
        map.put("フ","00112");
        map.put("コ","00002");
        map.put("エ","010002");
        map.put("テ","101002");
        map.put("ア","001002");
        map.put("サ","010102");
        map.put("キ","010112");
        map.put("ユ","011002");
        map.put("メ","011102");
        map.put("ミ","110102");
        map.put("シ","001012");
        map.put("ヱ","100112");
        map.put("ヒ","001102");
        map.put("モ","011012");
        map.put("セ","100012");
        map.put("ス","000102");
        map.put("ン","101012");

        map.put("゛","112");
        map.put("゜","110012");

        map.put("ヴ",map.get("ウ")+map.get("゛"));
        map.put("ガ",map.get("カ")+map.get("゛"));
        map.put("ギ",map.get("キ")+map.get("゛"));
        map.put("グ",map.get("ク")+map.get("゛"));
        map.put("ゲ",map.get("ケ")+map.get("゛"));
        map.put("ゴ",map.get("コ")+map.get("゛"));
        map.put("ザ",map.get("サ")+map.get("゛"));
        map.put("ジ",map.get("シ")+map.get("゛"));
        map.put("ズ",map.get("ス")+map.get("゛"));
        map.put("ゼ",map.get("セ")+map.get("゛"));
        map.put("ゾ",map.get("ソ")+map.get("゛"));
        map.put("ダ",map.get("タ")+map.get("゛"));
        map.put("ヂ",map.get("チ")+map.get("゛"));
        map.put("ヅ",map.get("ツ")+map.get("゛"));
        map.put("デ",map.get("テ")+map.get("゛"));
        map.put("ド",map.get("ト")+map.get("゛"));
        map.put("バ",map.get("ハ")+map.get("゛"));
        map.put("ビ",map.get("ヒ")+map.get("゛"));
        map.put("ブ",map.get("フ")+map.get("゛"));
        map.put("ベ",map.get("ヘ")+map.get("゛"));
        map.put("ボ",map.get("ホ")+map.get("゛"));
        map.put("パ",map.get("ハ")+map.get("゜"));
        map.put("ピ",map.get("ヒ")+map.get("゜"));
        map.put("プ",map.get("フ")+map.get("゜"));
        map.put("ペ",map.get("ヘ")+map.get("゜"));
        map.put("ポ",map.get("ホ")+map.get("゜"));


        for (Map.Entry<String, String> entry : map.entrySet()) {
            mapKana.put(entry.getValue(),entry.getKey());
        }

        map.put("本文","0110002");
        map.put("訂正終了","111012");

        map.put("ァ",map.get("ア"));
        map.put("ィ",map.get("イ"));
        map.put("ゥ",map.get("ウ"));
        map.put("ェ",map.get("エ"));
        map.put("ォ",map.get("オ"));
        map.put("ャ",map.get("ヤ"));
        map.put("ュ",map.get("ユ"));
        map.put("ョ",map.get("ヨ"));
        map.put("ッ",map.get("ツ"));

        mapKana.put("つ",String.valueOf(Zero));
        mapKana.put("ー","");
        mapKana.put(morseOne,String.valueOf(One));
        mapKana.put(morseOneLast,"");
        mapKana.put(morseTwo,String.valueOf(Two));

    }

    /**
     * 引数の値をつーととっ形式に変換するメソッド
     * @param text (カタカナ入力)
     * @return 文字列（つーとと形式）
     */

    public String displayMorse(String text){
        return ConvTuto(ConvNum(text));
    }

    /**
     * 引数の値を012形式で変換するメソッド
     * @param text (カタカナ入力)
     * @return 文字列(012形式)
     */
    public String ConvNum(String text){
        StringBuilder reText = new StringBuilder();
        try{
            for(int i=0;i<text.length();i++){
                int codeunit = text.codePointAt(i);
                if (0xffff < codeunit) {
                    reText.append(map.get(text.substring(i, i + 2)));
                    i++;
                } else {
                    reText.append(map.get(String.valueOf(text.charAt(i))));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            reText.delete(0,reText.length()-1);
            reText.append(errConv);
            return errConv;
        }
        return reText.toString();
    }


    /**
     * 引数の値をつーとと形式にして返すメソッド
     * @param reMorse (012形式)
     * @return 文字列 (つーとと形式)
     */
    public String ConvTuto(String reMorse){
        StringBuilder afterText =new StringBuilder();
        if(!reMorse.equals(errConv)) {
            for (int i = 0; i < reMorse.length(); i++) {
                char ch = reMorse.charAt(i);

                if (ch == Zero) {
                    afterText.append(morseZero);
                }else if (ch == One){
                    afterText.append(morseOne);
                    if(reMorse.charAt(i+1) != One){
                        afterText.append(morseOneLast);
                    }
                }else if(ch == Two) {
                    afterText.append(morseTwo);
                }
            }
        }else {
            afterText.delete(0,afterText.length()-1);
            afterText.append("エラーです。");
        }
        return afterText.toString();
    }

    /**
     * 引数をつーとと形式からカタカナ形式に戻すメソッド
     * @param text (つーとと形式)
     * @return 文字列 (カタカナ形式)
     */
    public String MorseKanaReverse(String text){
        return NumKanaReverse(MorseNumReverse(text));
    }

    /**
     * 引数をつーとと形式から012形式に戻すメソッド
     * @param text (つーとと形式)
     * @return 文字列 (012形式)
     */
    public String MorseNumReverse(String text){
        StringBuilder reText = new StringBuilder();

        System.out.println("******************"+text);

        for(int i=0;i<text.length();i++){

            if(String.valueOf(text.charAt(i)).equals("#")){
                break;
            }
            System.out.println(String.valueOf(text.charAt(i)));
            if (mapKana.get(String.valueOf(text.charAt(i))) != null){
                reText.append(mapKana.get(String.valueOf(text.charAt(i))));
            }else{
                System.out.println("================================================="+String.valueOf(text.charAt(i)));
                return null;
            }
        }

        return reText.toString();

    }

    /**
     * 引数を012形式からカタカナ形式に戻すメソッド
     * @param text (012形式)
     * @return 文字列 (カタカナ形式)
     */
    public String NumKanaReverse (String text){
        StringBuilder convText = new StringBuilder();
        try{
            String[] tweets = text.split("2");
            for (String tweet : tweets){
                convText.append(mapKana.get(tweet+"2"));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return convText.toString();
    }

}
