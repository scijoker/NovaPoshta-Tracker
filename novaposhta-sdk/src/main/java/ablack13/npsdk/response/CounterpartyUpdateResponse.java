package ablack13.npsdk.response;

import ablack13.npsdk.common.Base_Response;

/**
 * Created by scijoker on 20.11.16.
 */

public class CounterpartyUpdateResponse extends Base_Response {
    public Data[] data;

    public static class Data {
        public String Ref;
        public String Description;
        public String FirstName;
        public String MiddleName;
        public String LastName;
        public String Counterparty;
        public String OwnershipForm;
        public String OwnershipFormDescription;
        public String EDRPOU;
        public String CounterpartyType;
        public ContactPerson ContactPerson;

        public static class ContactPerson {
            public boolean success;
            public InnerData[] data;
            public Error[] errors;
            public Warning[] warnings;
            public Info[] info;

            public static class InnerData extends Base_Data {
            }

            public static class Error extends Base_Error {
            }

            public static class Warning extends Base_Warning {
            }

            public static class Info extends Base_Info {
            }
        }
    }
}
