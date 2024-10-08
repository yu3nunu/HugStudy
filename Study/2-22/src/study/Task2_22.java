package study;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 本課題では、基本的な日付操作クラスの使い方を学びましょう。
 *
 * 問①から問③まであります。
 * 問②に関しては、コメントを記述して下さい。
 *
 * ※この課題に関しては課題実施日によって結果が異なるため、出力結果が個々で異なります。
 */
public class Task2_22 {

    public static void main(String args[]) {
        // Dateクラスのインスタンスを生成
        Date now = new Date();

        // 問① ローカル変数「now」を使用し、本日の日付を表示して下さい。
        System.out.println(now);

        // Calendarクラスのインスタンスを生成
        Calendar calendar = Calendar.getInstance();

        // 問② 「(Calendar.MONTH) + 数値」の処理は、想定していない値となる可能性があります。
        // その理由をコメントへ記述します。
        // [Calendar.MONTHは0から11の範囲で月を表すため、1月を1とすると実際には0から始まるため想定していない値となる]

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));

        // 問③ 上記の「calendar」を使用し、本日から1年2ヶ月15日先の日付を表示しなさい。
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.DATE, 15);

        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));

        // うるう年判定
        printLeapYear(calendar.get(Calendar.YEAR));
    }

    /**
     * うるう年判定
     * 問③で日付がズレる可能性があるため補足として出力
     * @param year
     */
    private static void printLeapYear(final int year) {
        System.out.println(year + "年は、うるう年" + (Year.isLeap(year) ? "です。" : "ではありません。"));
    }
}
