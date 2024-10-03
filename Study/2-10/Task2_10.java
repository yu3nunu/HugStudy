/**
* Task2-10 : 課題内容
*
* 本課題では、ルーブ文に記述に慣れていきましょう。
* 問①〜問④まであります。
* for文・while文の仕組みを意識しながらコーディングしていきましょう！
*/
public class Task2_10 {

    public static void main(String[] args) {

        // ① 「みかん」、「りんご」、「ぶどう」、「メロン」の値を設定した配列 fruits を作成してください。
        String[] fruits = {"みかん", "りんご", "ぶどう", "メロン"};

        // ② for文を使って①で作成した配列を出力しなさい。
        for (int j = 0; j < fruits.length; j++) {
            System.out.println(fruits[j]);
        }

        // ③ 以下のwhile文の処理について、何をしているのかコメントを記入してください。
        /*
        * [1から50までを出力]
        */
        int i = 1;
        while (i <= 50) {
            System.out.print(i); 
            i++;
        }
        System.out.println(); 

         /* ④ 行の最初に「段数」と「||」を追加したものを表示させるプログラムを作成しなさい。
        * 5 || 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45 |
        * 6 || 6 | 12 | 18 | 24 | 30 | 36 | 42 | 48 | 54 |
        * 7 || 7 | 14 | 21 | 28 | 35 | 42 | 49 | 56 | 63 |
        * 8 || 8 | 16 | 24 | 32 | 40 | 48 | 56 | 64 | 72 |
        * 9 || 9 | 18 | 27 | 36 | 45 | 54 | 63 | 72 | 81 |
        */
        printMultiplicationTable(5, 9);
    }

    public static void printMultiplicationTable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ||");
            for (int j = 1; j <= 9; j++) {
                System.out.print(" " + (i * j) + " |");
            }
            System.out.println(); 
        }
    }
}