package task2_23;

import java.util.ArrayList;

import constants.Constants;
import language.Student;
import person.Person;

public class Task2_23 {

    public static void main(String[] args) {
        // Personクラスのインスタンスを格納するArrayListクラス型の変数persons
        ArrayList<Person> persons = new ArrayList<Person>();

        // ① Personクラスの変数名「yamada」というインスタンスを作成
        // 引数には1:山田太郎 2:Java を入れて下さい。
        Student yamada = new Student("山田太郎", Constants.LANGUAGE_JAVA);
        persons.add(yamada); // personsリストに追加

        // ② 作成した変数「yamada」を利用し名前を表示
        System.out.println(yamada.getName());

        // ③ Personクラスの変数名「ishitani」というインスタンスを作成
        // 引数には1:石谷花子 2:HTML を入れて下さい。
        Student ishitani = new Student("石谷花子", Constants.LANGUAGE_HTML);
        persons.add(ishitani); // personsリストに追加

        // ④ 作成した変数「ishitani」を利用し学んでいる言語を表示
        System.out.println(ishitani.getLanguage());

        // ⑤ 「〇〇が△△を学んでいます」という表示で山田さん、石谷さんが何を学んでいるか出力
        yamada.studyLanguage();
        ishitani.studyLanguage();
    }
}
