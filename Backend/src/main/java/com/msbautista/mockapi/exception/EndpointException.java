package com.msbautista.mockapi.exception;

public class EndpointException {

    public static class EndpointDoesNotExists extends RejectException {

        public EndpointDoesNotExists(String endpointName) {
            super("The endpoint " + endpointName + " does not exists");
        }
    }

    public static class EndpointAlreadyExists extends RejectException {

        public EndpointAlreadyExists(String endpointName) {
            super("The endpoint " + endpointName + " already exists");
        }
    }

}
