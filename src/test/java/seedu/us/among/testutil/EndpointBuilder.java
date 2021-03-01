package seedu.us.among.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.us.among.model.endpoint.Address;
import seedu.us.among.model.endpoint.Endpoint;
import seedu.us.among.model.endpoint.Name;
import seedu.us.among.model.tag.Tag;
import seedu.us.among.model.util.SampleDataUtil;

/**
 * A utility class to help with building Endpoint objects.
 */
public class EndpointBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Address address;
    private Set<Tag> tags;

    /**
     * Creates a {@code EndpointBuilder} with the default details.
     */
    public EndpointBuilder() {
        name = new Name(DEFAULT_NAME);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the EndpointBuilder with the data of {@code endpointToCopy}.
     */
    public EndpointBuilder(Endpoint endpointToCopy) {
        name = endpointToCopy.getName();
        address = endpointToCopy.getAddress();
        tags = new HashSet<>(endpointToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Endpoint} that we are building.
     */
    public EndpointBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Endpoint} that we are building.
     */
    public EndpointBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Endpoint} that we are building.
     */
    public EndpointBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    public Endpoint build() {
        return new Endpoint(name, address, tags);
    }

}
