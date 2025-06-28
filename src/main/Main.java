package main;

import manager.*;
import model.*;
import java.util.Date;
//import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting OOP System Demo ---");

        // Initialize Managers
        AlunoManager alunoManager = new AlunoManager();
        ProfessorManager professorManager = new ProfessorManager();
        AtendenteManager atendenteManager = new AtendenteManager();
        CursoManager cursoManager = new CursoManager();
        AssinaturaManager assinaturaManager = new AssinaturaManager();

        System.out.println("\n--- Aluno CRUD Operations ---");
        // Create Alunos
        Aluno aluno1 = new Aluno(1, "Alice Silva", "11987654321", new Date(), "Java Basics", 50);
        Aluno aluno2 = new Aluno(2, "Bruno Costa", "11912345678", new Date(), "Python Advanced", 30);
        alunoManager.addAluno(aluno1);
        alunoManager.addAluno(aluno2);
        alunoManager.addAluno(aluno1); // Attempt to add duplicate

        // List Alunos
        System.out.println("\nAll Alunos:");
        alunoManager.getAllAlunos().forEach(System.out::println);

        // Get Aluno by ID
        Optional<Aluno> foundAluno = alunoManager.getAlunoById(1);
        foundAluno.ifPresent(al -> System.out.println("\nFound Aluno by ID 1: " + al.getNome()));

        // Update Aluno
        aluno1.setPontos(75);
        aluno1.setAulaAtual("Java Intermediate");
        alunoManager.updateAluno(aluno1);
        System.out.println("\nUpdated Aluno 1: " + alunoManager.getAlunoById(1).get());

        // Aluno actions
        aluno1.entregarExercicio();
        System.out.println("Aluno 1 pontos after exercise: " + aluno1.getPontos());

        // Delete Aluno
        alunoManager.deleteAluno(2);
        System.out.println("\nAlunos after deletion:");
        alunoManager.getAllAlunos().forEach(System.out::println);

        System.out.println("\n--- Professor CRUD Operations ---");
        // Create Professor
        Professor prof1 = new Professor(101, "Dr. Carlos Santos", "11998877665");
        professorManager.addProfessor(prof1);

        // Professor actions
        Curso javaCourse = new Curso(1001, "Java Programming", 0.0);
        cursoManager.addCurso(javaCourse);
        prof1.getCursos().add(javaCourse); // Add a course to professor
        prof1.corrigirExercicio(aluno1, javaCourse, true);
        System.out.println("Professor 1 records: " + prof1.getAlunoExercicio());

        System.out.println("\n--- Atendente CRUD Operations ---");
        // Create Atendente
        Atendente atendente1 = new Atendente(201, "Fernanda Lima", "Suporte", "11911223344");
        atendenteManager.addAtendente(atendente1);

        // Atendente actions
        atendente1.efetuarAssinatura(aluno1.getId());
        atendente1.atenderUsuario(aluno1.getId());
        System.out.println("Atendente 1 historico: " + atendente1.getHistorico());

        System.out.println("\n--- Curso CRUD Operations ---");
        // Create Curso
        Curso pythonCourse = new Curso(1002, "Python for Data Science", 0.0);
        cursoManager.addCurso(pythonCourse);

        // Calculate progress for a course
        cursoManager.getCursoById(1001).ifPresent(course -> {
            course.calcularProgresso(alunoManager.getAllAlunos(), course);
        });

        System.out.println("\n--- Assinatura CRUD Operations ---");
        // Create Assinatura
        Assinatura ass1 = new Assinatura(1, aluno1.getId(), "Premium Anual", 1200.00, "NF-001", "VIA-ABC");
        assinaturaManager.addAssinatura(ass1);

        // Assinatura actions
        ass1.emitirFatura(ass1.getIdAssinatura());
        ass1.imprimirPlano(ass1.getIdAssinatura());

        System.out.println("\n--- Demo Complete ---");
    }
}
