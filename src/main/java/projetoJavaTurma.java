import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class projetoJavaTurma {

    public static void main(String[] args) {
        File fileTurmaJava = FileUtils.getFile("src/main/resources/InputTurmaJava.txt");
        File fileTurmaBD = FileUtils.getFile("src/main/resources/InputTurmaBD.txt");
        try {
            System.out.println("--------Turma Java-----------");
            FileUtils.readLines(fileTurmaJava, Charset.defaultCharset())
//                    .forEach(System.out::println);
                    .forEach(log::info);
            System.out.println("--------Turma BD-----------");
            FileUtils.readLines(fileTurmaBD, Charset.defaultCharset())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
