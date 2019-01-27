interface Report {
    void generate();
}

class PDFReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating PDF...");
    }
}

class DOCXReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating DOCX...");
    }
}

class ODFReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating ODF...");
    }
}

class ReportGenerator {
    private PDFReport pdfReport;
    private DOCXReport docxReport;
    private ODFReport odfReport;

    void generatePDF() {
        if (pdfReport==null) pdfReport = new PDFReport();
        pdfReport.generate();
    }

    void generateDOCX() {
        if (docxReport==null) docxReport = new DOCXReport();
        docxReport.generate();
    }
    void generateODF() {
        if (odfReport==null) odfReport = new ODFReport();
        odfReport.generate();
    }

}

public class FacadeMain {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateDOCX();
        reportGenerator.generateODF();
        reportGenerator.generatePDF();
        reportGenerator.generatePDF();
        reportGenerator.generatePDF();
        reportGenerator.generatePDF();
    }
}
