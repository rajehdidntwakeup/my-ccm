package project.cmm.myccm.core.model.response;

public class FopResponse {

	private String documentFile;

	/**
	 * Constructor.
	 *
	 */
	public FopResponse() {
		super();
	}

	/**
	 * Constructor.
	 *
	 * @param documentFile
	 */
	public FopResponse(String documentFile) {
		super();
		this.documentFile = documentFile;
	}

	/**
	 * Getter.
	 *
	 * @return the documentFile
	 */
	public String getDocumentFile() {
		return documentFile;
	}

	/**
	 * Setter.
	 *
	 * @param documentFile the documentFile to set
	 */
	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}

}
