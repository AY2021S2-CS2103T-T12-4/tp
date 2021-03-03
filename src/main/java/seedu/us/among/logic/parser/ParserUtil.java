package seedu.us.among.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.us.among.commons.core.index.Index;
import seedu.us.among.commons.util.StringUtil;
import seedu.us.among.logic.parser.exceptions.ParseException;
import seedu.us.among.model.endpoint.Address;
import seedu.us.among.model.endpoint.Method;
import seedu.us.among.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser
 * classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading
     * and trailing whitespaces will be trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero
     *                        unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String method} into a {@code Method}. Leading and trailing
     * whitespaces will be trimmed.
     * @throws ParseException if the given {@code method} is invalid.
     */
    public static Method parseMethod(String method) throws ParseException {
        requireNonNull(method);
        String trimmedMethod = method.trim();
        if (!Method.isValidMethod(trimmedMethod)) {
            throw new ParseException(Method.MESSAGE_CONSTRAINTS);
        }
        return new Method(trimmedMethod);
    }

    /**
     * Parses a {@code String address} into an {@code Address}. Leading and trailing
     * whitespaces will be trimmed.
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}. Leading and trailing
     * whitespaces will be trimmed.
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
