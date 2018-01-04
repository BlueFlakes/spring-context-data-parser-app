package scc.utils.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;

public class EnumUtils<E extends Enum<E>> {
    private static final Set<Class> approvedClasses = new HashSet<>();

    public Optional<E> getValue(Class<E> givenClass, final String identity) {
        optimizedValidation(givenClass);
        E[] enumConstants = givenClass.getEnumConstants();

        return findEnum(enumConstants, identity);
    }

    private void optimizedValidation(Class<E> givenClass) {
        if (!approvedClasses.contains(givenClass)) {

            if (!givenClass.isEnum())
                throw new IllegalArgumentException("Given class is not enum");

            approvedClasses.add(givenClass);
        }
    }

    private Optional<E> findEnum(E[] enumConstants, final String givenName) {
        BiPredicate<E, String> isEqualByName = (enumConst, identity) -> enumConst.toString()
                                                                                 .equals(identity);

        return Arrays.stream(enumConstants)
                     .filter(e -> isEqualByName.test(e, givenName))
                     .findFirst();
    }
}
