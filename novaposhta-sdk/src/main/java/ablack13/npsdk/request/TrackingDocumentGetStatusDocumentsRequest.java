package ablack13.npsdk.request;

import ablack13.npsdk.common.Base_Request;

/**
 * Created by scijoker on 15.10.16.
 */

public class TrackingDocumentGetStatusDocumentsRequest extends Base_Request {
    public TrackingDocumentGetStatusDocumentsRequest(String phone, String... documents) {
        super("TrackingDocument", "getStatusDocuments", new GetStatusDocumentsMethodProperties(phone, documents));
    }

    private static class GetStatusDocumentsMethodProperties extends Base_MethodProperties {
        public String[] Documents;
        public String Phone;

        public GetStatusDocumentsMethodProperties(String phone, String... documents) {
            this.Phone = "38" + phone;
            this.Documents = documents;
        }
    }
}
