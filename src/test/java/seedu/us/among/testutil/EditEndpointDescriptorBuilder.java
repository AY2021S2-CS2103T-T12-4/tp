package seedu.us.among.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.us.among.model.endpoint.Address;
import seedu.us.among.model.endpoint.Email;
import seedu.us.among.model.endpoint.Endpoint;
import seedu.us.among.model.endpoint.Name;
import seedu.us.among.model.endpoint.Phone;
import seedu.us.among.model.tag.Tag;
import seedu.us.among.logic.commands.EditCommand;

/**
 * A utility class to help with building EditEndpointDescriptor objects.
 */
public class EditEndpointDescriptorBuilder {

    private EditCommand.EditEndpointDescriptor descriptor;

    public EditEndpointDescriptorBuilder() {
        descriptor = new EditCommand.EditEndpointDescriptor();
    }

    public EditEndpointDescriptorBuilder(EditCommand.EditEndpointDescriptor descriptor) {
        this.descriptor = new EditCommand.EditEndpointDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditEndpointDescriptor} with fields containing {@code endpoint}'s details
     */
    public EditEndpointDescriptorBuilder(Endpoint endpoint) {
        descriptor = new EditCommand.EditEndpointDescriptor();
        descriptor.setName(endpoint.getName());
        descriptor.setPhone(endpoint.getPhone());
        descriptor.setEmail(endpoint.getEmail());
        descriptor.setAddress(endpoint.getAddress());
        descriptor.setTags(endpoint.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditEndpointDescriptor} that we are building.
     */
    public EditEndpointDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditEndpointDescriptor} that we are building.
     */
    public EditEndpointDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditEndpointDescriptor} that we are building.
     */
    public EditEndpointDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditEndpointDescriptor} that we are building.
     */
    public EditEndpointDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditEndpointDescriptor}
     * that we are building.
     */
    public EditEndpointDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditCommand.EditEndpointDescriptor build() {
        return descriptor;
    }
}
