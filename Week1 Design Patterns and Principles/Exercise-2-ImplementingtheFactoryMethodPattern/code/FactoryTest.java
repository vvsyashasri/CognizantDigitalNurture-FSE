package factory;

import java.util.Scanner;

public class FactoryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentFactory factory = null;

        System.out.println("Choose document type: Word / PDF / Excel");
        String type = scanner.nextLine().toLowerCase();

        switch (type) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Unknown document type.");
                scanner.close();
                return;
        }

        Document doc = factory.createDocument();
        doc.open();

        scanner.close();
    }
}
