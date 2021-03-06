package ablack13.npsdk.request;

import ablack13.npsdk.common.Base_Request;

/**
 * Created by scijoker on 20.10.16.
 */

public class CounterpartyGetCounterpartyAddressesRequest extends Base_Request {
    public CounterpartyGetCounterpartyAddressesRequest(boolean isSender, String ref) {
        super("Counterparty", "getCounterpartyAddresses", new MethodProperties(isSender, ref));
    }

    private static class MethodProperties extends Base_MethodProperties {
        String Ref;
        String CounterpartyProperty;

        public MethodProperties(boolean isSender, String ref) {
            CounterpartyProperty = isSender ? "Sender" : "Recipient";
            Ref = ref;
        }
    }
}
