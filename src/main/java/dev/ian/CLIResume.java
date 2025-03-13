package dev.ian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CLIResume {
    private static final Map<String, Runnable> commands = new HashMap<>();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        initializeCommands();

        System.out.println(ANSI_GREEN + "Welcome to My Interactive Resume!" + ANSI_RESET);
        System.out.println("Type 'help' to see available commands or 'exit' to quit.");

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(ANSI_YELLOW + "\n> " + ANSI_RESET);
            input = scanner.nextLine().trim().toLowerCase();

            if (commands.containsKey(input)) {
                commands.get(input).run();
            } else if (!input.equals("exit")) {
                System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        } while (!input.equals("exit"));

        System.out.println(ANSI_GREEN + "Thank you for viewing my resume! Goodbye!" + ANSI_RESET);
        scanner.close();
    }

    private static void initializeCommands() {
        commands.put("help", CLIResume::showHelp);
        commands.put("about", CLIResume::showAbout);
        commands.put("skills", CLIResume::showSkills);
        commands.put("experience", CLIResume::showExperience);
        commands.put("education", CLIResume::showEducation);
        commands.put("projects", CLIResume::showProjects);
        commands.put("community", CLIResume::showCommunity);
        commands.put("contact", CLIResume::showContact);
    }

    private static void showHelp() {
        System.out.println(ANSI_PURPLE + "AVAILABLE COMMANDS:" + ANSI_RESET);
        System.out.println("  about      - Display personal information");
        System.out.println("  skills     - List technical and soft skills");
        System.out.println("  experience - Show work experience");
        System.out.println("  education  - Display educational background");
        System.out.println("  projects   - Showcase personal and professional projects");
        System.out.println("  community  - Show community building activities");
        System.out.println("  contact    - Display contact information");
        System.out.println("  help       - Show this help message");
        System.out.println("  exit       - Exit the application");
    }

    private static void showAbout() {
        System.out.println(ANSI_BLUE + "ABOUT ME" + ANSI_RESET);
        System.out.println("Name: Ian Dancan");
        System.out.println("Title: Java Developer & Community Builder");
        System.out.println("Location: Nyeri");
        System.out.println("\nI am a passionate Java developer with 3 years of experience building robust");
        System.out.println("applications and services. I enjoy solving complex problems and sharing knowledge");
        System.out.println("through community building activities. I'm dedicated to writing clean, maintainable");
        System.out.println("code and contributing to open-source projects.");
    }

    private static void showSkills() {
        System.out.println(ANSI_BLUE + "TECHNICAL SKILLS" + ANSI_RESET);
        printSkillSection("Languages", Arrays.asList(
                "Java/ (3 years)", "SQL", "Go", "Solidity"
        ));

        printSkillSection("Frameworks & Libraries", Arrays.asList(
                "Spring Boot", "Hibernate", "JUnit", "Maven", "Spring Security"
        ));

        printSkillSection("Tools & Platforms", Arrays.asList(
                "Git", "Docker", "Azure", "AWS", "IntelliJ IDEA"
        ));

        System.out.println(ANSI_BLUE + "\nSOFT SKILLS" + ANSI_RESET);
        printSkillSection("Professional", Arrays.asList(
                "Problem-solving", "Team collaboration", "Technical writing",
                "Public speaking", "Community management", "Project management"
        ));
    }

    private static void printSkillSection(String title, List<String> skills) {
        System.out.println(title + ":");
        for (int i = 0; i < skills.size(); i++) {
            System.out.print("  • " + skills.get(i));
            if ((i + 1) % 3 == 0 || i == skills.size() - 1) {
                System.out.println();
            } else {
                System.out.print("  ");
            }
        }
    }

    private static void showExperience() {
        System.out.println(ANSI_BLUE + "WORK EXPERIENCE" + ANSI_RESET);

        printExperience(
                "System Design Engineer & Architect",
                "ChamaDAO",
                "May 2024 - Present",
                Arrays.asList(
                        "Designed and implemented the architecture for a blockchain-based application, ChamaDAO",
                        "Led a team of 3 developers in building the application from scratch",
                        "Actively involved in project management, code reviews, and technical documentation",
                        "Involved in designing the ap flow and implementing smart contracts using Solidity"
                )
        );

        printExperience(
                "Project Manager",
                "Bitnorm",
                "Oct 2024 - Dec 2024",
                Arrays.asList(
                        "Led a team of 8 developers in building a blockchain-based application",
                        "Managed project scope, timeline, and resources",
                        "Coordinated with stakeholders to gather requirements and feedback",
                        "Delivered the project on time and within budget"
                )
        );

        printExperience(
                "Backend Developer",
                "Spaceyatech",
                "Oct 2023 - Oct 2024",
                Arrays.asList(
                        "Developed and maintained mentorlst using Spring Boot and AWS",
                        "Improved application performance by 30% through code optimization",
                        "Documented API endpoints and architecture for future reference",
                        "Actively participated in code reviews and knowledge sharing sessions"
                )
        );
    }

    private static void printExperience(String title, String company, String period, List<String> responsibilities) {
        System.out.println(title + " at " + company + " (" + period + ")");
        for (String responsibility : responsibilities) {
            System.out.println("  • " + responsibility);
        }
        System.out.println();
    }

    private static void showEducation() {
        System.out.println(ANSI_BLUE + "EDUCATION" + ANSI_RESET);
        System.out.println("Bachelor of Science in Mechanical Engineering");
        System.out.println("Dedan Kimathi University of Technology, Graduation - 2026");
        //System.out.println("  • GPA: 3.8/4.0");
        System.out.println("  • Relevant coursework: Java, Algorithms, Database Management, Mechanical Design, Fluid Mechanics");
        System.out.println("\nCertifications:");
        System.out.println("  • Oracle Certified Professional: Java SE 11 Developer");
        System.out.println("  • AWS Certified Developer - Associate");
    }

    private static void showProjects() {
        System.out.println(ANSI_BLUE + "PROJECTS" + ANSI_RESET);

        printProject(
                "E-commerce Platform",
                "An e-commerce application built with Spring Boot",
                Arrays.asList(
                        "Implemented user authentication and authorization",
                        "Created RESTful APIs for product management",
                        "Integrated payment gateway and order processing"
                ),
                ""
        );
        printProject(
                "CLI Resume",
                "An interactive command-line resume (this application)",
                Arrays.asList(
                        "Created with pure Java",
                        "Implemented a command pattern for menu options",
                        "Added color formatting for better user experience"
                ),
                "https://github.com/Dancan254/ResumeCLI"
        );
    }

    private static void printProject(String name, String description, List<String> features, String link) {
        System.out.println(name + " - " + description);
        for (String feature : features) {
            System.out.println("  • " + feature);
        }
        System.out.println("  Link: " + link);
        System.out.println();
    }

    private static void showCommunity() {
        System.out.println(ANSI_BLUE + "COMMUNITY BUILDING" + ANSI_RESET);

        System.out.println("Java Developers Meetup - Organizer (Kenya Java User Group)");
        System.out.println("  • Organize monthly meetups for 100+ Java developers");
        System.out.println("  • Coordinate speakers and workshop facilitators");
        System.out.println("  • Create an inclusive environment for knowledge sharing");
        System.out.println();

        System.out.println("Tech Blog - Author");
        System.out.println("  • Write technical articles on Java development");
        System.out.println("  • Share best practices and tutorials");
        //System.out.println("  • 5000+ monthly readers");
        System.out.println();

        System.out.println("Open Source Contributions");
        System.out.println("  • Active contributor to Lib management system");
        System.out.println("  • Helped new contributors with onboarding");
        System.out.println("  • Fixed bugs and implemented new features");
    }

    private static void showContact() {
        System.out.println(ANSI_BLUE + "CONTACT INFORMATION" + ANSI_RESET);
        System.out.println("Email: ////");
        System.out.println("LinkedIn: linkedin.com/in/ian-dancan");
        System.out.println("GitHub: github.com/Dancan254");
        System.out.println("Twitter: @your_javaguy");
        System.out.println("\nFeel free to reach out for collaborations or opportunities!");
    }
}