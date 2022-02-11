package br.com.letscode;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ApplicationV2 {
    public static void main(String[] args) throws IOException {

        Multimap<String, String> map = ArrayListMultimap.create();

        File fileTurmaJava = FileUtils.getFile("src/main/resources/InputTurmaJava.txt");
        File fileTurmaBD = FileUtils.getFile("src/main/resources/InputTurmaBD.txt");

        var studentsJava = FileUtils.readLines(fileTurmaJava, Charset.defaultCharset());
        var studentsBD = FileUtils.readLines(fileTurmaBD, Charset.defaultCharset());

        //Criação de um Multimap onde a chave é o nome do aluno e os valores são as turmas que ele participa
        for (String student : studentsJava) {
            map.put(student, "Java");
        }
        for (String student : studentsBD) {
            map.put(student, "BD");
        }

        //Criação output Arquivo Java
        List<String> studentsJavaOutput = new ArrayList<>();
        studentsJavaOutput.add("Turma Java");
        studentsJavaOutput.add("Número de alunos: " + studentsJava.size());
        studentsJavaOutput.add("Lista de alunos: " + studentsJava);

        //Criação output Arquivo BD
        List<String> studentsBDOutput = new ArrayList<>();
        studentsBDOutput.add("Turma BD");
        studentsBDOutput.add("Número de alunos: " + studentsBD.size());
        studentsBDOutput.add("Lista de alunos: " + studentsBD);

        //Criação output Arquivo Escola
        var studentsSchoolOutput = map.keys().stream().distinct().sorted().toList();


        String diretorioOutput = "outputs".concat(File.separator);

        //OUTPUT - Arquivo turma Java
        var writeFilePathJava = diretorioOutput.concat("students-java.txt");
        File writeFileJava = FileUtils.getFile(writeFilePathJava);
        FileUtils.writeLines(writeFileJava,studentsJavaOutput,true);

        //OUTPUT - Arquivo turma BD
        var writeFilePathBD = diretorioOutput.concat("students-BD.txt");
        File writeFileBD = FileUtils.getFile(writeFilePathBD);
        FileUtils.writeLines(writeFileBD,studentsBDOutput,true);

        //OUTPUT - Arquivo todos os alunos da turma
        var writeFilePathSchool = diretorioOutput.concat("students-school.txt");
        File writeFileSchool = FileUtils.getFile(writeFilePathSchool);
        FileUtils.writeLines(writeFileSchool,studentsSchoolOutput,true);


    }
}
