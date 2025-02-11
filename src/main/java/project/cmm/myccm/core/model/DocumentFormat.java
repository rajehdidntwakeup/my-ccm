package project.cmm.myccm.core.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DocumentFormat {

    @Id
    @SequenceGenerator(name = "seqDocFormatID", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDocFormatID")
    @Column(name = "doc_format_id")
    private long docFormatId;
    @Column(nullable = false)
    private String documentType;
    @Enumerated(EnumType.STRING)
    private ColorType colorType = ColorType.CO;
    @Column(nullable = false)
    private String styleSheetPath;
    @Column(nullable = false)
    private int pageCount = 1;
    @Column(nullable = false)
    private int sheetCount = 1;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "documentFormat")
    private List<Document> documents = new ArrayList<>(1);

    /**
     * Constructor.
     */
    public DocumentFormat() {
        super();
    }

    /**
     * Constructor.
     *
     * @param docFormatId
     * @param documentType
     * @param colorType
     * @param styleSheetPath
     * @param pageCount
     * @param sheetCount
     * @param company
     * @param documents
     */
    public DocumentFormat(long docFormatId, String documentType, ColorType colorType, String styleSheetPath,
                          int pageCount, int sheetCount, Company company, List<Document> documents) {
        super();
        this.docFormatId = docFormatId;
        this.documentType = documentType;
        this.colorType = colorType;
        this.styleSheetPath = styleSheetPath;
        this.pageCount = pageCount;
        this.sheetCount = sheetCount;
        this.company = company;
        this.documents = documents;
    }

    /**
     * Getter.
     *
     * @return the docFormatId
     */
    public long getDocFormatId() {
        return docFormatId;
    }

    /**
     * Setter.
     *
     * @param docFormatId the docFormatId to set
     */
    public void setDocFormatId(long docFormatId) {
        this.docFormatId = docFormatId;
    }

    /**
     * Getter.
     *
     * @return the documentType
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Setter.
     *
     * @param documentType the documentType to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Getter.
     *
     * @return the colorType
     */
    public ColorType getColorType() {
        return colorType;
    }

    /**
     * Setter.
     *
     * @param colorType the colorType to set
     */
    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    /**
     * Getter.
     *
     * @return the styleSheetPath
     */
    public String getStyleSheetPath() {
        return styleSheetPath;
    }

    /**
     * Setter.
     *
     * @param styleSheetPath the styleSheetPath to set
     */
    public void setStyleSheetPath(String styleSheetPath) {
        this.styleSheetPath = styleSheetPath;
    }

    /**
     * Getter.
     *
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Setter.
     *
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Getter.
     *
     * @return the sheetCount
     */
    public int getSheetCount() {
        return sheetCount;
    }

    /**
     * Setter.
     *
     * @param sheetCount the sheetCount to set
     */
    public void setSheetCount(int sheetCount) {
        this.sheetCount = sheetCount;
    }

    /**
     * Getter.
     *
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Setter.
     *
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Getter.
     *
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Setter.
     *
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
