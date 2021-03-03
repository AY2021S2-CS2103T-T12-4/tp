package seedu.us.among.testutil;

import static seedu.us.among.logic.commands.CommandTestUtil.VALID_ADDRESS_RANDOM;
import static seedu.us.among.logic.commands.CommandTestUtil.VALID_ADDRESS_FACT;
import static seedu.us.among.logic.commands.CommandTestUtil.VALID_METHOD_GET;
import static seedu.us.among.logic.commands.CommandTestUtil.VALID_METHOD_POST;
import static seedu.us.among.logic.commands.CommandTestUtil.VALID_TAG_COOL;
import static seedu.us.among.logic.commands.CommandTestUtil.VALID_TAG_CAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.us.among.model.EndpointList;
import seedu.us.among.model.endpoint.Endpoint;

/**
 * A utility class containing a list of {@code Endpoint} objects to be used in
 * tests.
 */
public class TypicalEndpoints {

        public static final Endpoint GET = new EndpointBuilder().withMethod("GET")
                        .withAddress("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2").withTags("cat").build();
        public static final Endpoint POST = new EndpointBuilder().withMethod("POST")
                        .withAddress("https://cat-fact.herokuapp.com/facts").withTags("cat", "fact").build();
        public static final Endpoint PUT = new EndpointBuilder().withMethod("PUT")
                        .withAddress("https://cat-fact.herokuapp.com/facts").build();
        public static final Endpoint DELETE = new EndpointBuilder().withMethod("DELETE")
                        .withAddress("https://cat-fact.herokuapp.com/facts").withTags("Fact").build();
        public static final Endpoint HEAD = new EndpointBuilder().withMethod("HEAD")
                        .withAddress("https://cat-fact.herokuapp.com/facts").build();
        public static final Endpoint OPTIONS = new EndpointBuilder().withMethod("OPTIONS")
                        .withAddress("https://cat-fact.herokuapp.com/facts").build();
        public static final Endpoint PATCH = new EndpointBuilder().withMethod("PATCH")
                        .withAddress("https://cat-fact.herokuapp.com/facts").build();

        // Manually added
        public static final Endpoint GET1 = new EndpointBuilder().withMethod("GET")
                        .withAddress("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2").build();
        public static final Endpoint GET2 = new EndpointBuilder().withMethod("GET")
                        .withAddress("https://cat-fact.herokuapp.com/facts").build();

        // Manually added - Endpoint's details found in {@code CommandTestUtil}
        public static final Endpoint GET3 = new EndpointBuilder().withMethod(VALID_METHOD_GET)
                        .withAddress(VALID_ADDRESS_RANDOM).withTags(VALID_TAG_COOL).build();
        public static final Endpoint POST1 = new EndpointBuilder().withMethod(VALID_METHOD_POST)
                        .withAddress(VALID_ADDRESS_FACT).withTags(VALID_TAG_CAT, VALID_TAG_COOL).build();

        public static final String KEYWORD_MATCHING_GET = "GET"; // A keyword that matches MEIER

        private TypicalEndpoints() {
        } // prevents instantiation

        /**
         * Returns an {@code EndpointList} with all the typical endpoints.
         */
        public static EndpointList getTypicalEndpointList() {
                EndpointList ab = new EndpointList();
                for (Endpoint endpoint : getTypicalEndpoints()) {
                        ab.addEndpoint(endpoint);
                }
                return ab;
        }

        public static List<Endpoint> getTypicalEndpoints() {
                return new ArrayList<>(Arrays.asList(GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH));
        }
}
