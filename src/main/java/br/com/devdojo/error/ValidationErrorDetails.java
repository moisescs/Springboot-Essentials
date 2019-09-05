package br.com.devdojo.error;


public class ValidationErrorDetails extends ErrorDetail {
	private String field;
	private String fieldMenssage;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldMenssage() {
		return fieldMenssage;
	}

	public void setFieldMenssage(String fieldMenssage) {
		this.fieldMenssage = fieldMenssage;
	}

	public static class Builder {
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;
		private String fieldMenssage;
		private String field;

		public static Builder newBuilder() {
			return new Builder();

		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}
		
		public Builder field(String field) {
			this.field = field;
			return this;
		}
		
		public Builder fieldMenssage(String fieldMenssage) {
			this.fieldMenssage = fieldMenssage;
			return this;
		}
		
		
		public Builder developerMenssage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
			validationErrorDetails.setTitle(this.title);
			validationErrorDetails.setStatus(this.status);
			validationErrorDetails.setDetail(this.detail);
			validationErrorDetails.setTimestamp(this.timestamp);
			validationErrorDetails.setDeveloperMessage(developerMessage);
			return validationErrorDetails;
		}
	}

}
