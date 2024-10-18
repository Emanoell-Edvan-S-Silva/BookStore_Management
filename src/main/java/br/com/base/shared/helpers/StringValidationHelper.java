package br.com.base.shared.helpers;

import br.com.base.shared.exceptions.IllegalValueException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StringValidationHelper {

    private String value;
    private String parameterName;

    public static StringValidationHelper validate(String value, String parameterName) {
        return new StringValidationHelper(value, parameterName);
    }

    public StringValidationHelper notNull() {
        if (this.value == null) {
            throwIllegalValueException("StringValidationHelper.ErrorMessage.NotNull");
        }
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public StringValidationHelper notEmpty() {
        if (this.value.trim().isEmpty()) {
            throwIllegalValueException("StringValidationHelper.ErrorMessage.NotEmpty");
        }
        return this;
    }

    public StringValidationHelper between(int minSize, int maxSize) {
        if (this.value.length() < minSize || this.value.length() > maxSize) {
            throwIllegalValueException("StringValidationHelper.ErrorMessage.Between", minSize, maxSize);
        }
        return this;
    }

    private void throwIllegalValueException(String messageCode, Object... args) {
        var exceptionMessage = String.format("%s %s", parameterName, messageCode, args);
        throw new IllegalValueException(exceptionMessage);
    }
}
